import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable()
export class BasePathInterceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('token');

    if (token) {
      if (!request.url.includes('http')) {
        request = request.clone({
          url: request.url.includes('normativos') ? environment.REST_URL_EXTRACAO + '/' + request.url : environment.REST_URL_SITE + '/' + request.url,
          setHeaders: {
            Authorization: `Bearer ${token}`
          }
        });
      }
    } else {
      if (!request.url.includes('http')) {
        request = request.clone({
          url: request.url.includes('normativos') ? environment.REST_URL_EXTRACAO + '/' + request.url : environment.REST_URL_SITE + '/' + request.url
        });
      }
    }


    return next.handle(request);
  }
}
