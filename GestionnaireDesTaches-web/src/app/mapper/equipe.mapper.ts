import {EquipeResponse} from '../model/responses/equipe-response.model';
import {EquipeGqlModel} from '../model/graphQl/equipe-gql-model';

export function toEquipe(model: EquipeGqlModel): EquipeResponse {
  return {
    id: model.id ?? 0,
    nom: model.nom ?? '',

    dateDeCreation: model.dateDeCreation ?? '',

    chefEquipeId: model.chefEquipeId ?? null,
    lesProjetsDEquipeIds: model.lesProjetsDEquipeIds ?? null,
    lesMembresDEquipeIds: model.lesMembresDEquipeIds ?? null,
  };
}
