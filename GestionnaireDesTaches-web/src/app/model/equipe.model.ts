import {MesMember} from './childModels/MesMember.model';

export interface Equipe {
  id: number
  nom: string
  dateDeCreation: string
  idChefEquipe: number
  mesMembers: MesMember[]
}
