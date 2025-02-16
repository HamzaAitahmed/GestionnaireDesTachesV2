import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AuthentificationService} from '../../services/authentification.service';

@Component({
  selector: 'app-connecter',
  standalone: false,
  templateUrl: './connecter.component.html',
  styleUrl: './connecter.component.css'
})
export class ConnecterComponent {
  loginForm: FormGroup;
  errorMessage:string = '';

  constructor(private http: HttpClient,private auth: AuthentificationService,private router: Router, private fb: FormBuilder)
  {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      this.auth.login(email, password).subscribe({
        next: (user) => {
          const currentUser = this.auth.getCurrentUser();
          console.log('Login successful', currentUser);
          this.router.navigate(['main']); // Redirigez après une connexion réussie
        },
        error: (error) => {
          console.error('Login failed', error);
          this.errorMessage = 'Email ou mot de passe incorrect.'; // Affichez un message d'erreur
        }
      });
    }
  }

}
