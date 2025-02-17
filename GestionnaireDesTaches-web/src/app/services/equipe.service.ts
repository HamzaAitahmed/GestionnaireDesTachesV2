import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Equipe} from '../model/equipe.model';
import {Apollo, QueryRef} from 'apollo-angular';
import {Query_Toutes_Equipes} from '../graphqlQueries/equipe.queries';
import {Projet} from '../model/projet.model';

@Injectable({
  providedIn: 'root'
})

export class EquipeService {
  private EquipeServiceUrl = "http://localhost:8088/api/Equipe/"
  equipesNotFilter:any = null;
  equipess: Array<Equipe> = [];
  equipes: Array<Equipe> = [];
  loading:any = null
  error:any = null
  constructor(private http: HttpClient, private apollo:Apollo) { }

  getToutesLesEquipesGql(): QueryRef<{ Equipes: Equipe[] }> {
    return this.apollo.watchQuery<{ Equipes: Equipe[] }>({
      query: Query_Toutes_Equipes // Utilisez la requête importée
    });
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

  public getEquipeById(equipeId:number): Observable<Equipe>{
    // return this.http.get<Equipe>(this.EquipeServiceUrl+`/ById/${equipeId}`);
    this.equipesNotFilter = this.http.get<Equipe>(this.EquipeServiceUrl+`ById/${equipeId}`);
    console.log("############ getEquipeById : equipesNotFilter ")
    console.log(this.equipesNotFilter)
    return this.equipesNotFilter;
  }

  public ajouterProduct(equipe: Equipe): Observable< Equipe>{
    return this.http.post<Equipe>(this.EquipeServiceUrl+"AjouterEquipe",{equipe});
  }

  public modifierEquipeById(equipeId:number, equipe:Equipe): Observable<Equipe>{
    return this.http.patch< Equipe>(this.EquipeServiceUrl+`ById/${equipeId}`,{equipe});
  }

  public supprimerEquipe(equipe: Equipe): Observable< Equipe>{
    // return this.http.delete< Equipe>(this.EquipeServiceUrl+`/SupprimerEquipe/${equipe.id}`);
    this.equipesNotFilter = this.http.delete< Equipe>(this.EquipeServiceUrl+`/SupprimerEquipe/${equipe.id}`);
    console.log("\n8 - ############ supprimerEquipe : equipesNotFilter ")
    console.log(this.equipesNotFilter)
    return this.equipesNotFilter;
  }

}
