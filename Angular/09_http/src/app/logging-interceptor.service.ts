import { HttpInterceptor, HttpRequest, HttpHandler, HttpResponse, HttpEventType } from '@angular/common/http';
import { tap } from 'rxjs/operators';

export class LoggingIntereptorService implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    console.log('=== Outgoing request === ');
    console.log(req.url);
    console.log(req.headers); // thouhg loged as second, but it mus be with custom key (means auth interceptors acts first)

    return next.handle(req).pipe(
      tap(event => {
        if (event.type === HttpEventType.Response) {
          console.log('=== Incoming response ===');
          console.log(event.body);
        }
      })
    );
  }
}
