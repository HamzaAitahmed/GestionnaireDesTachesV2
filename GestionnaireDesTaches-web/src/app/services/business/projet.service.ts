import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ProjetResponse} from '../../model/responses/projet-response.model';
import {ProjetRequest} from '../../model/requests/projet-request.model';
import {ProjetGqlService} from '../graphQl/projet-gpl.service';

@Injectable({
  providedIn: 'root'
})

export class ProjetService {

  constructor(private projetGplService : ProjetGqlService) {
  }

  getToutesLesProjets():Observable<ProjetResponse[]>{
    return this.projetGplService.getToutesLesProjets()
  }

  getChercherProjet(projetId:number, search : string):Observable<ProjetResponse[]>{
    return this.projetGplService.getChercherProjet(projetId, search)
  }

  getProjetByChefProjetId(chefProjetId:number):Observable<ProjetResponse[]>{
    return this.projetGplService.getProjetByChefProjetId(chefProjetId)
  }

  getProjetByEquipeDuProjetId(equipeDuProjetId:number):Observable<ProjetResponse[]>{
    return this.projetGplService.getProjetByEquipeDuProjetId(equipeDuProjetId)
  }

  getProjetByTacheId(tacheId:number):Observable<ProjetResponse>{
    return this.projetGplService.getProjetByTacheId(tacheId)
  }

  getProjetById(projetId:number):Observable<ProjetResponse>{
    return this.projetGplService.getProjetById(projetId)
  }

  AjouterProjet(projetRequest: ProjetRequest):Observable<ProjetResponse>{
    return this.projetGplService.AjouterProjet(projetRequest)
  }

  ModifierProjet(projetId: number, projetRequest: ProjetRequest):Observable<ProjetResponse>{
    return this.projetGplService.ModifierProjet(projetId, projetRequest)
  }

  supprimerProjet(projetId: number):Observable<boolean>{
    return this.projetGplService.supprimerProjet(projetId)
  }

}
