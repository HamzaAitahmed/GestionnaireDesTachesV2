interface Projet {
  id: number;
  nom: string;
  budget: number;
  client: string;
  description:string;
  statut:string;
  dateDeCreation:Date;
  dateDebut:Date;
  dateFin:Date;
  idChefProjet: number;
  idEquipeDeProjet: number;
}
