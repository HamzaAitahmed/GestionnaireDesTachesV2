import {TacheResponse} from '../model/responses/tache-response.model';
import {TacheGqlModel} from '../model/graphQl/tache-gql-model';

export function toTache(model: TacheGqlModel): TacheResponse {
  return {
    id: model.id ?? 0,
    nom: model.nom ?? '',
    description: model.description ?? '',
    statut: model.statut ?? false,

    dateDeCreation: model.dateDeCreation ?? '',
    dateDebut: model.dateDebut ?? '',
    dateFin: model.dateFin ?? '',

    projetDeTacheId: model.projetDeTacheId ?? null,
    assigneurDeTacheId: model.assigneurDeTacheId ?? null,
  };
}
