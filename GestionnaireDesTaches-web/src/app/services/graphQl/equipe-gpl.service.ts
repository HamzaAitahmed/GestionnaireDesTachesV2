import { Injectable } from '@angular/core';
import {Apollo} from 'apollo-angular';
import {map, Observable} from 'rxjs';
import {EquipeResponse} from '../../model/responses/equipe-response.model';
import {
  EquipeByChefEquipeId, EquipeById,
  EquipeByMemberEquipeId,
  EquipeByProjetEquipeId,
  ToutesLesEquipes
} from '../../graphQl/queries/equipe.queries';
import {toEquipe} from '../../mapper/equipe.mapper';
import {EquipeRequest} from '../../model/requests/equipe-request.model';
import {AjouterEquipe, ModifierEquipe, supprimerEquipe} from '../../graphQl/mutation/equipe.mutation';

@Injectable({
  providedIn: 'root',
})
export class EquipeGplService {

  constructor(private apollo: Apollo) {
  }

  getToutesLesEquipes(): Observable<any> {
    return this.apollo
      .watchQuery<{ equipes: EquipeResponse[] }>({
        query: ToutesLesEquipes
      })
      .valueChanges.pipe(
        map(result => (result.data?.equipes ?? []).map(toEquipe) )
      );
  }

  getEquipeByChefEquipeId(chefEquipeId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ EquipeByChefEquipeId: EquipeResponse[] }>({
        query: EquipeByChefEquipeId,
        variables: { id : chefEquipeId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.EquipeByChefEquipeId ?? []).map(toEquipe) )
      );
  }

  getEquipeByMemberEquipeId(memberEquipeId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ EquipeByMemberEquipeId: EquipeResponse[] }>({
        query: EquipeByMemberEquipeId,
        variables: { id : memberEquipeId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.EquipeByMemberEquipeId ?? []).map(toEquipe) )
      );
  }

  getEquipeByProjetEquipeId(projetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ EquipeByProjetEquipeId: EquipeResponse[] }>({
        query: EquipeByProjetEquipeId,
        variables: { id : projetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.EquipeByProjetEquipeId ?? []).map(toEquipe) )
      );
  }

  getEquipeById(equipeId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ EquipeById: EquipeResponse }>({
        query: EquipeById,
        variables: { id : equipeId}
      })
      .valueChanges.pipe(
        map(result => result.data?.EquipeById ? toEquipe(result.data.EquipeById) : null)
      );
  }

  AjouterEquipe(equipeRequest: EquipeRequest): Observable<any> {
    return this.apollo
      .mutate<{ AjouterEquipe: EquipeResponse }>({
        mutation: AjouterEquipe,
        variables: equipeRequest
      })
      .pipe(
        map(result => result.data?.AjouterEquipe ? toEquipe(result.data.AjouterEquipe) : null )
      );
  }

  ModifierEquipe(equipeId: number, equipeRequest: EquipeRequest): Observable<any> {
    return this.apollo
      .mutate<{ ModifierEquipe: EquipeResponse }>({
        mutation: ModifierEquipe,
        variables: { id : equipeId, equipeObjet : equipeRequest}
      })
      .pipe(
        map(result => result.data?.ModifierEquipe ? toEquipe(result.data.ModifierEquipe) : null )
      );
  }

  supprimerEquipe(equipeId: number): Observable<any> {
    return this.apollo
      .mutate<{ supprimerEquipe: boolean }>({
        mutation: supprimerEquipe,
        variables: { id : equipeId}
      })
      .pipe(
        map(result => result.data?.supprimerEquipe )
      );
  }

}
