import {HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {AuthentificationService} from '../services/authentification.service';
import {catchError, switchMap, throwError} from 'rxjs';
import {TokenRequest} from '../model/requests/token.request';
import {TokenResponse} from '../model/responses/token.response';
import {URL_REDIRECT_TO_REFRESH} from '../constants/global.constants';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  private isRefreshing = false;

  constructor(private authService: AuthentificationService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {

    const token: TokenRequest = this.authService.getToken();

    let authReq = req;

    if (token?.accessToken) {
      authReq = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token.accessToken}`
        },
        withCredentials: true
      });
    }

    return next.handle(authReq).pipe(

      catchError(error => {
        if (req.url.includes(URL_REDIRECT_TO_REFRESH)) {
          return throwError(() => error);
        }

        if (error.status === 401 && !this.isRefreshing) {

          this.isRefreshing = true;

          return this.authService.refreshTokenProcess(URL_REDIRECT_TO_REFRESH).pipe(

            switchMap((newToken: TokenResponse) => {

              this.isRefreshing = false;
              this.authService.setAccessToken(newToken.accessToken);

              const retryReq = req.clone({
                setHeaders: {
                  Authorization: `Bearer ${newToken.accessToken}`
                },
                withCredentials: true
              });

              return next.handle(retryReq);
            }),
            catchError(refreshError => {
              this.isRefreshing = false;
              this.authService.deconnexionProcess();
              return throwError(() => refreshError);
            })
          );
        }

        return throwError(() => error);
      })
    );
  }
}
