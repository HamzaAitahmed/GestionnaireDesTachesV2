import {Component, Input, OnInit} from '@angular/core';
import {ProjetResponse} from '../../model/responses/projet-response.model';
import {MatDialog} from '@angular/material/dialog';
import {ProjetService} from '../../services/business/projet.service';
import {EquipeService} from '../../services/business/equipe.service';
import {AuthentificationService} from '../../services/authentification/authentification.service';
import {Router} from '@angular/router';
import {EquipeResponse} from '../../model/responses/equipe-response.model';

@Component({
  selector: 'app-projet',
  standalone: false,

  templateUrl: './projet.component.html',
  styleUrl: './projet.component.css'
})
export class ProjetComponent implements OnInit{

  projets: ProjetResponse[] = []; // Liste des projets
  currentUser:any = null;
  constructor(private dialog: MatDialog,private projetService: ProjetService,private equipeService: EquipeService, private authService: AuthentificationService, private router :Router) {}
  listDesEquipes: EquipeResponse[] = [];

  @Input() search: string = 'Toutes_Les_Projets'; // Recevoir search depuis le parent

  ngOnInit(): void {
    this.loadAllProjets();
    // this.loadProjetsGraphQl();

  }

  mopdifierSearch(newSearch: string): void {
    this.search = newSearch; // Mettre à jour la valeur de search
    this.loadProjetsGraphQl(); // Recharger les projets
  }

  loadProjetsGraphQl(): void {
    this.currentUser = this.authService.getCurrentUser();
    if (this.currentUser && this.currentUser.id) {
      this.projetService
        .getProjetsByUserGql(this.currentUser.id, this.search)
        .subscribe({
        next: (projets) => {
          this.projets = projets;
        },
        error: (err) => {
          console.error('Erreur lors du chargement des projets :', err);
        },
      });
    }
  }

  loadAllProjets(): void {
    this.currentUser = this.authService.getCurrentUser();
    if (this.currentUser && this.currentUser.id) {
      this.projetService
        .getAllProjects()
        .subscribe({
          next: (projets) => {
            this.projets = projets;
          },
          error: (err) => {
            console.error('Erreur lors du chargement des projets :', err);
          },
        });
    }
  }
}
