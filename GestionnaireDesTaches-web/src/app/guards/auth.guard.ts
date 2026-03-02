import {CanMatch, Router, UrlTree} from '@angular/router';
import {AuthentificationService} from '../services/authentification.service';
import {Injectable} from '@angular/core';
import {catchError, map, Observable, of} from 'rxjs';
import {ROUTE_AUTH, URL_REFRESH} from '../constants/global.constants';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanMatch {

  constructor(private authService: AuthentificationService, private router: Router) {}

  canMatch(): Observable<boolean | UrlTree>{

    if (this.authService.isAuthenticated()) {
      return of(true);
    }

    if(this.authService.checkRefreshToken()){
      return this.authService.refreshTokenProcess(URL_REFRESH).pipe(
        map(() => true),
        catchError(() => of(false))
      );
    }

    this.authService.deconnexion();
    return of(this.router.parseUrl(ROUTE_AUTH));
  }
}
