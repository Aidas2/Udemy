import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit {


  @ViewChild('nameInput'/*, { static: false }*/) nameInputRef: ElementRef;
  @ViewChild('amountInput'/*, { static: false }*/) amountInputRef: ElementRef;

  constructor() { }

  ngOnInit() {
  }

  onAddItem() {

  }
}
