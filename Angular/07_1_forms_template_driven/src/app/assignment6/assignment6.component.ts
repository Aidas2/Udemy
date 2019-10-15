import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-assignment6',
  templateUrl: './assignment6.component.html',
  styleUrls: ['./assignment6.component.css']
})
export class Assignment6Component implements OnInit {

  subscriptions = ['Basic', 'Advanced', 'Pro'];
  selectedSubscription = 'Advanced';
  @ViewChild('signupForm', { static: false }) sForm: NgForm;
  // created for submiting purposes (to enable showing in UI):
  submitted = false;
  data = {
    email: '',
    subscription: '',
    password: ''
  };

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.sForm.value);
    this.submitted = true;
    this.data.email = this.sForm.value.email;
    this.data.subscription = this.sForm.value.subscription;
    this.data.password = this.sForm.value.password;
    this.sForm.reset();
  }

}
