import {gql} from '@apollo/client';

export const AjouterUtilisateur = gql`

  mutation AjouterUtilisateur($utilisateurObjet: UtilisateurRequest = {}) {
    AjouterUtilisateur(utilisateurObjet: $utilisateurObjet) {
      id
      username
      email
      gender
      nom
      prenom
      salaire
      dateOfBirth
      dateInscription
      anneeExperience
      profilePicture
      membreDansLEquipeIds
      mesEquipesIds
      mesProjetsIds
      mesTachesIds
    }
  }
`;

export const ModifierUtilisateur = gql`

  mutation ModifierUtilisateur($id: Int, $utilisateurObjet: UtilisateurRequest = {}) {
    ModifierUtilisateur(id: $id, utilisateurObjet: $utilisateurObjet) {
      id
      username
      email
      gender
      nom
      prenom
      salaire
      dateOfBirth
      dateInscription
      anneeExperience
      profilePicture
      membreDansLEquipeIds
      mesEquipesIds
      mesProjetsIds
      mesTachesIds
    }
  }
`;

export const supprimerUtilisateur = gql`

  mutation supprimerUtilisateur($id: Int) {
    supprimerUtilisateur(id: $id)
  }
`;
