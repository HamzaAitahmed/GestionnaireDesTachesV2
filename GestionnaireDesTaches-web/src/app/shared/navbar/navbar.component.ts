import {Component, OnInit} from '@angular/core';
import {AuthentificationService} from '../../services/authentification/authentification.service';
import {UtilisateurResponse} from '../../model/responses/utilisateur-response.model';

@Component({
  selector: 'app-navbar',
  standalone: false,

  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit{
  errorMessage: string = '';
  user: UtilisateurResponse | null = null;

  constructor(public authService: AuthentificationService) {}

  onLogout(): void {
    this.authService.deconnexionProcess();
  }


  ngOnInit() {
    this.authService.currentUser$.subscribe(u => this.user = u);
  }

}
