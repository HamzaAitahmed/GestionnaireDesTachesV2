import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, catchError, Observable, tap} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  private authUrl = 'http://localhost:8088/api/Auth';
  private currentUserSubject = new BehaviorSubject<any>(null); // Stocke les données de l'utilisateur
  public currentUser$ = this.currentUserSubject.asObservable(); // Observable pour les composants


  constructor(private http: HttpClient,private router: Router) {
    const storedUser = localStorage.getItem('currentUser');
    if (storedUser) {
      this.currentUserSubject.next(JSON.parse(storedUser)); // Récupérer l'utilisateur depuis LocalStorage
    }
  }

  login(email: string, password: string): Observable<any> {
    return this.http.post(`${this.authUrl}/connecter`, { email, password }).pipe(
      tap((user) => {
        this.currentUserSubject.next(user);
        localStorage.setItem('currentUser', JSON.stringify(user));
      }),
      catchError((error):any => {
        console.error('Login failed', error);
        throw error; // Renvoyez l'erreur pour la gérer dans le composant
      })
    );
  }

  inscription(username: string, email: string, password: string, confirmerpassword: string): Observable<any> {
    return this.http.post(`${this.authUrl}/inscription`, { username, email, password, confirmerpassword });
  }

  logout(): void {
    this.http.post(`${this.authUrl}/deconnecter`, {}).subscribe({
      next: (response: any) => {
        console.log("Logout response:", response.message); // Access the JSON response
        this.currentUserSubject.next(null); // Effacez les données de l'utilisateur
        localStorage.removeItem('currentUser'); // Supprimer du LocalStorage
        console.log("logout redirect");
        this.router.navigate(['/deconnecter']); // Redirigez vers la page de connexion
      },
      error: (error) => {
        console.error('Logout failed', error);
        this.currentUserSubject.next(null); // Forcez la déconnexion même en cas d'erreur
        localStorage.removeItem('currentUser');
        console.error('Logout failed', error);
      }
    });
  }

  getCurrentUser(): any {
    return this.currentUserSubject.value;
  }

}
