import { NgModule } from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import { AuthRoutingModule } from './auth-routing.module';
import { AuthComponent } from './auth.component';
import { ConnecterComponent } from './connecter/connecter.component';
import { DeconnecterComponent } from './deconnecter/deconnecter.component';
import { InscriptionComponent } from './inscription/inscription.component';
import {SharedModule} from '../shared/shared.module';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AuthComponent,
    ConnecterComponent,
    DeconnecterComponent,
    InscriptionComponent,
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    SharedModule,
    ReactiveFormsModule,
    NgOptimizedImage,
  ]
})
export class AuthModule { }
