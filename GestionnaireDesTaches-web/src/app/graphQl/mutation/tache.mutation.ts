import {gql} from '@apollo/client';

export const AjouterTache = gql`

  mutation AjouterTache($tacheObjet: TacheRequest = {}) {
    AjouterTache(tacheObjet: $tacheObjet) {
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

export const ModifierTache = gql`

  mutation ModifierTache($id: Int, $tacheObjet: TacheRequest = {}) {
    ModifierTache(tacheId: $id, tacheObjet: $tacheObjet) {
      assigneurDeTacheId
      dateDeCreation
      dateFin
      dateDebut
      description
      id
      nom
      projetDeTacheId
    }
  }
`;

export const supprimerTache = gql`

  mutation supprimerTache($id: Int) {
    supprimerTache(tacheId: $id)
  }
`;
