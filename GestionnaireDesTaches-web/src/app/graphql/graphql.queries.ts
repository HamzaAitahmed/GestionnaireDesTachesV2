import {gql} from '@apollo/client';

const Query_Equipes = gql`
  query {
    Equipes {
      id
      nom
      dateDeCreation
      idChefEquipe
      mesMembers {
        nom
        prenom
        email
        username
        idListMesCompetences
      }
    }
  }
`;

export { Query_Equipes };
