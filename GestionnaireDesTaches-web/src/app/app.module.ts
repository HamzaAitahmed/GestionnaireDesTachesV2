import {inject, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainModule } from './main/main.module';
import {HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AuthModule} from './auth/auth.module';
import {MatDialogModule} from '@angular/material/dialog';
import {provideApollo} from 'apollo-angular';
import {HttpLink} from 'apollo-angular/http';
import { InMemoryCache } from '@apollo/client/core';
import {AuthInterceptor} from './interceptor/auth.interceptor';
import {URL_BACKEND} from './constants/global.constants';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    AuthModule,
    MainModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
  ],
  providers: [
    provideHttpClient(withInterceptorsFromDi()),
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    provideApollo(() => {
      const httpLink = inject(HttpLink);

      return {
        link: httpLink.create({
          uri: URL_BACKEND+'/graphql',
        }),
        cache: new InMemoryCache(),
      };
    }),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
