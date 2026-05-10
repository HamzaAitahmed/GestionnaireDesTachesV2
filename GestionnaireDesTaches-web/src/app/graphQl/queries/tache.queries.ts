import {gql} from '@apollo/client';

export const ToutesLesTaches = gql`

  query ToutesLesTaches {
    Taches {
      assigneurDeTacheId
      dateDeCreation
      dateDebut
      dateFin
      description
      id
      nom
      projetDeTacheId
    }
  }
`;

export const TachesByProjetId = gql`

  query TachesByProjetId($id: Int!){
    TachesByProjetId(projetId: $id) {
      assigneurDeTacheId
      dateDeCreation
      dateDebut
      dateFin
      description
      id
      nom
      projetDeTacheId
    }
  }
`;

export const TachesByUtilisateurId = gql`

  query TachesByUtilisateurId($id: Int!){
    TachesByUtilisateurId(utilisateurId: $id) {
      assigneurDeTacheId
      dateDeCreation
      dateDebut
      dateFin
      description
      id
      nom
      projetDeTacheId
    }
  }
`;

export const TacheById = gql`

  query TacheById($id: Int!){
    TacheById(tacheId: $id) {
      assigneurDeTacheId
      dateDeCreation
      dateDebut
      dateFin
      description
      id
      nom
      projetDeTacheId
    }
  }
`;
