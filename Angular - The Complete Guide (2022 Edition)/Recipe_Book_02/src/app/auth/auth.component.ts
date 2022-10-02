import { Component, ComponentFactoryResolver, ViewChild, OnDestroy } from '@angular/core';
import { NgForm, Form } from '@angular/forms';

import { AuthService, AuthResponseData } from './auth.service';
import { Observable, Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { AlertComponent } from '../shared/alert/alert.component';
import { PlaceHolderDirective } from '../shared/placeholder/placeholder.directive';

@Component({
  selector: 'app-auth',
  templateUrl: 'auth.component.html'
})
export class AuthComponent implements OnDestroy {
  isLoginMode = true;
  isLoading = false;
  error: string = null;

  @ViewChild(PlaceHolderDirective /*, { static: false }*/) alertHost: PlaceHolderDirective;
  private closeSub: Subscription;

  constructor(private authService: AuthService, private router: Router, private componentFactoryResolver: ComponentFactoryResolver) { }

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
        this.router.navigate(['./recipes']);

      },
      errorMessage => {    // this name is acconding to return in auth.service.ts
        console.log(errorMessage);
        this.error = errorMessage;
        this.showErorAlert(errorMessage);
        this.isLoading = false;
      }
    );

    form.reset();
  }

  // showing error alert  not programmatically:
  onHandleError() {
    this.error = null;
  }

  ngOnDestroy() {
    if (this.closeSub) {
      this.closeSub.unsubscribe();
    }
  }

  // showing error alert programmatically:
  private showErorAlert(message: string) {
    // const alertCmp = new AlertComponent(); // will work for Javascript, won't work for Angular
    const alertCmpFactory = this.componentFactoryResolver.resolveComponentFactory(AlertComponent);
    const hostViewContainerRef = this.alertHost.viewContainerRef;
    hostViewContainerRef.clear();

    const componentRef = hostViewContainerRef.createComponent(alertCmpFactory);

    componentRef.instance.message = message;                                   // binding property
    this.closeSub = componentRef.instance.close.subscribe(() => {               // binding event
      this.closeSub.unsubscribe();
      hostViewContainerRef.clear();
    });
  }

}
