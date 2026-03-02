import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, catchError, Observable, tap, throwError} from 'rxjs';
import {Router} from '@angular/router';
import {ConnecterRequest} from '../model/requests/connecter-request.model';
import {TokenResponse} from '../model/responses/token.response';
import {InscriptionRequest} from '../model/requests/inscription-request.model';
import {TokenRequest} from '../model/requests/token.request';
import {jwtDecode} from 'jwt-decode';
import {ConnecterResponse} from '../model/responses/connecter-response.model';
import {UtilisateurResponse} from '../model/responses/utilisateur-response.model';
import {
  ACCESS_TOKEN, CURRENT_USER,
  REFRESH_TOKEN, URL_API_AUTH,
  URL_BACKEND, URL_CONNECTER,
  URL_DECONNECTER, URL_INSCRIPTION
} from '../constants/global.constants';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  private authUrl = URL_BACKEND+URL_API_AUTH;
  private currentUserSubject = new BehaviorSubject<UtilisateurResponse | null>(null); // Stocke les données de l'utilisateur
  public currentUser$ = this.currentUserSubject.asObservable(); // Observable pour les composants

  constructor(private http: HttpClient,private router: Router) {
  }

  connecter(connecterRequest: ConnecterRequest) {
    return this.http.post<ConnecterResponse>(this.authUrl+URL_CONNECTER, connecterRequest)
      .pipe(
        tap(response => {
            localStorage.setItem(REFRESH_TOKEN, response.tokenResponse.refreshToken);
            localStorage.setItem(ACCESS_TOKEN, response.tokenResponse.accessToken);
            this.currentUserSubject.next(response.utulisateurResponse);
            localStorage.setItem(CURRENT_USER, JSON.stringify(response.utulisateurResponse));
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
    return this.http.post<TokenResponse>(this.authUrl+UrlPath, tokenRequest);
  }

  checkRefreshToken():boolean{
      return !this.isTokenExpired(REFRESH_TOKEN)
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
    if(localStorage.getItem(REFRESH_TOKEN)==null)
    {
      return throwError(() => console.error("!!! No Refresh Token Found !!!"));
    }
    let requestToken:TokenRequest = {
      accessToken  : localStorage.getItem(ACCESS_TOKEN)  || '',
      refreshToken : localStorage.getItem(REFRESH_TOKEN) || ''
    };

    return this.http.post(this.authUrl+URL_DECONNECTER, requestToken);
  }

  private cleanClientAuth() {
    this.currentUserSubject.next(null);
    localStorage.removeItem(CURRENT_USER);
    localStorage.removeItem(ACCESS_TOKEN);
    localStorage.removeItem(REFRESH_TOKEN);
  }

  private setClientToken(tokenResponse:TokenResponse) {
    localStorage.setItem(ACCESS_TOKEN, tokenResponse.accessToken)
    localStorage.setItem(REFRESH_TOKEN, tokenResponse.refreshToken)
  }

  getCurrentUser(): any {
    return this.currentUserSubject.value;
  }

  getToken(): TokenRequest {
    const token:TokenRequest = {
       accessToken:localStorage.getItem(ACCESS_TOKEN),
       refreshToken:localStorage.getItem(REFRESH_TOKEN)
    }
    return token;
  }

  isAuthenticated(): boolean {
    return !this.isTokenExpired(ACCESS_TOKEN);
  }

  isTokenExpired(tokenType:string): boolean {
    const decoded: any = this.getDecodedToken(tokenType);
    if (!decoded) return true;

    const expiration = decoded.exp * 1000;

    return Date.now() > expiration;
  }

  getDecodedToken(tokenType:string): any | null {
    let token:string | null = '';
    if(REFRESH_TOKEN.includes(tokenType))
    {
       token = this.getRefreshToken();
    }
    if(ACCESS_TOKEN.includes(tokenType))
    {
      token = this.getAccessToken();
    }

    if (!token) return null;

    return jwtDecode(token);
  }

  getAccessToken(): string | null {
    return localStorage.getItem(ACCESS_TOKEN);
  }

  getRefreshToken(): string | null {
    return localStorage.getItem(REFRESH_TOKEN);
  }

}
