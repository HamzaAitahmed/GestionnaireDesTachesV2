import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {TacheComponent} from './tache/tache.component';
import {ProjetComponent} from './projet/projet.component';
import {EquipeComponent} from './equipe/equipe.component';

const routes: Routes = [
  { path:'', redirectTo:'/home', pathMatch: 'full' },
  { path:'home', component: HomeComponent },
  { path:'projet', component: ProjetComponent },
  // { path:'utilisateur', component: UtilisateurComponent },
  { path:'equipe', component: EquipeComponent },
  { path:'tache', component: TacheComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
