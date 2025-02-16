import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ErreurComponent} from './shared/erreur/erreur.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' }, // Default route
  { path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  { path: 'main', loadChildren: () => import('./main/main.module').then(m => m.MainModule) },
  { path: 'erreur', component: ErreurComponent },
  // { path: '**', redirectTo: 'erreur' }, // Redirection pour les routes inconnues
  { path: '**', redirectTo: '/auth/home' }, // Redirection pour les routes inconnues
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
