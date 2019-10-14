import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray } from '@angular/forms';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  genders = ['male', 'female'];
  mySignupForm: FormGroup;
  forbiddenUsernames = ['Chris', 'Anna'];

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.mySignupForm = new FormGroup({
      'myUserData': new FormGroup({
        'myUsername': new FormControl(null, [Validators.required, this.forbiddenNames.bind(this)]),
        'myEmail': new FormControl(null, [Validators.required, Validators.email], this.forbiddenEmails),
      }),
      'myGender': new FormControl('male'),
      'hobbies': new FormArray([])
    });

    // this.mySignupForm.valueChanges.subscribe(
    //   (value) => console.log(value)
    // );

    this.mySignupForm.statusChanges.subscribe(
      (status) => console.log(status)
    );

    this.mySignupForm.setValue({      // setting value (same as in template-driven)
      'myUserData': {
        'myUsername': 'Max',
        'myEmail': 'max@test.com'
      },
      'myGender': 'male',
      'hobbies': []
    });

    this.mySignupForm.patchValue({    // // updating/patching value (same as in template-driven)
      'myUserData': {
        'myUsername': 'Oksana',
      },
    });

  }

  onSubmit() {
    console.log(this.mySignupForm);
    this.mySignupForm.reset();
  }

  onAddHobby() {
    const control = new FormControl(null, Validators.required);
    // (<> ...) this is casting !!!
    (<FormArray>this.mySignupForm.get('hobbies')).push(control);
  }

  getControls() {
    return (<FormArray>this.mySignupForm.get('hobbies')).controls;
  }

  // our own validator
  forbiddenNames(control: FormControl): { [s: string]: boolean } {
    // to work this.forbiddenUsernames you should use bind(this), see above
    if (this.forbiddenUsernames.indexOf(control.value) !== -1) {
      return { 'nameIsForbidden': true };
    }
    return null;
  }

  // our own validator (asynchronous)
  forbiddenEmails(control: FormControl): Promise<any> | Observable<any> {
    const promise = new Promise<any>((resolve, reject) => {
      setTimeout(() => {
        if (control.value === 'test@test.com') {
          resolve({ 'emailIsForbidden': true });
        } else {
          resolve(null);
        }
      }, 2000);
    });
    return promise;
  }

}
