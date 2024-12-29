import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TacheComponent } from './tache/tache.component';
import { ProjetComponent } from './projet/projet.component';
import { SectionComponent } from './section/section.component';
import { NavbarComponent } from './section/navbar/navbar.component';
import { SidebarComponent } from './section/sidebar/sidebar.component';
import { EquipeComponent } from './equipe/equipe.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { ListDesMembresEquipeComponent } from './equipe/list-des-membres-equipe/list-des-membres-equipe.component';
import { ListDesProjetsEquipeComponent } from './equipe/list-des-projets-equipe/list-des-projets-equipe.component';
import { ModifierEquipeComponent } from './equipe/modifier-equipe/modifier-equipe.component';
import { AjouterEquipeComponent } from './equipe/ajouter-equipe/ajouter-equipe.component';
import { AjouterTacheComponent } from './tache/ajouter-tache/ajouter-tache.component';
import { ModifierTacheComponent } from './tache/modifier-tache/modifier-tache.component';
import { ChangerPasswordComponent } from './utilisateur/changer-password/changer-password.component';
import { InformationPersonneComponent } from './utilisateur/information-personne/information-personne.component';
import { ModifierProjetComponent } from './projet/modifier-projet/modifier-projet.component';
import { AjouterProjetComponent } from './projet/ajouter-projet/ajouter-projet.component';
import { ListDesEquipesComponent } from './equipe/list-des-equipes/list-des-equipes.component';
import { HomeComponent } from './home/home.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { InscriptionComponent } from './Authentification/inscription/inscription.component';
import { DeconnexionComponent } from './Authentification/deconnexion/deconnexion.component';
import { ConnecterComponent } from './Authentification/connecter/connecter.component';
import { ListDesUtilisateursComponent } from './utilisateur/list-des-utilisateurs/list-des-utilisateurs.component';
import {ListDesProjetsComponent} from './projet/list-des-projets/list-des-projets.component';
import {provideHttpClient} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    TacheComponent,
    ProjetComponent,
    SectionComponent,
    NavbarComponent,
    SidebarComponent,
    EquipeComponent,
    UtilisateurComponent,
    ListDesProjetsComponent,
    ListDesMembresEquipeComponent,
    ListDesProjetsEquipeComponent,
    ModifierEquipeComponent,
    AjouterEquipeComponent,
    AjouterTacheComponent,
    ModifierTacheComponent,
    ChangerPasswordComponent,
    InformationPersonneComponent,
    ModifierProjetComponent,
    AjouterProjetComponent,
    ListDesEquipesComponent,
    HomeComponent,
    AuthentificationComponent,
    InscriptionComponent,
    DeconnexionComponent,
    ConnecterComponent,
    ListDesUtilisateursComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [provideHttpClient()],
  bootstrap: [AppComponent]
})
export class AppModule { }
