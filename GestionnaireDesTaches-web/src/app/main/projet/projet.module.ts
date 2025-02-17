import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjetRoutingModule } from './projet-routing.module';
import { ProjetComponent } from './projet.component';
import { ListDesProjetsComponent } from './list-des-projets/list-des-projets.component';
import {MatDialogModule} from '@angular/material/dialog';
import {SharedModule} from '../../shared/shared.module';
import { AjouterProjetComponent } from './ajouter-projet/ajouter-projet.component';
import { ModifierProjetComponent } from './modifier-projet/modifier-projet.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    ProjetComponent,
    ListDesProjetsComponent,
    AjouterProjetComponent,
    ModifierProjetComponent
  ],
  imports: [
    CommonModule,
    ProjetRoutingModule,
    MatDialogModule,
    SharedModule,
    FormsModule,
  ]
})
export class ProjetModule { }
