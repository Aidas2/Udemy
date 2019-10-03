import { Ingredient } from '../shared/ingredient.model';
import { EventEmitter } from '@angular/core';
import {Subject} from 'rxjs';

export class ShoppingListService {

  // ingredientsChanged = new EventEmitter<Ingredient[]>(); // to put data in original array, not in copy made by slice()
  ingredientsChanged = new Subject<Ingredient[]>();


  private ingredients: Ingredient[] = [
    new Ingredient('Apples', 5),
    new Ingredient('Tomatoes', 10)
  ];

  getIngredients() {
    return this.ingredients.slice();
  }

  addIngredient(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
    // this.ingredientsChanged.emit(this.ingredients.slice());  // to put data in original array, not in copy made by slice()
    this.ingredientsChanged.next(this.ingredients.slice());

  }

  addIngredients(ingredients: Ingredient[]) {

    // version #1 (not recommended, because too many event emittions):
    // for (let ingredient of ingredients) {
    //   this.addIngredient(ingredient);
    // }

    // version #2:
    this.ingredients.push(...ingredients);
    this.ingredientsChanged.next(this.ingredients.slice());

  }

}

