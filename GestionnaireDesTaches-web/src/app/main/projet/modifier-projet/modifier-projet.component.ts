import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ProjetResponse} from '../../../model/responses/projet-response.model';
import {EquipeResponse} from '../../../model/responses/equipe-response.model';

@Component({
  selector: 'app-modifier-projet',
  standalone: false,

  templateUrl: './modifier-projet.component.html',
  styleUrl: './modifier-projet.component.css'
})
export class ModifierProjetComponent implements OnInit {
  projetSelectionner: ProjetResponse;
  listDesEquipes: EquipeResponse[] = [];

  constructor(
    public dialogRef: MatDialogRef<ModifierProjetComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { projet: ProjetResponse, equipes: EquipeResponse[] }
  ) {
    this.projetSelectionner = data.projet; // Access the passed projet object
    this.listDesEquipes = data.equipes; // Access the passed list of teams
  }

  ngOnInit(): void {
    // Additional initialization logic if needed
  }

  onSubmit(): void {
    // Handle form submission
    this.dialogRef.close(this.projetSelectionner); // Pass the updated projet back to the parent
  }

  onCancel(): void {
    this.dialogRef.close(false); // Close the modal without saving
  }
}
