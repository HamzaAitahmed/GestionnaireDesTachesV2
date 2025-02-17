import { Injectable } from '@angular/core';
import {Utilisateur} from '../model/utilisateur.model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  private utilisateur: Utilisateur | null = null;

  constructor() {
    // Initialisation de l'utilisateur avec des données fictives
    this.utilisateur = {
      id: 1,
      email: 'john.doe@example.com',
      salaire: 50000,
      nom: 'Doe',
      prenom: 'John',
      username: 'karim',
      password: '123',
      gender: 'Male',
      dateOfBirth: '1990-05-15',
      dateInscription: '2021-01-01',
      anneeExpeience: 5,
      role: 'Admin',
      profilePicture: 'assets/images/user/user-2.jpg',
      idListMesCompetences: 1,
      listMesCompetences: null,
      mesEquipes: null,
    };
  }

  getUtilisateur(): Utilisateur {
    return <Utilisateur>this.utilisateur;
  }

  setUtilisateur(utilisateur: Utilisateur): void {
    this.utilisateur = utilisateur;
  }

  clearUtilisateur(): void {
    this.utilisateur = null;
  }
}
