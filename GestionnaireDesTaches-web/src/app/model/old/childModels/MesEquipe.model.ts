import {MesMember} from './MesMember.model';

export interface MesEquipe {
  id: number
  nom: string
  dateDeCreation: string
  idChefEquipe: number
  mesMembers: MesMember[] | null
}
