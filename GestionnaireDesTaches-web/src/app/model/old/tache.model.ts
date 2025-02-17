import {HistoriqueStatut} from './HistoriqueStatut.model';
import {Utilisateur} from './utilisateur.model';
import {Projet} from './projet.model';

export interface Tache {
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
  historiqueStatut: HistoriqueStatut | null
  projetDeTache: Projet | null
  assigneurDeTache: Utilisateur | null
}
