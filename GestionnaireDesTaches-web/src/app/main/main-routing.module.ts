import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ErreurComponent} from '../shared/erreur/erreur.component';
import {MainComponent} from './main.component';
import {EquipeComponent} from './equipe/equipe.component';
import {ProjetComponent} from './projet/projet.component';
import {TacheComponent} from './tache/tache.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {UtilisateurComponent} from './utilisateur/utilisateur.component';

const routes: Routes = [
  // { path: 'main', component: MainComponent },

  // { path: 'dash', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule) },
  // { path: 'equipe', loadChildren: () => import('./equipe/equipe.module').then(m => m.EquipeModule) },
  // { path: 'projet', loadChildren: () => import('./projet/projet.module').then(m => m.ProjetModule) },
  // { path: 'tache', loadChildren: () => import('./tache/tache.module').then(m => m.TacheModule) },
  // { path: 'utilisateur', loadChildren: () => import('./utilisateur/utilisateur.module').then(m => m.UtilisateurModule) },
  // { path: 'main', redirectTo: '', pathMatch: 'full' }, // Default to projet module

  {
    path: '', component: MainComponent, // Route principale
    children: [
      { path: 'dash', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule) },
      { path: 'equipe', loadChildren: () => import('./equipe/equipe.module').then(m => m.EquipeModule) },
      { path: 'projet', loadChildren: () => import('./projet/projet.module').then(m => m.ProjetModule) },
      { path: 'tache', loadChildren: () => import('./tache/tache.module').then(m => m.TacheModule) },
      { path: 'utilisateur', loadChildren: () => import('./utilisateur/utilisateur.module').then(m => m.UtilisateurModule) },
      { path: '', redirectTo: 'projet', pathMatch: 'full' } // Redirection par défaut
    ]
  },
  // { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
