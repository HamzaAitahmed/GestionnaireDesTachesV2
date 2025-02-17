import {MesMember} from './childModels/MesMember.model';
import {Projet} from './projet.model';
import {Utilisateur} from './utilisateur.model';

export interface Equipe {
  id: number
  nom: string
  dateDeCreation: string
  idChefEquipe: number
  mesMembers: MesMember[] | null
  chefEquipe: Utilisateur | null
  projetsEquipe: Projet[] | null
}
