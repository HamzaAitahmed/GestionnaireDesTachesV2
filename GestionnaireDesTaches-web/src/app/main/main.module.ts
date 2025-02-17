import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainRoutingModule } from './main-routing.module';
import { MainComponent } from './main.component';
import {ProjetModule} from './projet/projet.module';
import {EquipeModule} from './equipe/equipe.module';
import {TacheModule} from './tache/tache.module';
import {UtilisateurModule} from './utilisateur/utilisateur.module';
import {SharedModule} from '../shared/shared.module';


@NgModule({
  declarations: [
    MainComponent,
  ],
  imports: [
    CommonModule,
    MainRoutingModule,
    SharedModule,
    EquipeModule,
    ProjetModule,
    TacheModule,
    UtilisateurModule,
  ]
})
export class MainModule { }
