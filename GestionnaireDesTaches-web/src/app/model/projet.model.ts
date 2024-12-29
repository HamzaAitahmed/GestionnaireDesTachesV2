import {ListMesCompetencesRequise} from './ListMesCompetencesRequise.model';
import {TachesDeProjet} from './childModels/TachesDeProjet.model';

export interface Projet {
  id: number
  nom: string
  budget: number
  client: string
  description: string
  statut: string
  dateDeCreation: string
  dateDebut: string
  dateFin: string
  idChefProjet: number
  idEquipeDeProjet: number
  idListCompetencesRequise: number
  listMesCompetencesRequise: ListMesCompetencesRequise
  tachesDeProjet: TachesDeProjet[]
}
