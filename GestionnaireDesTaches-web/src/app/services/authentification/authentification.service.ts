import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, catchError, Observable, tap, throwError} from 'rxjs';
import {Router} from '@angular/router';
import {ConnecterRequest} from '../../model/requests/connecter-request.model';
import {TokenResponse} from '../../model/responses/token.response';
import {InscriptionRequest} from '../../model/requests/inscription-request.model';
import {TokenRequest} from '../../model/requests/token.request';
import {jwtDecode} from 'jwt-decode';
import {ConnecterResponse} from '../../model/responses/connecter-response.model';
import {UtilisateurResponse} from '../../model/responses/utilisateur-response.model';
import { CURRENT_USER, URL_API_AUTH,
  URL_BACKEND, URL_CONNECTER,
  URL_DECONNECTER, URL_INSCRIPTION
} from '../../constants/global.constants';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  private authUrl = URL_BACKEND+URL_API_AUTH;
  private currentUserSubject = new BehaviorSubject<UtilisateurResponse | null>(null); // Stocke les données de l'utilisateur
  public currentUser$ = this.currentUserSubject.asObservable(); // Observable pour les composants

  private accessToken: string | null = null;

  constructor(private http: HttpClient,private router: Router) {
  }

  connecter(connecterRequest: ConnecterRequest) {
    return this.http.post<ConnecterResponse>(this.authUrl+URL_CONNECTER, connecterRequest,{withCredentials: true})
      .pipe(
        tap(response => {
            this.accessToken = response.tokenResponse.accessToken;
            this.currentUserSubject.next(response.utilisateurResponse);
            localStorage.setItem(CURRENT_USER, JSON.stringify(response.utilisateurResponse));
          }
        ),
        catchError((error):any => {
            console.error('Login failed', error);
            throw error; // Renvoyez l'erreur pour la gérer dans le composant
          }
        )
      );
  }

  inscription(inscriptionRequest: InscriptionRequest) {
    return this.http.post(this.authUrl+URL_INSCRIPTION, inscriptionRequest);
  }

  refreshTokenBackend(UrlPath:string) {
    const tokenRequest: TokenRequest = this.getToken();
    return this.http.post<TokenResponse>(this.authUrl+UrlPath, tokenRequest,{withCredentials: true});
  }

  refreshTokenProcess(UrlPath:string): Observable<TokenResponse> {

    return this.refreshTokenBackend(UrlPath).pipe(

      tap((tokenResponse: TokenResponse) => {
        this.setClientToken(tokenResponse);
      }),

      catchError(error => {
        console.error("!!! Backend Can't Generate Refresh Token !!!");
        return throwError(() => error);
      })
    );
  }

  deconnexionProcess(){
    this.deconnexion();
    this.router.navigate([URL_DECONNECTER]);
  }

  deconnexion() {
    this.deconnexionBackend().subscribe({
      next: () => {
        this.cleanClientAuth();
      },
      error: () => {
        this.cleanClientAuth();
      }
    });
  }

  deconnexionBackend() {
    const requestToken:TokenRequest = {
      accessToken:this.accessToken,
    }
    return this.http.post(this.authUrl+URL_DECONNECTER, requestToken,{withCredentials: true});
  }

  private cleanClientAuth() {
    this.currentUserSubject.next(null);
    localStorage.removeItem(CURRENT_USER);
    this.accessToken=null;
  }

  private setClientToken(tokenResponse:TokenResponse) {
    this.accessToken=tokenResponse.accessToken;
  }

  getCurrentUser():UtilisateurResponse | null {
    return this.currentUserSubject.value;
  }

  getToken(): TokenRequest {
    const token:TokenRequest = {
       accessToken:this.accessToken,
    }
    return token;
  }

  isAuthenticated(): boolean {
    return !this.isTokenExpired();
  }

  isTokenExpired(): boolean {
    const decoded: any = this.getDecodedToken();
    if (!decoded) return true;

    const expiration = decoded.exp * 1000;

    return Date.now() > expiration;
  }

  getDecodedToken(): any | null {
    let token:string | null = '';
    token = this.getAccessToken();

    if (!token) return null;

    return jwtDecode(token);
  }

  getAccessToken(): string | null {
    return this.accessToken;
  }

  setAccessToken(token: string) {
    this.accessToken = token;
  }

}
