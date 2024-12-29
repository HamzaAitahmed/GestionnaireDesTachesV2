import {Competence} from './Competence.model';

export interface CompetenceUtilisateur {
  id: number
  nom: string
  niveau: string
  idListDesCompetences: number
  competence: Competence
}
