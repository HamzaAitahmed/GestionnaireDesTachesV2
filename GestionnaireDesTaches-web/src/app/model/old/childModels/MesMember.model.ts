import {ListCompetencesUtilisateur} from '../ListCompetencesUtilisateur.model';

export interface MesMember {
  id: number
  email: string
  salaire: number
  nom: string
  prenom: string
  username: string
  gender: string
  dateOfBirth: string
  dateInscription: string
  anneeExpeience: number
  role: string
  profilePicture: string
  idListMesCompetences: number
  listMesCompetences: ListCompetencesUtilisateur | null
}
