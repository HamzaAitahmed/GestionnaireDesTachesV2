import {CompetenceUtilisateur} from './CompetenceUtilisateur.model';

export interface ListCompetencesUtilisateur {
  id: number
  idUtilisateur: number
  competenceUtilisateur: CompetenceUtilisateur[] | null
}
