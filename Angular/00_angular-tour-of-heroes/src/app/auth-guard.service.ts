import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable} from 'rxjs/Observable';

export class AuthGuard implements CanActivate {
  canActivate(route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promisse<boolean> | boolean {

    }
}
