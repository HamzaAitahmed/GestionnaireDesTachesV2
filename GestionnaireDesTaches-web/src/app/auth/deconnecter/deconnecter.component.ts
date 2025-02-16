import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthentificationService} from '../../services/authentification.service';

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
    this.onLogout();
  }

  onSubmit() {
    if (this.logoutForm.valid) {
      console.log('Déconnexion en cours...', this.logoutForm.value);
      const { password } = this.logoutForm.value;
      this.authService.login(this.user.email, password).subscribe({
        next: (user) => {
          const currentUser = this.authService.getCurrentUser();
          console.log('Login successful', currentUser);
          this.router.navigate(['main']); // Redirigez après une connexion réussie
        },
        error: (error) => {
          console.error('Login failed', error);
          this.errorMessage = 'Mot de passe incorrect.'; // Affichez un message d'erreur
        }
      });
    }
  }

  onLogout(): void {
    // Récupérez les informations de l'utilisateur connecté
    const currentUser = this.authService.getCurrentUser();
    if (currentUser) {
      this.user = {
        username: currentUser.username,
        email: currentUser.email,
        profilePicture: currentUser.profilePicture,
      };
    }
    this.authService.logout();
    console.log(currentUser)
  }

}
