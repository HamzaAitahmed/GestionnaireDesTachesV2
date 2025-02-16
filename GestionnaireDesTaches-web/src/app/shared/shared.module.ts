import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import {ErreurComponent} from './erreur/erreur.component';
import {RouterLink} from '@angular/router';
import { SupprimerCaracterePipePipe } from './pipes/supprimer-caractere-pipe.pipe';


@NgModule({
  declarations: [
    NavbarComponent,
    SidebarComponent,
    ErreurComponent,
    SupprimerCaracterePipePipe,
  ],
  imports: [
    CommonModule,
    RouterLink,
  ],
    exports: [NavbarComponent, SidebarComponent, ErreurComponent, SupprimerCaracterePipePipe], // Exporte les composants

})
export class SharedModule { }
