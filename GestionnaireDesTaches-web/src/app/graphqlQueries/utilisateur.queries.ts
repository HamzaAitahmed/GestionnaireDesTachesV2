import {gql} from '@apollo/client';

const Query_Utilisateur = gql`

  query GetToutesLesUtilisateurs {
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

export { Query_Utilisateur };
