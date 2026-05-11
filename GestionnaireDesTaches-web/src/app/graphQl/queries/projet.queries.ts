import {gql} from '@apollo/client';

export const ToutesLesProjets = gql`
  query ToutesLesProjets {
    Projets {
      id
      nom
      description
      budget
      client
      dateDeCreation
      dateDebut
      dateFin
      description
      chefProjetId
      equipeDuProjetId
      lesTachesDeProjetIds
    }
  }
`;

export const ChercherProjet = gql`
  query ChercherProjet($id: Int!, $search: String!){
    ProjetsSearch(chefProjetId: $id, search: $search) {
      id
      nom
      description
      budget
      client
      dateDeCreation
      dateDebut
      dateFin
      description
      chefProjetId
      equipeDuProjetId
      lesTachesDeProjetIds
    }
  }
`;

export const ProjetByChefProjetId = gql`
  query ProjetByChefProjetId($id: Int!){
    ProjetByChefProjetId(chefProjetId: $id) {
      id
      nom
      description
      budget
      client
      dateDeCreation
      dateDebut
      dateFin
      description
      chefProjetId
      equipeDuProjetId
      lesTachesDeProjetIds
    }
  }
`;

export const ProjetByEquipeDuProjetId = gql`
  query ProjetByEquipeDuProjetId($id: Int!){
    ProjetByEquipeDuProjetId(equipeDuProjetId: $id) {
      id
      nom
      description
      budget
      client
      dateDeCreation
      dateDebut
      dateFin
      description
      chefProjetId
      equipeDuProjetId
      lesTachesDeProjetIds
    }
  }
`;

export const ProjetByTacheId = gql`
  query ProjetByTacheId($id: Int!){
    ProjetByTacheId(tacheId: $id) {
      id
      nom
      description
      budget
      client
      dateDeCreation
      dateDebut
      dateFin
      description
      chefProjetId
      equipeDuProjetId
      lesTachesDeProjetIds
    }
  }
`;

export const ProjetById = gql`
  query ProjetById($id: Int!){
    ProjetById(projetId: $id) {
      id
      nom
      description
      budget
      client
      dateDeCreation
      dateDebut
      dateFin
      description
      chefProjetId
      equipeDuProjetId
      lesTachesDeProjetIds
    }
  }
`;
