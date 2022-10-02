import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { throwError, Subject, BehaviorSubject } from 'rxjs';
import { User } from './user.model';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';

// properties according to
// https://firebase.google.com/docs/reference/rest/auth#section-create-email-password

export interface AuthResponseData {
  kind?: string;
  idToken: string;
  email: string;
  refreshToken: string;
  expiresIn: string;
  localId: string;
  registered?: boolean; // ? means optional
}

@Injectable({ providedIn: 'root' })
export class AuthService {

  // possible version:
  // user = new Subject<User>();  // 1) preparing user, which will be considered as logged or signed
  // token: string = null;

  user = new BehaviorSubject<User>(null);
  private tokenExpirationTimer: any;

  constructor(private http: HttpClient, private router: Router) { }

  signup(email: string, password: string) {
    return this.http.post<AuthResponseData>(
      // according to https://firebase.google.com/docs/reference/rest/auth#section-create-email-password
      'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=' + environment.firebaseAPIKey,
      {
        email: email,
        password: password,
        returnSecureToken: true
      }
    )
      .pipe(
        catchError(this.handleError),
        tap(respData => {
          //   const expirationDate = new Date(  // all this moved to separate method
          //     new Date().getTime() + +respData.expiresIn * 1000
          //   );
          //   const user = new User (  // 2) constructing user from data from response
          //     respData.email,
          //     respData.localId,
          //     respData.idToken,
          //     expirationDate
          //   );
          //   this.user.next(user);    // 2) emitting/assigning created user as currently logged
          this.handleAuthentication(
            respData.email,
            respData.localId,
            respData.idToken,
            +respData.expiresIn
          );
        })
      );
  }

  login(email: string, password: string) {
    return this.http.post<AuthResponseData>(
      // according to https://firebase.google.com/docs/reference/rest/auth#section-sign-in-email-password
      'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=' + environment.firebaseAPIKey,
      {
        email: email,
        password: password,
        returnSecureToken: true
      }
    )
      .pipe(
        catchError(this.handleError),
        tap(respData => {
          this.handleAuthentication(
            respData.email,
            respData.localId,
            respData.idToken,
            +respData.expiresIn
          );
        })
      );
  }

  // autologin means loging according to data stored in localStorage
  autoLogin() {
    const userData: {
      email: string;
      id: string;
      _token: string;
      _tokenExpirationDate: string
    } = JSON.parse(localStorage.getItem('userData')); // parse() - converting back from text to object
    if (!userData) {
      return;
    }

    const loadedUser = new User(
      userData.email,
      userData.id,
      userData._token,
      new Date(userData._tokenExpirationDate)
    );

    if (loadedUser.token) {  // cheking if token is present and also if valid
      this.user.next(loadedUser);  // emmiting user whitch was created from localStorage
      const expirationDurationLeft = new Date(userData._tokenExpirationDate).getTime() - new Date().getTime();
      this.autoLogout(expirationDurationLeft);

    }
  }

  logout() {
    this.user.next(null);
    this.router.navigate(['/auth']);
    // localStorage.clear();
    localStorage.removeItem('userData');
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
    }
    this.tokenExpirationTimer = null;

  }

  autoLogout(expirationDuration: number) {
    console.log(expirationDuration);    // 3600 000 msec = 3600 sec = 1 hour
    this.tokenExpirationTimer = setTimeout(() => {
      this.logout();
    }, expirationDuration);
  }

  private handleAuthentication(email: string, userId: string, token: string, expiresIn: number) {
    const expirationDate = new Date(
      new Date().getTime() + expiresIn * 1000
    );
    const user = new User(
      email,
      userId,
      token,
      expirationDate
    );
    this.user.next(user);
    this.autoLogout(expiresIn * 1000);
    localStorage.setItem('userData', JSON.stringify(user)); // (key, value)
    // value is converted from object to text to enable storing object (because it can't be stored as object)
  }



  private handleError(errorResp: HttpErrorResponse) {

    let errorMessage = 'An unknown error occured';
    if (!errorResp.error || !errorResp.error.error) {
      return throwError(errorMessage);
    }
    switch (errorResp.error.error.message) {
      case 'EMAIL_EXISTS':
        errorMessage = 'This email exists already';
        break;
      case 'EMAIL_NOT_FOUND':
        errorMessage = 'This email doesn\'t exists';
        break;
      case 'INVALID_PASSWORD':
        errorMessage = 'This  password is not correct';
        break;
      case 'USER_DISABLED':
        errorMessage = 'This user is disabled';
        break;
    }
    return throwError(errorMessage);
  }



}
