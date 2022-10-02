import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, UrlTree } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, tap, take } from 'rxjs/operators';

import { AuthService } from './auth.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    router: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Promise<boolean | UrlTree>
    | Observable<boolean | UrlTree> {
    return this.authService.user        // returns Observable (but not boolean as required)
      .pipe(
        take(1),                        // subscribed, byt looks only once (and unsubscribes automatically)
        map(user => {
          // return !!user;             // returns true/false finally. Note: user inside has information is or isn't he authenticated(?)
          const isAuth = !!user;  // new fashion approach
          if (isAuth) {
            return true;
          }
          return this.router.createUrlTree(['/auth']);    // retuns if false

        }),
        // tap(isAuth => {         // old fashion approach
        //   if (!isAuth) {
        //     this.router.navigate(['/auth']);
        //   }
        // })
      );

  }
}
