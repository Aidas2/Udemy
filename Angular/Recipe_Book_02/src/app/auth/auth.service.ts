import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

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

  constructor(private http: HttpClient) { }

  signup(email: string, password: string) {
    return this.http.post<AuthResponseData>(
      // according to https://firebase.google.com/docs/reference/rest/auth#section-create-email-password
      'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyDLP9Nndr3DE1I9D2qXZ1t0422y5khICaA',
      {
        email: email,
        password: password,
        returnSecureToken: true
      }
    )
      .pipe(catchError(this.handleError));
  }

  login(email: string, password: string) {
    return this.http.post<AuthResponseData>(
      // according to https://firebase.google.com/docs/reference/rest/auth#section-sign-in-email-password
      'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDLP9Nndr3DE1I9D2qXZ1t0422y5khICaA',
      {
        email: email,
        password: password,
        returnSecureToken: true
      }
    )
      .pipe(catchError(this.handleError));
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
