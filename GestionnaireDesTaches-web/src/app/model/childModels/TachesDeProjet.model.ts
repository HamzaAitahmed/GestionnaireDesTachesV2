import {HistoriqueStatut} from '../HistoriqueStatut.model';

export interface TachesDeProjet {
  id: number
  nom: string
  statutTache: string
  priorite: string
  dateDeCreation: string
  dateDebut: string
  dateFin: string
  description: string
  idAssigneurDeTache: number
  idProjetDeTache: number
  idHistoriqueStatut: number
  historiqueStatut: HistoriqueStatut
}
