import { Injectable } from '@angular/core';
import {Apollo} from 'apollo-angular';
import {map, Observable} from 'rxjs';
import {UtilisateurResponse} from '../../model/responses/utilisateur-response.model';
import {UtilisateurById, UtilisateurByEmail, ToutesLesUtilisateurs} from '../../graphQl/queries/utilisateur.queries';
import {toUtilisateur} from '../../mapper/utilisateur.mapper';
import {UtilisateurRequest} from '../../model/requests/utilisateur-request.model';
import {
  AjouterUtilisateur,
  ModifierUtilisateur,
  supprimerUtilisateur
} from '../../graphQl/mutation/utilisateur.mutation';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurGplService {
  constructor(private apollo: Apollo) {
  }

  getToutesLesUtilisateurs(): Observable<any> {
    return this.apollo
      .watchQuery<{ Utilisateurs: UtilisateurResponse[] }>({
        query: ToutesLesUtilisateurs
      })
      .valueChanges.pipe(
        map(result => (result.data?.Utilisateurs ?? []).map(toUtilisateur) )
      );
  }

  getUtilisateurByEmail(email : string): Observable<any> {
    return this.apollo
      .watchQuery<{ Utilisateur: UtilisateurResponse }>({
        query: UtilisateurByEmail,
        variables: {email}
      })
      .valueChanges.pipe(
        map(result => result.data?.Utilisateur ? toUtilisateur(result.data.Utilisateur) : null )
      );
  }

  getUtilisateurById(utilisateurId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ Utilisateur: UtilisateurResponse }>({
        query: UtilisateurById,
        variables: {utilisateurId}
      })
      .valueChanges.pipe(
        map(result => result.data?.Utilisateur ? toUtilisateur(result.data.Utilisateur) : null )
      );
  }

  AjouterUtilisateur(utilisateurRequest: UtilisateurRequest): Observable<any> {
    return this.apollo
      .mutate<{ utilisateurReponse: UtilisateurResponse }>({
        mutation: AjouterUtilisateur,
        variables: utilisateurRequest
      })
      .pipe(
        map(result => result.data?.utilisateurReponse ? toUtilisateur(result.data.utilisateurReponse) : null )
      );
  }

  ModifierUtilisateur(utilisateurId: number, utilisateurRequest: UtilisateurRequest): Observable<any> {
    return this.apollo
      .mutate<{ utilisateurReponse: UtilisateurResponse }>({
        mutation: ModifierUtilisateur,
        variables: {utilisateurId, utilisateurRequest}
      })
      .pipe(
        map(result => result.data?.utilisateurReponse ? toUtilisateur(result.data.utilisateurReponse) : null )
      );
  }

  supprimerUtilisateur(utilisateurId: number): Observable<any> {
    return this.apollo
      .mutate<{ Boolean: boolean }>({
        mutation: supprimerUtilisateur,
        variables: {utilisateurId}
      })
      .pipe(
        map(result => result.data?.Boolean )
      );
  }

}
