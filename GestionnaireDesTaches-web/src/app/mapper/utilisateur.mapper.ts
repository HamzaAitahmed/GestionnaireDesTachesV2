import {UtilisateurResponse} from '../model/responses/utilisateur-response.model';
import {UtilisateurGqlModel} from '../model/graphQl/utilisateur-gql-model';

export function toUtilisateur(model: UtilisateurGqlModel): UtilisateurResponse {
  return {
    id: model.id ?? 0,
    email: model.email ?? '',
    salaire: model.salaire ?? 0,
    nom: model.nom ?? '',
    prenom: model.prenom ?? '',
    username: model.username ?? '',
    gender: model.gender ?? '',

    dateOfBirth: model.dateOfBirth ?? '',
    dateInscription: model.dateInscription ?? '',
    anneeExperience: model.anneeExperience ?? 0,

    profilePicture: model.profilePicture ?? '',

    mesProjetsIds: model.mesProjetsIds ?? null,
    mesTachesIds: model.mesTachesIds ?? null,
    mesEquipesIds: model.mesEquipesIds ?? null,
    membreDansLEquipeIds: model.membreDansLEquipeIds ?? null,
  };
}
