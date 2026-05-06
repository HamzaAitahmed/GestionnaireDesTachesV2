import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthentificationService} from '../../services/authentification/authentification.service';
import {ConnecterRequest} from '../../model/requests/connecter-request.model';
import {ROUTE_MAIN} from '../../constants/global.constants';

@Component({
  selector: 'app-deconnecter',
  standalone: false,
  templateUrl: './deconnecter.component.html',
  styleUrl: './deconnecter.component.css'
})
export class DeconnecterComponent implements OnInit{
  logoutForm: FormGroup;
  user: { username: string, email: string, profilePicture: string } = { username: '', email: '', profilePicture: '' }; // Informations de l'utilisateur
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
      const connecterRequest:ConnecterRequest = { email:this.user.email, password: password}
      this.authService.connecter(connecterRequest).subscribe({
        next: () => {
          this.router.navigate([ROUTE_MAIN]); // Redirigez après une connexion réussie
        },
        error: () => {
          this.errorMessage = 'Mot de passe incorrect.'; // Affichez un message d'erreur
        }
      });
    }
  }

  deconnexionClicked(): void {
    const u = this.authService.getCurrentUser();
    this.user = {
      username: u?.username || '',
      email: u?.email || '',
      profilePicture: u?.profilePicture || ''
    };
    this.authService.deconnexionProcess();
  }
}
