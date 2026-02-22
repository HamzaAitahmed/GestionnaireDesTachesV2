import {gql} from '@apollo/client';

const Query_Projets = gql`

  query GetToutesLesProjets {
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

  query ChercherProjet($id: Int!, $search: String!){
    ProjetsSearch(id: $id, search: $search) {
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

export { Query_Projets };
