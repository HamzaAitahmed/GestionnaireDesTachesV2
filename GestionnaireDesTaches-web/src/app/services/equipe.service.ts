import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Equipe} from '../model/equipe.model';

@Injectable({
  providedIn: 'root'
})
export class EquipeService {
  host:string = "http://localhost:8088/api/Equipe";
  equipesNotFilter: Array<any> = [];
  equipess: Array<Equipe> = [];

  constructor(private http: HttpClient) { }

  public getEquipes(): Observable<Array<Equipe>>{
    return this.http.get<Array<Equipe>>(this.host+"/All");
  }

  // public getEquipes(): Observable<Array<Equipe>>{
  //   return this.http.get<Array<Equipe>>("http://localhost:8088/equipes");
  // }

  public getEquipeById(equipeId:number): Observable<Equipe>{
    return this.http.get<Equipe>(this.host+`/ById/${equipeId}`);
  }

  public ajouterProduct(equipe: Equipe): Observable< Equipe>{
    return this.http.post< Equipe>(this.host+"/AjouterEquipe",{equipe});
  }

  public modifierEquipeById(equipeId:number, equipe:Equipe): Observable<Equipe>{
    return this.http.patch< Equipe>(this.host+`/ById/${equipeId}`,{equipe});
  }

  public supprimerEquipe(equipe: Equipe): Observable< Equipe>{
    return this.http.delete< Equipe>(this.host+`/SupprimerEquipe/${equipe.id}`);
  }

}
