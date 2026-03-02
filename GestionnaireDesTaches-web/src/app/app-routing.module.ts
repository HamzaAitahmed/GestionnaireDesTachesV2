import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ErreurComponent} from './shared/erreur/erreur.component';
import {AuthGuard} from './guards/auth.guard';
import {ROUTE_AUTH, ROUTE_ERREUR, ROUTE_MAIN} from './constants/global.constants';

const routes: Routes = [
  { path: '', redirectTo: ROUTE_MAIN, pathMatch: 'full'}, // Default route
  { path: ROUTE_AUTH, loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  { path: ROUTE_MAIN, loadChildren: () => import('./main/main.module').then(m => m.MainModule), canMatch: [AuthGuard] },
  { path: ROUTE_ERREUR, component: ErreurComponent },
  { path: '**', redirectTo: ROUTE_ERREUR }, // Redirection pour les routes inconnues
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
