import { Injectable } from '@angular/core';
import {UtilisateurResponse} from '../../model/responses/utilisateur-response.model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  private utilisateur: UtilisateurResponse | null = null;

  constructor() {
    // Initialisation de l'utilisateur avec des données fictives
    this.utilisateur = {
      id: 1,

      email: 'john.doe@example.com',

      salaire: 50000,

      nom: 'Doe',
      prenom: 'John',
      username: 'karim',
      gender: 'Male',

      dateOfBirth: '1990-05-15',
      dateInscription: '2021-01-01',
      anneeExperience: 5,

      profilePicture: 'assets/images/user/user-2.jpg',

      mesProjetsIds: null,
      mesTachesIds: null,
      mesEquipesIds: null,
      membreDansLEquipeIds: null,
    };
  }

  getUtilisateur(): UtilisateurResponse {
    return <UtilisateurResponse>this.utilisateur;
  }

  setUtilisateur(utilisateur: UtilisateurResponse): void {
    this.utilisateur = utilisateur;
  }

  clearUtilisateur(): void {
    this.utilisateur = null;
  }
}
