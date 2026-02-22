import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {AuthentificationService} from '../../../services/authentification.service';
import {ProjetService} from '../../../services/projet.service';
import {ProjetResponse} from '../../../model/responses/projet-response.model';
import {Router} from '@angular/router';
import {AjouterProjetComponent} from '../ajouter-projet/ajouter-projet.component';
import {ModifierProjetComponent} from '../modifier-projet/modifier-projet.component';
import {EquipeResponse} from '../../../model/responses/equipe-response.model';
import {EquipeService} from '../../../services/equipe.service';
import {ObservableQuery} from '@apollo/client';
import Result = ObservableQuery.Result;

@Component({
  selector: 'app-list-des-projets',
  standalone: false,
  templateUrl: './list-des-projets.component.html',
  styleUrl: './list-des-projets.component.css'
})

export class ListDesProjetsComponent implements OnInit {
  projets: ProjetResponse[] = []; // Liste des projets
  currentUser:any = null;
  constructor(private dialog: MatDialog,private projetService: ProjetService,private equipeService: EquipeService, private authService: AuthentificationService, private router :Router) {}
  listDesEquipes: EquipeResponse[] = [];
  // listDesEquipes: Equipe[] = [
  //   {
  //     id: 1,
  //     nom: 'Équipe Alpha',
  //     dateDeCreation: '2023-01-01',
  //     idChefEquipe: 101,
  //     mesMembers: null,
  //     chefEquipe:null,
  //     projetsEquipe: null,
  //   },
  //   {
  //     id: 2,
  //     nom: 'Équipe Beta',
  //     dateDeCreation: '2023-02-01',
  //     idChefEquipe: 102,
  //     mesMembers: null,
  //     chefEquipe:null,
  //     projetsEquipe: null,
  //   },
  //   {
  //     id: 3,
  //     nom: 'Équipe Gamma',
  //     dateDeCreation: '2023-03-01',
  //     idChefEquipe: 103,
  //     mesMembers: null,
  //     chefEquipe:null,
  //     projetsEquipe: null,
  //   }
  // ];

  @Input() search: string = 'Toutes_Les_Projets'; // Recevoir search depuis le parent

  ngOnInit(): void {
    // this.loadProjets();
    // this.loadProjetsGraphQl();
  }

  mopdifierSearch(newSearch: string): void {
    this.search = newSearch; // Mettre à jour la valeur de search
    // this.loadProjetsGraphQl(); // Recharger les projets
  }

  loadEquipesGraphQl(): Promise<void> {
    return new Promise((resolve, reject) => {
      this.equipeService.GetToutesLesEquipes().subscribe({
        next: (result) => {
          this.listDesEquipes = result ?? [];
          resolve(); // Résoudre la promesse quand les données sont chargées
        },
        error: (err) => {
          console.error('Erreur lors du chargement des projets :', err);
          reject(err); // Rejeter en cas d'erreur
        },
      });
    });
  }

  // loadProjetsGraphQl(): void {
  //   this.currentUser = this.authService.getCurrentUser();
  //   if (this.currentUser && this.currentUser.id) {
  //     this.projetService.getProjetsByUserGql(this.currentUser.id, this.search).valueChanges.subscribe({
  //       next: (result) => {
  //         this.projets = result.data.searchProjets;
  //       },
  //       error: (err) => {
  //         console.error('Erreur lors du chargement des projets :', err);
  //       },
  //     });
  //   }
  // }

  gotoTache(projet:ProjetResponse)
  {
    this.router.navigateByUrl("/Tache/"+projet.id)
  }

  async ajouterProjet() {
    try {
      await this.loadEquipesGraphQl();
      const dialogRef = this.dialog.open(AjouterProjetComponent, {
        width: '500px', // Largeur du modal
        disableClose: true, // Empêche la fermeture en cliquant à l'extérieur
        data: {equipes: this.listDesEquipes, currentUser: this.currentUser }, // Pass Les Equipes au modal
      });

      // Fermer le modal et recharger les projets après soumission
      dialogRef.afterClosed().subscribe(result => {
        // Ajouter ici une méthode pour rafraîchir la liste des projets si nécessaire
      });
  }catch (err) {
      console.error('Erreur lors du chargement des équipes :', err);
      // Afficher un message d'erreur à l'utilisateur
      // this.snackBar.open('Erreur lors du chargement des équipes', 'Fermer', { duration: 3000, });
    }
  }

  async modifierProjet(p: ProjetResponse) {
    try {
      await this.loadEquipesGraphQl();
      const dialogRef = this.dialog.open(ModifierProjetComponent, {
        width: '500px', // Largeur du modal
        disableClose: true, // Empêche la fermeture en cliquant à l'extérieur
        data: { projet: p, equipes: this.listDesEquipes }, // Pass the Projet object to the modal
      });

      // Fermer le modal et recharger les projets après soumission
      dialogRef.afterClosed().subscribe(result => {
        // Ajouter ici une méthode pour rafraîchir la liste des projets si nécessaire
      });
    }catch (err) {
      console.error('Erreur lors du chargement des équipes :', err);
      // Afficher un message d'erreur à l'utilisateur
      // this.snackBar.open('Erreur lors du chargement des équipes', 'Fermer', { duration: 3000, });
    }
  }

  supprimerProjet(projet: ProjetResponse) {

  }
}
