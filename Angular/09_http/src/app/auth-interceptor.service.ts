import { HttpInterceptor, HttpRequest, HttpHandler, HttpEventType } from '@angular/common/http';
import { tap } from 'rxjs/operators';

export class AuthInterceptorService implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    if (req.url) {    // this way you may control behavior

    }

    // console.log('Request is on its way');  // all logs commented because we created intercepror for logging
    // console.log(req.url);
    // const modifiedRequest = req.clone({ url: 'some-new-url' });    // this way you may modify request
    const modifiedRequest = req.clone({ headers: req.headers.append('Auth', 'xyz') });    // this way you may modify request

    // return next.handle(req); // returning original request
    return next.handle(modifiedRequest);          // returning mofified request
    //   .pipe(
    //   tap(event => {                             // operator tap just looks into response
    //     console.log(event);
    //     if (event.type === HttpEventType.Response) {
    //       console.log('==== Response arrived, body data: ');
    //       console.log(event.body);
    //     }
    //   })
    // );
  }
}
