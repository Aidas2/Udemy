import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, tap } from 'rxjs/operators';

import { RecipeService } from '../recipes/recipe-service';
import { Recipe } from '../recipes/recipe.model';

@Injectable({providedIn: 'root'})
export class DataStorageService {

  constructor(private http: HttpClient, private recipeService: RecipeService) {}


  storeRecipes() {
    const recipes = this.recipeService.getRecipes();
    // post - add one or more recepies to existing;
    // put - overwrites all existing;
    this.http.put('https://recipe-book-2-3565f.firebaseio.com/recipes.json', recipes)
    .subscribe(response => {
      console.log(response);
    });
  }

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


}
