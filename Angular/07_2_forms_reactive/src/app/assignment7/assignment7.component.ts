import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { CustomValidators } from './custom-validators';

@Component({
  selector: 'app-assignment7',
  templateUrl: './assignment7.component.html',
  styleUrls: ['./assignment7.component.css']
})
export class Assignment7Component implements OnInit {

  myProjectForm: FormGroup;
  statuses = ['Stable', 'Critical', 'Finished'];
  forbiddenProjectNames = ['Test', 'Zero', 'NA'];
  // created for submiting purposes (to enable showing in UI):
  project = {
    projectName: '',
    email: '',
    status: ''
  };
  submitted = false;

  constructor() { }

  ngOnInit() {
    this.myProjectForm = new FormGroup({
      // 'projectName': new FormControl(null, [Validators.required, this.forbiddenNamesValidator.bind(this)]),    // version with validatos below
      'projectName': new FormControl(null, [Validators.required, CustomValidators.invalidProjectName],
      CustomValidators.asyncInvalidProjectName),  // version with validators from separate class
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'status': new FormControl('Critical')
    });
  }

  onSubmit() {
    console.log(this.myProjectForm);
    this.submitted = true;
    this.project.projectName = this.myProjectForm.value.projectName;
    this.project.email = this.myProjectForm.value.email;
    this.project.status = this.myProjectForm.value.status;
    // this.myProjectForm.reset();
  }

  // our own validator
  forbiddenNamesValidator(control: FormControl): { [s: string]: boolean } {
    // to work this.forbiddenUsernamesValidator you should use bind(this), see above
    if (this.forbiddenProjectNames.indexOf(control.value) !== -1) {
      return { 'nameIsFoooooooorbidden': true };
    }
    return null;
  }

}
