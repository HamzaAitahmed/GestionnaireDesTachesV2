import {gql} from '@apollo/client';

export const ToutesLesUtilisateurs = gql`

  query ToutesLesUtilisateurs {
    Utilisateurs {
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

export const UtilisateurById = gql`

  query UtilisateurById($id: Int!){
    UtilisateurById(utilisateurId: $id) {
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

export const UtilisateurByEmail = gql`

  query UtilisateurByEmail($email: String!){
    UtilisateurByEmail(email: $email) {
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
