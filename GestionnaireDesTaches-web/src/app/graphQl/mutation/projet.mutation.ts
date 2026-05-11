import {gql} from '@apollo/client';

export const AjouterProjet = gql`

  mutation AjouterProjet($projetObjet: ProjetRequest = {}) {
    AjouterProjet(projetObjet: $projetObjet) {
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

export const ModifierProjet = gql`

  mutation ModifierProjet($id: Int, $projetObjet: ProjetRequest = {}) {
    ModifierProjet(projetId: $id, projetObjet: $projetObjet) {
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

export const supprimerProjet = gql`

  mutation supprimerProjet($id: Int) {
    supprimerProjet(projetId: $id)
  }
`;
