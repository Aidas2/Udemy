import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';

const appRoutes: Routes = [
  { path: '', redirectTo: '/recipes', pathMatch: 'full' },
  // empty path: '' match any route, therefore we using pathMath, which enables redirect only when full path is empty
  { path: 'recipes', loadChildren: './recipes/recipes.module#RecipesModule' },    // lazy loading
  { path: 'shopping-list', loadChildren: './shopping-list/shopping-list.module#ShoppingListModule'},     // lazy loading
  {path: 'auth', loadChildren: './auth/auth.module#AuthModule' }
];

// alternative for Anguar 8+ (in tsconfig.json "module": "esnext" should be replaced with "module": "es2015")
// const routes: Routes = [{
//   path: 'recipes',
//   loadChildren: () => import('./recipes/recipes.module').then(m => m.RecipesModule)
// }];


@NgModule({
  imports: [RouterModule.forRoot(appRoutes, {preloadingStrategy: PreloadAllModules})],
  exports: [RouterModule]    // preparing for exporting to app.module.ts
})

export class AppRoutingModule {

}

