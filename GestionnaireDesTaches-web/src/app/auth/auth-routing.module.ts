import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {InscriptionComponent} from './inscription/inscription.component';
import {ConnecterComponent} from './connecter/connecter.component';
import {DeconnecterComponent} from './deconnecter/deconnecter.component';
import {ErreurComponent} from '../shared/erreur/erreur.component';
import {  ROUTE_AUTH, ROUTE_CONNECTER, ROUTE_DECONNECTER, ROUTE_ERREUR, ROUTE_INSCRIPTION } from '../constants/global.constants';

export const auth_routes: Routes = [
  { path: ROUTE_AUTH, redirectTo: ROUTE_CONNECTER, pathMatch: 'full' },
  { path: ROUTE_CONNECTER, component: ConnecterComponent },
  { path: ROUTE_DECONNECTER, component: DeconnecterComponent },
  { path: ROUTE_INSCRIPTION, component: InscriptionComponent },
  { path: ROUTE_ERREUR, component: ErreurComponent },
];

@NgModule({
  imports: [RouterModule.forChild(auth_routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
