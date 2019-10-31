import { Component } from '@angular/core';
import { NgForm, Form } from '@angular/forms';

import { AuthService, AuthResponseData } from './auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-auth',
  templateUrl: 'auth.component.html'
})
export class AuthComponent {
  isLoginMode = true;
  isLoading = false;
  error: string = null;

  constructor(private authService: AuthService) { }

  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
  }

  onSubmit(form: NgForm) {
    // console.log(form.value);
    if (!form.valid) {
      return;
    }
    const email = form.value.email;
    const password = form.value.password;

    let authObs: Observable<AuthResponseData>;

    this.isLoading = true;

    /*
    // before moving subscription and logic to observable authObs
    if (this.isLoginMode) {
      this.authService.login(email, password).subscribe(
        respData => {
          console.log(respData);
          this.isLoading = false;
        },
        errorMessage => {    // this name is acconding to return in auth.service.ts
          console.log(errorMessage);
          this.error = errorMessage;
          this.isLoading = false;
        }
        );
    } else {
      this.authService.signup(email, password).subscribe(
        respData => {
          console.log(respData);
          this.isLoading = false;
        },
        // errorRes => {
        //   console.log(errorRes);
        //   this.error = errorRes.error.error.message; // this tree comes from response in console
        //   this.error = 'An error occured ...';
        //   this.isLoading = false;
        // }
        errorMessage => {    // this name is acconding to return in auth.service.ts
          console.log(errorMessage);
          this.error = errorMessage;
          this.isLoading = false;
        }
        );
      authObs = this.authService.signup(email, password);
    }
    */

    // after moving subscription and logic to observable authObs
    if (this.isLoginMode) {
      authObs = this.authService.login(email, password);
    } else {
      authObs = this.authService.signup(email, password);
    }

    authObs.subscribe(
      respData => {
        console.log(respData);
        this.isLoading = false;
      },
      errorMessage => {    // this name is acconding to return in auth.service.ts
        console.log(errorMessage);
        this.error = errorMessage;
        this.isLoading = false;
      }
    );

    form.reset();
  }

}
