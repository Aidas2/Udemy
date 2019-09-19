import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-assignment03',
  templateUrl: './assignment03.component.html',
  styleUrls: ['./assignment03.component.css']
})
export class Assignment03Component implements OnInit {

  password = 'tuna';
  showPassword = false;
  loggedClicks = [];

  constructor() { }

  ngOnInit() {
  }

  onToggleDetails() {
    this.showPassword = !this.showPassword;                // this is toggling !!!
    // this.loggedClicks.push(this.loggedClicks.length + 1); // this is incrementing !!!
    this.loggedClicks.push(new Date());

  }
}
