import { Injectable } from '@angular/core';
import {map, Observable} from 'rxjs';
import {ProjetResponse} from '../../model/responses/projet-response.model';
import {Apollo} from 'apollo-angular';
import {
  ChercherProjet,
  ProjetByChefProjetId, ProjetByEquipeDuProjetId,
  ProjetById,
  ProjetByTacheId,
  ToutesLesProjets
} from '../../graphQl/queries/projet.queries';
import {toProjet} from '../../mapper/projet.mapper';
import {ProjetRequest} from '../../model/requests/projet-request.model';
import {AjouterProjet, ModifierProjet, supprimerProjet} from '../../graphQl/mutation/projet.mutation';

@Injectable({ providedIn: 'root' })
export class ProjetGqlService {

  constructor(private apollo: Apollo) {}

  getToutesLesProjets(): Observable<any> {
    return this.apollo
      .watchQuery<{ projets: ProjetResponse[] }>({
        query: ToutesLesProjets,
      })
      .valueChanges.pipe(
        map(result => (result.data?.projets ?? []).map(toProjet) )
      );
  }

  getChercherProjet(projetId : number, search : string): Observable<any> {
    return this.apollo
      .watchQuery<{ projets: ProjetResponse[] }>({
        query: ChercherProjet,
        variables: {projetId, search}
      })
      .valueChanges.pipe(
        map(result => (result.data?.projets ?? []).map(toProjet) )
      );
  }

  getProjetByChefProjetId(chefProjetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ projets: ProjetResponse[] }>({
        query: ProjetByChefProjetId,
        variables: {chefProjetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.projets ?? []).map(toProjet) )
      );
  }

  getProjetByEquipeDuProjetId(equipeDuProjetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ projets: ProjetResponse[] }>({
        query: ProjetByEquipeDuProjetId,
        variables: {equipeDuProjetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.projets ?? []).map(toProjet) )
      );
  }

  getProjetByTacheId(tacheId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ tache: ProjetResponse }>({
        query: ProjetByTacheId,
        variables: {tacheId}
      })
      .valueChanges.pipe(
        map(result => result.data?.tache ? toProjet(result.data.tache) : null )
      );
  }

  getProjetById(projetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ projet: ProjetResponse }>({
        query: ProjetById,
        variables: {projetId}
      })
      .valueChanges.pipe(
        map(result => result.data?.projet ? toProjet(result.data.projet) : null )
      );
  }

  AjouterProjet(projetRequest: ProjetRequest): Observable<any> {
    return this.apollo
      .mutate<{ projetReponse: ProjetResponse }>({
        mutation: AjouterProjet,
        variables: projetRequest
      })
      .pipe(
        map(result => result.data?.projetReponse ? toProjet(result.data.projetReponse) : null )
      );
  }

  ModifierProjet(projetId: number, projetRequest: ProjetRequest): Observable<any> {
    return this.apollo
      .mutate<{ projetReponse: ProjetResponse }>({
        mutation: ModifierProjet,
        variables: {projetId, projetRequest}
      })
      .pipe(
        map(result => result.data?.projetReponse ? toProjet(result.data.projetReponse) : null )
      );
  }

  supprimerProjet(projetId: number): Observable<any> {
    return this.apollo
      .mutate<{ Boolean: boolean }>({
        mutation: supprimerProjet,
        variables: {projetId}
      })
      .pipe(
        map(result => result.data?.Boolean )
      );
  }

}

