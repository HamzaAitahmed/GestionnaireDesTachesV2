import {ListCompetencesUtilisateur} from './ListCompetencesUtilisateur.model';
import {MesEquipe} from './childModels/MesEquipe.model';
import {Projet} from './projet.model';
import {Equipe} from './equipe.model';
import {Tache} from './tache.model';

export interface Utilisateur {
  id: number;
  email: string;
  salaire: number;
  nom: string;
  prenom: string;
  username: string;
  password: string;
  gender: string;
  dateOfBirth: string;
  dateInscription: string;
  anneeExpeience: number;
  role: string;
  profilePicture: any;
  idListMesCompetences: number;
  listMesCompetences: ListCompetencesUtilisateur | null;
  mesEquipes: MesEquipe[] | null;
  membreEquipe: Equipe[] | null;
  mesProjets: Projet[] | null;
  mesTaches: Tache[] | null;
}

