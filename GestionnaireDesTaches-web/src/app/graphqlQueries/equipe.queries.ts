import {gql} from '@apollo/client';

const Query_Toutes_Equipes = gql`
  query GetToutesLesEquipes {
    Equipes {
      id
      nom
      idChefEquipe
      chefEquipe {
        id
        profilePicture
        nom
      }
      projetsEquipe {
        id
        nom
      }
      mesMembers {
        id
        profilePicture
      }
    }
  }
`;

export { Query_Toutes_Equipes };
