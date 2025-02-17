import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EquipeRoutingModule } from './equipe-routing.module';
import { EquipeComponent } from './equipe.component';
import { AjouterEquipeComponent } from './ajouter-equipe/ajouter-equipe.component';
import { ModifierEquipeComponent } from './modifier-equipe/modifier-equipe.component';
import { ProjetDEquipeComponent } from './projet-dequipe/projet-dequipe.component';
import { MembreDEquipeComponent } from './membre-dequipe/membre-dequipe.component';


@NgModule({
  declarations: [
    EquipeComponent,
    AjouterEquipeComponent,
    ModifierEquipeComponent,
    ProjetDEquipeComponent,
    MembreDEquipeComponent
  ],
  imports: [
    CommonModule,
    EquipeRoutingModule
  ]
})
export class EquipeModule { }
