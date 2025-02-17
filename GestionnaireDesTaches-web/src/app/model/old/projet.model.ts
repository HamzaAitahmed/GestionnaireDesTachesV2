import {ListMesCompetencesRequise} from './ListMesCompetencesRequise.model';
import {TachesDeProjet} from './childModels/TachesDeProjet.model';
import {Equipe} from './equipe.model';
import {Utilisateur} from './utilisateur.model';

export interface Projet {
  id: number;
  nom: string;
  budget: number;
  client: string;
  description: string;
  statut: string;
  dateDeCreation: string;
  dateDebut: string;
  dateFin: string;
  idChefProjet: number;
  idEquipeDeProjet: number;
  idListCompetencesRequise: number;
  listMesCompetencesRequise: ListMesCompetencesRequise | null;
  tachesDeProjet: TachesDeProjet[] | null;
  chefProjet: Utilisateur | null;
  equipeDeProjet: Equipe | null;

  // constructor()
  // {
  //   this.id = 0;
  //   this.nom = '';
  //   this.budget = 0;
  //   this.client = '';
  //   this.description = '';
  //   this.statut = '';
  //   this.dateDeCreation = '';
  //   this.dateDebut = '';
  //   this.dateFin = '';
  //   this.idChefProjet = 0;
  //   this.idEquipeDeProjet = 0;
  //   this.idListCompetencesRequise = 0;
  //   this.listMesCompetencesRequise = null;
  //   this.tachesDeProjet = null;
  //   this.chefProjet = null; // Initialisation avec un objet Utilisateur vide
  //   this.equipeDeProjet = null;
  // }

}


