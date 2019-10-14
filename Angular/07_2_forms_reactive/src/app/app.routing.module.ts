import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { Assignment7Component } from './assignment7/assignment7.component';
import { NgModule } from '@angular/core';

const appRoutes: Routes = [
  // { path: '', redirectTo: '/form', pathMatch: 'full' },
  { path: 'form', component: AppComponent },
  { path: 'assigment7', component: Assignment7Component }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
