import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { Assignment7Component } from './assignment7/assignment7.component';
import { AppRoutingModule } from './app.routing.module';

@NgModule({
  declarations: [
    AppComponent,
    Assignment7Component
  ],
  imports: [
    BrowserModule,
    // FormsModule,  // this is for TD_Forms
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
