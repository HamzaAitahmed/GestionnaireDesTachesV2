import {Competence} from './Competence.model';

export interface CompetenceRequise {
  id: number
  nom: string
  niveau: string
  idListCompetencesRequise: number
  competence: Competence
}
