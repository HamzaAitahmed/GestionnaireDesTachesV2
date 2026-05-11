import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AjouterTacheComponent} from '../tache/ajouter-tache/ajouter-tache.component';
import {ModifierTacheComponent} from '../tache/modifier-tache/modifier-tache.component';
import {ListeDesTachesComponent} from './liste-des-taches/liste-des-taches.component';
import {ROUTE_TACHE} from '../../constants/global.constants';
import {ListeDesTachesDuProjetComponent} from './liste-des-taches-du-projet/liste-des-taches-du-projet.component';


const routes: Routes = [
  { path: 'list_tache', component: ListeDesTachesComponent },
  { path: 'projet_list_tache/:projetId', component: ListeDesTachesDuProjetComponent },
  { path: 'ajouter_tache', component: AjouterTacheComponent },
  { path: 'modifier_tache', component: ModifierTacheComponent },
  { path: ROUTE_TACHE, redirectTo: 'list_tache', pathMatch: 'full'}, // Default to list view
  { path: '', redirectTo: 'list_tache', pathMatch: 'full'}, // Default to list view
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TacheRoutingModule { }
