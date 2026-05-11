import { Injectable } from '@angular/core';
import {map, Observable, tap} from 'rxjs';
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
      .watchQuery<{ Projets: ProjetResponse[] }>({
        query: ToutesLesProjets,
      })
      .valueChanges.pipe(
        map(result => (result.data?.Projets ?? []).map(toProjet) )
      );
  }

  getChercherProjet(chefProjetId : number, search : string): Observable<any> {
    return this.apollo
      .watchQuery<{ ProjetsSearch: ProjetResponse[] }>({
        query: ChercherProjet,
        variables: { id : chefProjetId, search : search}
      })
      .valueChanges.pipe(
        // tap(result => { console.log('RAW GRAPHQL RESULT:', result); }),
        map(result => (result.data?.ProjetsSearch ?? []).map(toProjet) ),
        // tap(projet => { console.log('MAPPED PROJECTS:', projet); })
      );
  }

  getProjetByChefProjetId(chefProjetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ ProjetByChefProjetId: ProjetResponse[] }>({
        query: ProjetByChefProjetId,
        variables: { id : chefProjetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.ProjetByChefProjetId ?? []).map(toProjet) )
      );
  }

  getProjetByEquipeDuProjetId(equipeDuProjetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ ProjetByEquipeDuProjetId: ProjetResponse[] }>({
        query: ProjetByEquipeDuProjetId,
        variables: { id : equipeDuProjetId}
      })
      .valueChanges.pipe(
        map(result => (result.data?.ProjetByEquipeDuProjetId ?? []).map(toProjet) )
      );
  }

  getProjetByTacheId(tacheId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ ProjetByTacheId: ProjetResponse }>({
        query: ProjetByTacheId,
        variables: { id : tacheId }
      })
      .valueChanges.pipe(
        map(result => result.data?.ProjetByTacheId ? toProjet(result.data.ProjetByTacheId) : null ),
      );
  }

  getProjetById(projetId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ ProjetById: ProjetResponse }>({
        query: ProjetById,
        variables: { id : projetId}
      })
      .valueChanges.pipe(
        map(result => result.data?.ProjetById ? toProjet(result.data.ProjetById) : null )
      );
  }

  AjouterProjet(projetRequest: ProjetRequest): Observable<any> {
    return this.apollo
      .mutate<{ AjouterProjet: ProjetResponse }>({
        mutation: AjouterProjet,
        variables: {projetObjet : projetRequest}
      })
      .pipe(
        map(result => result.data?.AjouterProjet ? toProjet(result.data.AjouterProjet) : null )
      );
  }

  ModifierProjet(projetId: number, projetRequest: ProjetRequest): Observable<any> {
    return this.apollo
      .mutate<{ ModifierProjet: ProjetResponse }>({
        mutation: ModifierProjet,
        variables: { id : projetId, projetObjet : projetRequest}
      })
      .pipe(
        map(result => result.data?.ModifierProjet ? toProjet(result.data.ModifierProjet) : null )
      );
  }

  supprimerProjet(projetId: number): Observable<any> {
    return this.apollo
      .mutate<{ supprimerProjet: boolean }>({
        mutation: supprimerProjet,
        variables: { id : projetId}
      })
      .pipe(
        map(result => result.data?.supprimerProjet )
      );
  }

}

