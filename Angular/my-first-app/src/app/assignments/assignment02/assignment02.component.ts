import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-assignment02',
  templateUrl: './assignment02.component.html',
  styleUrls: ['./assignment02.component.css']
})
export class UsernameComponent implements OnInit {

  userName = '';
  // allowToReset = this.userName === '' ? true : false; // doesnt works ? :(

  constructor() { }

  ngOnInit() {

  }

  onResetUser() {
    this.userName = '';
  }
}
