import { Injectable } from '@angular/core';
import {UtilisateurResponse} from '../../model/responses/utilisateur-response.model';
import {UtilisateurGplService} from '../graphQl/utilisateur-gpl.service';
import {Observable} from 'rxjs';
import {UtilisateurRequest} from '../../model/requests/utilisateur-request.model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private utilisateurGplService:UtilisateurGplService) {
  }

  getToutesLesUtilisateurs():Observable<UtilisateurResponse[]>{
    return this.utilisateurGplService.getToutesLesUtilisateurs()
  }

  getUtilisateurById(utilisateurId:number):Observable<UtilisateurResponse>{
    return this.utilisateurGplService.getUtilisateurById(utilisateurId)
  }

  getUtilisateurByEmail(email : string):Observable<UtilisateurResponse>{
    return this.utilisateurGplService.getUtilisateurByEmail(email)
  }

  AjouterUtilisateur(utilisateurRequest: UtilisateurRequest):Observable<UtilisateurResponse>{
    return this.utilisateurGplService.AjouterUtilisateur(utilisateurRequest)
  }

  ModifierUtilisateur(utilisateurId: number, utilisateurRequest: UtilisateurRequest):Observable<UtilisateurResponse>{
    return this.utilisateurGplService.ModifierUtilisateur(utilisateurId, utilisateurRequest)
  }

  supprimerUtilisateur(utilisateurId: number):Observable<boolean>{
    return this.utilisateurGplService.supprimerUtilisateur(utilisateurId)
  }

}
