import {ListCompetencesUtilisateur} from './ListCompetencesUtilisateur.model';
import {MesEquipe} from './childModels/MesEquipe.model';

export interface Utilisateur {
  id: number
  email: string
  salaire: number
  nom: string
  prenom: string
  username: string
  password: string
  gender: string
  dateOfBirth: string
  dateInscription: string
  anneeExpeience: number
  role: string
  profilePicture: any
  idListMesCompetences: number
  listMesCompetences: ListCompetencesUtilisateur
  mesEquipes: MesEquipe[]
}
