import {Component, inject} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AuthentificationService} from '../../services/authentification.service';

function passwordMatchValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const password = control.get('password')?.value;
    const confirmerPassword = control.get('confirmerPassword')?.value;

    // Si les mots de passe ne correspondent pas, retournez une erreur
    if (password !== confirmerPassword) {
      return { passwordMismatch: true };
    }
    return null; // Les mots de passe correspondent
  };
}

@Component({
  selector: 'app-inscription',
  standalone: false,

  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css'
})
export class InscriptionComponent {
  registerForm: FormGroup;
  message: string = ''; // Message à afficher à l'utilisateur
  isSuccess: boolean = false; // Indique si l'inscription a réussi

  constructor(private http: HttpClient, private auth: AuthentificationService, private router: Router, private fb: FormBuilder) {
    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmerPassword: ['', Validators.required]
    }, { validators: passwordMatchValidator() });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      const {username, email, password, confirmerPassword} = this.registerForm.value;
      this.auth.inscription(username, email, password, confirmerPassword).subscribe({
        next: (response: any) => {
          if (response.status === 'success') {
            this.isSuccess = true;
            this.message = response.message; // Affichez le message de succès
            this.router.navigate(['/connecter']); // Redirigez vers la page de connexion
          } else {
            this.isSuccess = false;
            this.message = response.message; // Affichez le message d'erreur
          }
        },
        error: (error) => {
          if (error.status === 400) {
            console.error('Validation error', error.error);
            this.isSuccess = false;
            this.message = 'Une erreur est survenue lors de l\'inscription.'; // Message d'erreur générique
          } else {
              this.isSuccess = false;
              this.message = 'Une erreur est survenue lors de l\'inscription.'; // Message d'erreur générique
              console.error('Erreur lors de l\'inscription', error);
            }
          }
      });
    }else {
      this.message = 'Veuillez corriger les erreurs dans le formulaire.'; // Message si le formulaire est invalide
    }
  }
}
