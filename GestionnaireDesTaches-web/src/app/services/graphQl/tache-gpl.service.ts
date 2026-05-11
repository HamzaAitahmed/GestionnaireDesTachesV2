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
      .watchQuery<{ TachesByProjetId: TacheResponse[] }>({
        query: TachesByProjetId,
        variables: { id : projetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.TachesByProjetId ?? []).map(toTache) )
      );
  }

  getTachesByUtilisateurId(utilisateurId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ TachesByUtilisateurId: TacheResponse[] }>({
        query: TachesByUtilisateurId,
        variables: { id : utilisateurId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.TachesByUtilisateurId ?? []).map(toTache) )
      );
  }

  getTacheById(tacheId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ TacheById: TacheResponse }>({
        query: TacheById,
        variables: { id : tacheId}
      })
      .valueChanges.pipe(
        map(result => result.data?.TacheById ? toTache(result.data.TacheById) : null )
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
      .mutate<{ AjouterTache: TacheResponse }>({
        mutation: AjouterTache,
        variables: tacheRequest
      })
      .pipe(
        map(result => result.data?.AjouterTache ? toTache(result.data.AjouterTache) : null )
      );
  }

  ModifierTache(tacheId: number, tacheRequest: TacheRequest): Observable<any> {
    return this.apollo
      .mutate<{ ModifierTache: TacheResponse }>({
        mutation: ModifierTache,
        variables: { id : tacheId, tacheObjet : tacheRequest}
      })
      .pipe(
        map(result => result.data?.ModifierTache ? toTache(result.data.ModifierTache) : null )
      );
  }

  supprimerTache(tacheId: number): Observable<any> {
    return this.apollo
      .mutate<{ supprimerTache: boolean }>({
        mutation: supprimerTache,
        variables: { id : tacheId}
      })
      .pipe(
        map(result => result.data?.supprimerTache )
      );
  }
}
