import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListDesProjetsComponent} from './list-des-projets/list-des-projets.component';
import {AjouterProjetComponent} from './ajouter-projet/ajouter-projet.component';
import {ModifierProjetComponent} from './modifier-projet/modifier-projet.component';
import {ROUTE_PROJET} from '../../constants/global.constants';

const routes: Routes = [
  { path: 'list_projet', component: ListDesProjetsComponent },
  { path: 'ajouter_projet', component: AjouterProjetComponent },
  { path: 'modifier_projet', component: ModifierProjetComponent },
  { path: ROUTE_PROJET, redirectTo: 'list_projet', pathMatch: 'full'}, // Default to list view
  { path: '', redirectTo: 'list_projet', pathMatch: 'full'}, // Default to list view
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjetRoutingModule { }
