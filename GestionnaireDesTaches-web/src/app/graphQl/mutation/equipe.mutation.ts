import {gql} from '@apollo/client';

export const AjouterEquipe = gql`

  mutation AjouterEquipe($equipeObjet: EquipeRequest = {}) {
    AjouterEquipe(equipeObjet: $equipeObjet) {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }
`;

export const ModifierEquipe = gql`

  mutation ModifierEquipe($id: Int, $equipeObjet: EquipeRequest = {}) {
    ModifierEquipe(id: $id, equipeObjet: $equipeObjet) {
      id
      nom
      dateDeCreation
      chefEquipeId
      lesMembresDEquipeIds
      lesProjetsDEquipeIds
    }
  }
`;

export const supprimerEquipe = gql`

  mutation supprimerEquipe($id: Int) {
    supprimerEquipe(id: $id)
  }
`;
