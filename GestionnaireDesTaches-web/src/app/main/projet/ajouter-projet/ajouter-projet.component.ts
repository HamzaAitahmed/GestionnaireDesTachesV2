import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Projet} from '../../../model/projet.model';
import {Equipe} from '../../../model/equipe.model';
import {ProjetService} from '../../../services/projet.service';

@Component({
  selector: 'app-ajouter-projet',
  standalone: false,

  templateUrl: './ajouter-projet.component.html',
  styleUrl: './ajouter-projet.component.css'
})

export class AjouterProjetComponent {
  currentUser:any;
  projetAjouter : Projet = {
    id:0,
    nom:'',
    budget:0,
    client:'',
    description:'',
    statut:'',
    dateDeCreation:'',
    dateDebut:'',
    dateFin:'',
    idChefProjet:0,
    idEquipeDeProjet:0,
    idListCompetencesRequise:0,
    listMesCompetencesRequise:null,
    tachesDeProjet:null,
    chefProjet:null, // Initialisation avec un objet Utilisateur vide
    equipeDeProjet:null,
  };

  listDesEquipes: Equipe[] = [];

  constructor(
    private projetService: ProjetService,
    public dialogRef: MatDialogRef<AjouterProjetComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { equipes: Equipe[], currentUser: any }
  ) {
    this.currentUser = data.currentUser
    this.projetAjouter.idChefProjet=this.currentUser.id
    this.projetAjouter.chefProjet=this.currentUser
    this.listDesEquipes = data.equipes; // Access the passed list of teams
  }

  ferme(): void {
    this.dialogRef.close();
  }

  saveProject(projetAjouter: Projet): void {
    console.log("projetAjouter : ")
    console.log(projetAjouter)
    this.projetService.ajouterProjet(projetAjouter).subscribe({
      next: (response) => {
        console.log('Projet ajouté', response);
        this.dialogRef.close('Projet ajouté');
      },
      error: (err) => {
        console.error('Erreur lors de l\'enregistrement du projet', err);
      }
    });
  }
}
