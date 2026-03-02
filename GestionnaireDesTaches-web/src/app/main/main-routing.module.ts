import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainComponent} from './main.component';
import {AuthGuard} from '../guards/auth.guard';
import {
  ROUTE_DASHBOARD,
  ROUTE_EQUIPE, ROUTE_MAIN,
  ROUTE_PROJET,
  ROUTE_TACHE,
  ROUTE_UTILISATEUR
} from '../constants/global.constants';

const routes: Routes = [
  {
    path: '', component: MainComponent, canMatch: [AuthGuard] ,
    children: [
      { path: '', redirectTo: ROUTE_MAIN, pathMatch: 'full' },
      { path: ROUTE_MAIN, redirectTo: ROUTE_DASHBOARD, pathMatch: 'full' },
      { path: ROUTE_DASHBOARD, loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule) },
      { path: ROUTE_EQUIPE, loadChildren: () => import('./equipe/equipe.module').then(m => m.EquipeModule) },
      { path: ROUTE_PROJET, loadChildren: () => import('./projet/projet.module').then(m => m.ProjetModule) },
      { path: ROUTE_TACHE, loadChildren: () => import('./tache/tache.module').then(m => m.TacheModule) },
      { path: ROUTE_UTILISATEUR, loadChildren: () => import('./utilisateur/utilisateur.module').then(m => m.UtilisateurModule) },
    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
