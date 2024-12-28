interface Tache {
  id: number;
  nom: string;
  statutTache: string;
  priorite: string;
  description: string;
  dateDeCreation:Date;
  dateDebut:Date;
  dateFin:Date;
  idAssigneurDeTache: number;
  idProjetDeTache: number;
  idHistoriqueStatut: number;
}
