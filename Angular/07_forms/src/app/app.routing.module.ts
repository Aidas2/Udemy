import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { Assignment6Component } from './assignment6/assignment6.component';
import { NgModule } from '@angular/core';

const appRoutes: Routes = [
// {path: '', redirectTo: '/form', pathMatch: 'full'},
{path: 'form', component: AppComponent},
{path: 'assigment6', component: Assignment6Component}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
