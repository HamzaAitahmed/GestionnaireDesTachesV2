import { Injectable } from '@angular/core';
import {TacheGplService} from '../graphQl/tache-gpl.service';
import {Observable} from 'rxjs';
import {TacheResponse} from '../../model/responses/tache-response.model';
import {TacheRequest} from '../../model/requests/tache-request.model';

@Injectable({
  providedIn: 'root',
})
export class TacheService {

  constructor(private tacheGplService:TacheGplService) {
  }

  getTachesByProjetId(projetId:number):Observable<TacheResponse[]>{
    return this.tacheGplService.getTachesByProjetId(projetId)
  }

  getTachesByUtilisateurId(utilisateurId:number):Observable<TacheResponse[]>{
    return this.tacheGplService.getTachesByUtilisateurId(utilisateurId)
  }

  getTacheById(tacheId:number):Observable<TacheResponse>{
    return this.tacheGplService.getTacheById(tacheId)
  }

  getToutesLesTaches():Observable<TacheResponse[]>{
    return this.tacheGplService.getToutesLesTaches()
  }

  AjouterTache(tacheRequest: TacheRequest):Observable<TacheResponse[]>{
    return this.tacheGplService.AjouterTache(tacheRequest)
  }

  ModifierTache(tacheId: number, tacheRequest: TacheRequest):Observable<TacheResponse[]>{
    return this.tacheGplService.ModifierTache(tacheId, tacheRequest)
  }

  supprimerTache(tacheId: number):Observable<boolean>{
    return this.tacheGplService.supprimerTache(tacheId)
  }

}
