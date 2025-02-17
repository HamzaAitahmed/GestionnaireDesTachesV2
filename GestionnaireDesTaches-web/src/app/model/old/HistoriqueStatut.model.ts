import {StatutAvecDate} from './statutAvecDate.model';

export interface HistoriqueStatut {
  id: number
  idTache: number
  historique: StatutAvecDate[] | null
}
