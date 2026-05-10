import { Injectable } from '@angular/core';
import {map, Observable} from 'rxjs';
import {TacheResponse} from '../../model/responses/tache-response.model';
import { TacheById, TachesByProjetId, TachesByUtilisateurId, ToutesLesTaches } from '../../graphQl/queries/tache.queries';
import {Apollo} from 'apollo-angular';
import {toTache} from '../../mapper/tache.mapper';
import {TacheRequest} from '../../model/requests/tache-request.model';
import {AjouterTache, ModifierTache, supprimerTache} from '../../graphQl/mutation/tache.mutation';

@Injectable({
  providedIn: 'root',
})
export class TacheGplService {

  constructor(private apollo: Apollo) {
  }

  getTachesByProjetId(projetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ Taches: TacheResponse[] }>({
        query: TachesByProjetId,
        variables: {projetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.Taches ?? []).map(toTache) )
      );
  }

  getTachesByUtilisateurId(utilisateurId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ Taches: TacheResponse[] }>({
        query: TachesByUtilisateurId,
        variables: {utilisateurId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.Taches ?? []).map(toTache) )
      );
  }

  getTacheById(tacheId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ Tache: TacheResponse }>({
        query: TacheById,
        variables: {tacheId}
      })
      .valueChanges.pipe(
        map(result => result.data?.Tache ? toTache(result.data.Tache) : null )
      );
  }

  getToutesLesTaches(): Observable<any> {
    return this.apollo
      .watchQuery<{ Taches: TacheResponse[] }>({
        query: ToutesLesTaches
      })
      .valueChanges.pipe(
        map(result => (result.data?.Taches ?? []).map(toTache) )
      );
  }

  AjouterTache(tacheRequest: TacheRequest): Observable<any> {
    return this.apollo
      .mutate<{ tacheReponse: TacheResponse }>({
        mutation: AjouterTache,
        variables: tacheRequest
      })
      .pipe(
        map(result => result.data?.tacheReponse ? toTache(result.data.tacheReponse) : null )
      );
  }

  ModifierTache(tacheId: number, tacheRequest: TacheRequest): Observable<any> {
    return this.apollo
      .mutate<{ tacheReponse: TacheResponse }>({
        mutation: ModifierTache,
        variables: {tacheId, tacheRequest}
      })
      .pipe(
        map(result => result.data?.tacheReponse ? toTache(result.data.tacheReponse) : null )
      );
  }

  supprimerTache(tacheId: number): Observable<any> {
    return this.apollo
      .mutate<{ Boolean: boolean }>({
        mutation: supprimerTache,
        variables: {tacheId}
      })
      .pipe(
        map(result => result.data?.Boolean )
      );
  }
}
