import {gql} from '@apollo/client';

const Query_Projets = gql`
  query GetProjetsById($id: Int!, $search: String!){
    searchProjets(id: $id, search: $search) {
      id
      nom
      idChefProjet
      description
      statut
      chefProjet {
        id
        profilePicture
      }
      equipeDeProjet {
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
  }
`;

export { Query_Projets };
