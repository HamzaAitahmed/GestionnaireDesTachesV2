import {CompetenceRequise} from './CompetenceRequise.model';

export interface ListMesCompetencesRequise {
  id: number
  idProjet: number
  competenceRequise: CompetenceRequise[]
}
