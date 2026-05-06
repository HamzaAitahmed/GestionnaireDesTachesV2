import {ProjetResponse} from '../model/responses/projet-response.model';
import {ProjetGqlModel} from '../model/graphQl/projet-gql-model';

export function toProjet(model: ProjetGqlModel): ProjetResponse {
  return {
    id: model.id ?? 0,
    nom: model.nom ?? '',
    budget: model.budget ?? 0,
    client: model.client ?? '',
    description: model.description ?? '',

    dateDeCreation: model.dateDeCreation ?? '',
    dateDebut: model.dateDebut ?? '',
    dateFin: model.dateFin ?? '',

    chefProjetId: model.chefProjetId ?? null,
    equipeDuProjetId: model.equipeDuProjetId ?? null,
    lesTachesDeProjetIds: model.lesTachesDeProjetIds ?? [],
  };
}
