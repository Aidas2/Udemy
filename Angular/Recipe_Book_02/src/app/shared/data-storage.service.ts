import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, tap, take, exhaustMap } from 'rxjs/operators';

import { RecipeService } from '../recipes/recipe-service';
import { Recipe } from '../recipes/recipe.model';
import { AuthService } from '../auth/auth.service';

@Injectable({providedIn: 'root'})
export class DataStorageService {

  constructor(private http: HttpClient, private recipeService: RecipeService, private authService: AuthService) {}


  storeRecipes() {
    const recipes = this.recipeService.getRecipes();
    // post - add one or more recepies to existing;
    // put - overwrites all existing;
    this.http.put('https://recipe-book-2-3565f.firebaseio.com/recipes.json', recipes)
    .subscribe(response => {
      console.log(response);
    });
  }

  // BEFORE merging both observables (user and http) in to one big observable (see bellow)
  /*
  fetchRecipes() {
    return this.http
    .get<Recipe[]>(
      'https://recipe-book-2-3565f.firebaseio.com/recipes.json')
    .pipe(
      map(recipesMaybeWithoutIngredients => {
       return recipesMaybeWithoutIngredients.map(recipeMWI => {
          return {
            ...recipeMWI,
            ingredients: recipeMWI.ingredients ? recipeMWI.ingredients : []
          };
        });
      }),
      tap(recipesArray => {
        this.recipeService.setRecipes(recipesArray);
      })
    );
    // .subscribe(recipesArray => {    // subcribe() moved to header.component.ts
    // console.log(recipesArray);
    // this.recipeService.setRecipes(recipesArray);
    // });
  }
  */

  // AFTER  merging both observables (user and http) in to one big observable (both pipe() methods also merged)
  fetchRecipes() {
  // moved to auth-interceptor-service.ts (therefore added pipe in line 66 and ev):
  // return this.authService.user.pipe(
  //   take(1),            // take(1) means that I'm taking ONE value from observable (and auto-unsubscribing)
  //   exhaustMap(user => {

      return this.http.get<Recipe[]>(
        // version_1, adding token to path as query:
        // 'https://recipe-book-2-3565f.firebaseio.com/recipes.json?auth=' + user.token
        // version_2, adding second argument in path
        'https://recipe-book-2-3565f.firebaseio.com/recipes.json'
        // {
        //   params: new HttpParams().set('auth', user.token) // donot adding anything here (because adding in inerceptor)
        // }
      ).pipe(

        // adding previously used map() and tap() as next methods after take() and exhaustMap()
        map(recipesMaybeWithoutIngredients => {
          return recipesMaybeWithoutIngredients.map(recipeMWI => {
            return {
              ...recipeMWI,
              ingredients: recipeMWI.ingredients ? recipeMWI.ingredients : []
            };
          });
        }),
        tap(recipesArray => {
          this.recipeService.setRecipes(recipesArray);
        })

      );
    }

  // );
  // }

}
