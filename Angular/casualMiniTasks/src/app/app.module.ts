import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbdModalBasic } from './modal/modal-basic';
import { Module2Component } from './module2/module2.component';
import { NgbdModalBasicModule } from './modal/modal-basic.module';

@NgModule({
  declarations: [
    AppComponent,
    Module2Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbdModalBasicModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
