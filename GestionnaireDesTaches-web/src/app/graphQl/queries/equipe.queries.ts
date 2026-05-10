import {gql} from '@apollo/client';

export const ToutesLesEquipes = gql`

  query ToutesLesEquipes {
    Equipes {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }
`;

export const EquipeByChefEquipeId = gql`

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
`;

export const EquipeByMemberEquipeId = gql`

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
`;

export const EquipeByProjetEquipeId = gql`

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
`;

export const EquipeById = gql`

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
