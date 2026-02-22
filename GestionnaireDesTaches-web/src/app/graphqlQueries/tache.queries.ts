import {gql} from '@apollo/client';

const Query_Tache = gql`

  query GetToutesLesTaches {
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

export { Query_Tache };
