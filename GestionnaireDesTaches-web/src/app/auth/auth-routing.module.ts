import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {InscriptionComponent} from './inscription/inscription.component';
import {ConnecterComponent} from './connecter/connecter.component';
import {DeconnecterComponent} from './deconnecter/deconnecter.component';

export const auth_routes: Routes = [
  // { path: '', redirectTo: 'connecter', pathMatch: 'full' }, // Default to projet module
  { path: 'auth', redirectTo: 'connecter', pathMatch: 'full' }, // Default to projet module
  { path: 'connecter', component: ConnecterComponent },
  { path: 'deconnecter', component: DeconnecterComponent },
  { path: 'inscription', component: InscriptionComponent },
];

@NgModule({
  imports: [RouterModule.forChild(auth_routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
