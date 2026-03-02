import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthentificationService} from '../../services/authentification.service';
import {UtilisateurResponse} from '../../model/responses/utilisateur-response.model';
import {ConnecterRequest} from '../../model/requests/connecter-request.model';
import {BehaviorSubject} from 'rxjs';
import {CURRENT_USER, ROUTE_MAIN} from '../../constants/global.constants';

@Component({
  selector: 'app-deconnecter',
  standalone: false,
  templateUrl: './deconnecter.component.html',
  styleUrl: './deconnecter.component.css'
})
export class DeconnecterComponent implements OnInit{
  logoutForm: FormGroup;
  user: { username: string, email: string, profilePicture: string } = { username: '', email: '', profilePicture: '' }; // Informations de l'utilisateur
  utilisateurDeconnecter:UtilisateurResponse | null = null;
  private currentUserSubject = new BehaviorSubject<UtilisateurResponse | null>(null); // Stocke les données de l'utilisateur
  public currentUser$ = this.currentUserSubject.asObservable(); // Observable pour les composants
  errorMessage:string = '';

  constructor(private fb: FormBuilder, private router: Router,private authService: AuthentificationService) {
    this.logoutForm = this.fb.group({
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.deconnexionClicked();
  }

  reconnecter() {
    if (this.logoutForm.valid) {
      const { password } = this.logoutForm.value;
      const connecterRequest:ConnecterRequest = { email:"hamza@gmail.com", password: password}
      this.authService.connecter(connecterRequest).subscribe({
        next: () => {
          this.utilisateurDeconnecter = this.authService.getCurrentUser();
          this.router.navigate([ROUTE_MAIN]); // Redirigez après une connexion réussie
        },
        error: () => {
          this.errorMessage = 'Mot de passe incorrect.'; // Affichez un message d'erreur
        }
      });
    }
  }

  deconnexionClicked(): void {
    const storedUser = localStorage.getItem(CURRENT_USER);
    if (storedUser) {
      this.currentUserSubject.next(JSON.parse(storedUser)); // Récupérer l'utilisateur depuis LocalStorage
    }

    this.authService.deconnexionProcess();
  }

}
