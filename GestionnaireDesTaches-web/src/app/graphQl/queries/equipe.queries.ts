import {gql} from '@apollo/client';

const Query_Toutes_Equipes = gql`

  query GetToutesLesEquipes {
    Equipes {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }

  query EquipeByChefEquipeId($id: Int!){
    EquipeByChefEquipeId(chefEquipeId: $id) {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }

  query EquipeByMemberEquipeId($id: Int!){
    EquipeByMemberEquipeId(memberEquipeId: $id) {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }

  query EquipeByProjetEquipeId($id: Int!){
    EquipeByProjetEquipeId(projetId: $id) {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }

  query EquipeById($id: Int!){
    EquipeById(equipeId: $id) {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }

`;

export { Query_Toutes_Equipes };
