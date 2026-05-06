import { Injectable } from '@angular/core';
import {map, Observable} from 'rxjs';
import {ProjetResponse} from '../../model/responses/projet-response.model';
import {Apollo} from 'apollo-angular';
import {GetToutesLesProjets} from '../../graphQl/queries/projet.queries';
import {ProjetGqlModel} from '../../model/graphQl/projet-gql-model';
import {toProjet} from '../../mapper/projet.mapper';

@Injectable({ providedIn: 'root' })
export class ProjetGqlService {

  constructor(private apollo: Apollo) {}

  searchProjets(id: number, search: string): Observable<ProjetResponse[]> {
    return this.apollo
      .watchQuery<
        { searchProjets: ProjetResponse[] },
        { id: number; search: string }
      >({
        query: GetToutesLesProjets,
        variables: { id, search },
        fetchPolicy: 'network-only', // avoid partial cache
      })
      .valueChanges.pipe(
        map(res => (res.data?.searchProjets ?? []).map(toProjet))
      );
  }

  getAllProjects(): Observable<any> {
    return this.apollo
      .watchQuery<{ Projets: ProjetResponse[] }>({
        query: GetToutesLesProjets,
      })
      .valueChanges.pipe(
        map(result => (result.data?.Projets ?? []).map(toProjet) )
      );
  }

}

