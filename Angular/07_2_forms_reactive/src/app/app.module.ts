import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { Assignment7Component } from './assignment7/assignment7.component';

@NgModule({
  declarations: [
    AppComponent,
    Assignment7Component
  ],
  imports: [
    BrowserModule,
    // FormsModule,  // this is for TD_Forms
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
