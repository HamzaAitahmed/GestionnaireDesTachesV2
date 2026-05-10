import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {EquipeResponse} from '../../model/responses/equipe-response.model';
import {EquipeRequest} from '../../model/requests/equipe-request.model';
import {EquipeGplService} from '../graphQl/equipe-gpl.service';

@Injectable({
  providedIn: 'root'
})

export class EquipeService {

  constructor(private equipeGplService:EquipeGplService) { }

  getToutesLesEquipes():Observable<EquipeResponse[]>{
    return this.equipeGplService.getToutesLesEquipes()
  }

  getEquipeByChefEquipeId(chefEquipeId:number):Observable<EquipeResponse[]>{
    return this.equipeGplService.getEquipeByChefEquipeId(chefEquipeId)
  }

  getEquipeByMemberEquipeId(memberEquipeId:number):Observable<EquipeResponse[]>{
    return this.equipeGplService.getEquipeByMemberEquipeId(memberEquipeId)
  }

  getEquipeByProjetEquipeId(projetId : number):Observable<EquipeResponse[]>{
    return this.equipeGplService.getEquipeByProjetEquipeId(projetId)
  }

  getEquipeById(equipeId : number):Observable<EquipeResponse>{
    return this.equipeGplService.getEquipeById(equipeId)
  }

  AjouterEquipe(equipeRequest: EquipeRequest):Observable<EquipeResponse>{
    return this.equipeGplService.AjouterEquipe(equipeRequest)
  }

  ModifierEquipe(equipeId: number, equipeRequest: EquipeRequest):Observable<EquipeResponse>{
    return this.equipeGplService.ModifierEquipe(equipeId, equipeRequest)
  }

  supprimerEquipe(equipeId: number):Observable<boolean>{
    return this.equipeGplService.supprimerEquipe(equipeId)
  }

}
