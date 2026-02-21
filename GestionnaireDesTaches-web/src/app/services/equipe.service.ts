import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {EquipeResponse} from '../model/responses/equipe-response.model';
import {Apollo, QueryRef} from 'apollo-angular';
import {Query_Toutes_Equipes} from '../graphqlQueries/equipe.queries';

@Injectable({
  providedIn: 'root'
})

export class EquipeService {
  private EquipeServiceUrl = "http://localhost:8088/api/Equipe/"
  equipesNotFilter:any = null;
  equipess: Array<EquipeResponse> = [];
  equipes: Array<EquipeResponse> = [];
  loading:any = null
  error:any = null
  constructor(private http: HttpClient, private apollo:Apollo) { }

  getToutesLesEquipesGql(): QueryRef<{ Equipes: EquipeResponse[] }> {
    return this.apollo.watchQuery<{ Equipes: EquipeResponse[] }>({
      query: Query_Toutes_Equipes // Utilisez la requête importée
    });
  }

  GetToutesLesEquipes(): Observable<any[]> {
    return this.apollo.watchQuery<any>({
      query: Query_Toutes_Equipes
    })
      .valueChanges
      .pipe(
        map(result => result.data.Equipes)
      );
  }


  // public getEquipes(): Observable<Array<Equipe>>{
  //   // return this.http.get<Array<Equipe>>(this.EquipeServiceUrl+"/All");
  //   this.equipesNotFilter = this.http.get<Array<Equipe>>(this.EquipeServiceUrl+"/All");
  //   console.log("7 - ############ getEquipes : equipesNotFilter ")
  //   console.log(this.equipesNotFilter)
  //   return this.equipesNotFilter;
  // }

  // public getEquipes(): Observable<Array<Equipe>>{
  //   return this.http.get<Array<Equipe>>("http://localhost:8088/equipes");
  // }

  public getEquipeById(equipeId:number): Observable<EquipeResponse>{
    // return this.http.get<EquipeResponse>(this.EquipeServiceUrl+`/ById/${equipeId}`);
    this.equipesNotFilter = this.http.get<EquipeResponse>(this.EquipeServiceUrl+`ById/${equipeId}`);
    console.log("############ getEquipeById : equipesNotFilter ")
    console.log(this.equipesNotFilter)
    return this.equipesNotFilter;
  }

  public ajouterProduct(equipe: EquipeResponse): Observable< EquipeResponse>{
    return this.http.post<EquipeResponse>(this.EquipeServiceUrl+"AjouterEquipe",{equipe});
  }

  public modifierEquipeById(equipeId:number, equipe:EquipeResponse): Observable<EquipeResponse>{
    return this.http.patch< EquipeResponse>(this.EquipeServiceUrl+`ById/${equipeId}`,{equipe});
  }

  public supprimerEquipe(equipe:EquipeResponse): Observable<EquipeResponse>{
    // return this.http.delete< EquipeResponse>(this.EquipeServiceUrl+`/SupprimerEquipe/${equipe.id}`);
    this.equipesNotFilter = this.http.delete<EquipeResponse>(this.EquipeServiceUrl+`/SupprimerEquipe/${equipe.id}`);
    console.log("\n8 - ############ supprimerEquipe : equipesNotFilter ")
    console.log(this.equipesNotFilter)
    return this.equipesNotFilter;
  }

}
