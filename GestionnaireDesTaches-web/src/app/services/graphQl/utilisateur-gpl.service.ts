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
      .watchQuery<{ UtilisateurByEmail: UtilisateurResponse }>({
        query: UtilisateurByEmail,
        variables: { email : email}
      })
      .valueChanges.pipe(
        map(result => result.data?.UtilisateurByEmail ? toUtilisateur(result.data.UtilisateurByEmail) : null )
      );
  }

  getUtilisateurById(utilisateurId : number): Observable<any> {
    return this.apollo
      .watchQuery<{ UtilisateurById: UtilisateurResponse }>({
        query: UtilisateurById,
        variables: { id : utilisateurId}
      })
      .valueChanges.pipe(
        map(result => result.data?.UtilisateurById ? toUtilisateur(result.data.UtilisateurById) : null )
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
      .mutate<{ ModifierUtilisateur: UtilisateurResponse }>({
        mutation: ModifierUtilisateur,
        variables: { id : utilisateurId, utilisateurObjet : utilisateurRequest}
      })
      .pipe(
        map(result => result.data?.ModifierUtilisateur ? toUtilisateur(result.data.ModifierUtilisateur) : null )
      );
  }

  supprimerUtilisateur(utilisateurId: number): Observable<any> {
    return this.apollo
      .mutate<{ supprimerUtilisateur: boolean }>({
        mutation: supprimerUtilisateur,
        variables: { id : utilisateurId}
      })
      .pipe(
        map(result => result.data?.supprimerUtilisateur )
      );
  }

}
