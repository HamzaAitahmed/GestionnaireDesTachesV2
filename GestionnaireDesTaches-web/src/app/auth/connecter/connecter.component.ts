import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthentificationService} from '../../services/authentification.service';
import {ROUTE_MAIN} from '../../constants/global.constants';

@Component({
  selector: 'app-connecter',
  standalone: false,
  templateUrl: './connecter.component.html',
  styleUrl: './connecter.component.css'
})
export class ConnecterComponent {
  loginForm: FormGroup;
  errorMessage:string = '';

  constructor(private auth: AuthentificationService,private router: Router, private fb: FormBuilder)
  {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      let connectedRequest = this.loginForm.value;
      this.auth.connecter(connectedRequest).subscribe({
        next: () => {
          this.router.navigate([ROUTE_MAIN]); // Redirigez après une connexion réussie
        },
        error: () => {
          this.errorMessage = 'Email ou mot de passe incorrect.'; // Affichez un message d'erreur
        }
      });
    }
  }

}
