import {Component} from '@angular/core';
import {AuthentificationService} from '../../services/authentification.service';

@Component({
  selector: 'app-navbar',
  standalone: false,

  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent{
  errorMessage: string = '';

  constructor(public authService: AuthentificationService) {}

  onLogout(): void {
    this.authService.logout();
  }

}
