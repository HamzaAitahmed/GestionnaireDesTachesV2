import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TacheRoutingModule } from './tache-routing.module';
import { TacheComponent } from './tache.component';
import { ListeDesTachesComponent } from './liste-des-taches/liste-des-taches.component';
import { AjouterTacheComponent } from './ajouter-tache/ajouter-tache.component';
import { ModifierTacheComponent } from './modifier-tache/modifier-tache.component';


@NgModule({
  declarations: [
    TacheComponent,
    ListeDesTachesComponent,
    AjouterTacheComponent,
    ModifierTacheComponent
  ],
  imports: [
    CommonModule,
    TacheRoutingModule
  ]
})
export class TacheModule { }
