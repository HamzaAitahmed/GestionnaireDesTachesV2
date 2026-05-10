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
      .watchQuery<{ equipes: EquipeResponse[] }>({
        query: EquipeByChefEquipeId,
        variables: {chefEquipeId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.equipes ?? []).map(toEquipe) )
      );
  }

  getEquipeByMemberEquipeId(memberEquipeId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ equipes: EquipeResponse[] }>({
        query: EquipeByMemberEquipeId,
        variables: {memberEquipeId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.equipes ?? []).map(toEquipe) )
      );
  }

  getEquipeByProjetEquipeId(projetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ equipes: EquipeResponse[] }>({
        query: EquipeByProjetEquipeId,
        variables: {projetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.equipes ?? []).map(toEquipe) )
      );
  }

  getEquipeById(equipeId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ equipe: EquipeResponse }>({
        query: EquipeById,
        variables: {equipeId}
      })
      .valueChanges.pipe(
        map(result => result.data?.equipe ? toEquipe(result.data.equipe) : null)
      );
  }

  AjouterEquipe(equipeRequest: EquipeRequest): Observable<any> {
    return this.apollo
      .mutate<{ equipeReponse: EquipeResponse }>({
        mutation: AjouterEquipe,
        variables: equipeRequest
      })
      .pipe(
        map(result => result.data?.equipeReponse ? toEquipe(result.data.equipeReponse) : null )
      );
  }

  ModifierEquipe(equipeId: number, equipeRequest: EquipeRequest): Observable<any> {
    return this.apollo
      .mutate<{ equipeReponse: EquipeResponse }>({
        mutation: ModifierEquipe,
        variables: {equipeId, equipeRequest}
      })
      .pipe(
        map(result => result.data?.equipeReponse ? toEquipe(result.data.equipeReponse) : null )
      );
  }

  supprimerEquipe(equipeId: number): Observable<any> {
    return this.apollo
      .mutate<{ Boolean: boolean }>({
        mutation: supprimerEquipe,
        variables: {equipeId}
      })
      .pipe(
        map(result => result.data?.Boolean )
      );
  }

}
