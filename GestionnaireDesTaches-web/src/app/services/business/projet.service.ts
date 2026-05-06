import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Apollo, gql, QueryRef} from 'apollo-angular';
import {HttpClient} from '@angular/common/http';
import { GetToutesLesProjets } from '../../graphQl/queries/projet.queries';
import {ProjetResponse} from '../../model/responses/projet-response.model';
import {URL_BACKEND, URL_PROJET} from '../../constants/global.constants';
import {ProjetGqlService} from '../graphQl/projet-gpl.service';

@Injectable({
  providedIn: 'root'
})

export class ProjetService {
  private projetUrl = URL_BACKEND + URL_PROJET;

  public projetsNotFiltred: any;
  projetsNotFilter:any = null;
  projetss: Array<ProjetResponse> = [];
  projets: Array<ProjetResponse> = [];
  loading:any = null
  error:any = null

  constructor(private apollo: Apollo,private http: HttpClient, private projetGqlService: ProjetGqlService) {}

  getProjetsByUser(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.projetUrl}/${userId}/projets`);
  }

  ajouterProjet(projet: ProjetResponse): Observable<any[]> {
    console.log("ProjetService projetAjouter : ")
    console.log(projet)
    return this.http.post<any[]>(URL_PROJET+`/projets`,{projet});
    // return this.http.post<any[]>(`${this.projetUrl}/AjouterProjet`,{projet});  // il y a une erreur je crois que je dois utiliser projetDTO etc ...
  }


  // getProjetsByUserGql(userId: number, search: string): QueryRef<{ searchProjets: ProjetResponse[] }, { id: number; search: string  }> {
  //   return this.apollo.watchQuery<{ searchProjets: ProjetResponse[] }, { id: number; search: string}>({
  //     query: Query_Projets, // Utilisez la requête importée
  //     variables: {
  //       id: userId,
  //       search: search,
  //     },
  //   });
  // }

  getProjetsByUserGql(userId: number,search: string): Observable<ProjetResponse[]> {
    return this.projetGqlService.searchProjets(userId, search);
  }

  getAllProjects(): Observable<ProjetResponse[]> {
    return this.projetGqlService.getAllProjects();
  }


  // getAllProjects(): Observable<any> {
  //   console.log("getAllProjects : ")
  //   this.projetsNotFiltred = this.apollo
  //     .watchQuery<{ projects: Projet[] }>({
  //       query: GET_ALL_PROJECTS,
  //     })
  //     .valueChanges.pipe(map((result) => result.data.projects));
  //   console.log(this.projetsNotFiltred)
  //   return this.projetsNotFiltred;
  // }

  // getProjetsByUserGql(userId: number): QueryRef<{ Projets: Projet[] }, { userId: number }> {
  //   return this.apollo.watchQuery<{ Projets: Projet[] }, { userId: number }>({
  //     query: gql`
  //       query GetProjetsByUser($userId: Int!) {
  //         Projets (id: $userId){
  //           id
  //           nom
  //           description
  //           statut
  //           chefProjet {
  //             id
  //             profilePicture
  //           }
  //           equipeDeProjet {
  //             id
  //             nom
  //             mesMembers {
  //               id
  //               profilePicture
  //             }
  //           }
  //         }
  //       }
  //     `,
  //     variables: {
  //       userId: userId,
  //     },
  //   });
  // }

  // getAllProjets(): Observable<any> {
  //   console.log("result.data.allProjets  2 : ")
  //
  //   return this.apollo.query({
  //     query: gql`
  //       query {
  //         Projets {
  //           id
  //           nom
  //           description
  //           budget
  //         }
  //       }
  //     `
  //   });
  // }
  // getAllProjets(): Observable<Array<Projet>> {
  //   this.apollo.query({
  //     query: Query_Projets
  //   });
  // }
}
