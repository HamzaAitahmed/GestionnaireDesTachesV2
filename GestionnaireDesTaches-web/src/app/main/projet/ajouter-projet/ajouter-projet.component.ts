import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ProjetService} from '../../../services/business/projet.service';
import {ProjetResponse} from '../../../model/responses/projet-response.model';
import {EquipeResponse} from '../../../model/responses/equipe-response.model';

@Component({
  selector: 'app-ajouter-projet',
  standalone: false,

  templateUrl: './ajouter-projet.component.html',
  styleUrl: './ajouter-projet.component.css'
})

export class AjouterProjetComponent {
  currentUser:any;
  projetAjouter : ProjetResponse = {
    id:0,

    nom:'',

    budget:0,
    client:'',
    description:'',

    dateDeCreation:'',
    dateDebut:'',
    dateFin:'',

    chefProjetId:0,
    equipeDuProjetId:0,
    lesTachesDeProjetIds:null,
  };

  listDesEquipes: EquipeResponse[] = [];

  constructor(
    private projetService: ProjetService,
    public dialogRef: MatDialogRef<AjouterProjetComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { equipes: EquipeResponse[], currentUser: any }
  ) {
    this.currentUser = data.currentUser
    this.projetAjouter.chefProjetId=this.currentUser.id
    this.listDesEquipes = data.equipes; // Access the passed list of teams
  }

  ferme(): void {
    this.dialogRef.close();
  }

  saveProject(projetAjouter: ProjetResponse): void {
    this.projetService.ajouterProjet(projetAjouter).subscribe({
      next: (response) => {
        this.dialogRef.close('Projet ajouté');
      },
      error: (err) => {
        console.error('Erreur lors de l\'enregistrement du projet', err);
      }
    });
  }
}
