import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  private host:string="http://localhost:8082";
  // utilisateur
  constructor(private http:HttpClient) { }
  // saveData(data)
  // {
  //   console.log('saving data ...');
  // }
  getAllProjets() : Observable<any>  {
    console.log('get All Projets ...');
    return this.http.get(this.host+"/api/Equipe/All")
  }

  //   !!!!!! ERROR !!!!!!!
  //
  // ModifierProjetById(projetId:string) {
  //   console.log('get All Projets ...');
  //   this.http.patch(this.host+`/projets/${projetId}`,{projetId:!'0'})
  //     .subscribe({projetId})
  // }

  // login(utilisateur) {
  //   return this.http.post(
  //     this.host+"/Authentification",
  //     utilisateur,
  //     {observe:"response"}
  //   )
  // }
}
