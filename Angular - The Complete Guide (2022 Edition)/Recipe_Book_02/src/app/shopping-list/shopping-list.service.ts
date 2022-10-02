import { Ingredient } from '../shared/ingredient.model';
import { EventEmitter } from '@angular/core';
import { Subject } from 'rxjs';

export class ShoppingListService {

  // ingredientsChanged = new EventEmitter<Ingredient[]>(); // to put data in original array, not in copy made by slice()
  ingredientsChanged = new Subject<Ingredient[]>(); // for tracking changes
  startedEditing = new Subject<number>();

  private ingredients: Ingredient[] = [
    new Ingredient('Apples', 5),
    new Ingredient('Tomatoes', 10)
  ];

  getIngredients() {
    return this.ingredients.slice();
  }

  getIngredient(index: number) {
    return this.ingredients[index];
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
    this.ingredientsChanged.next(this.ingredients.slice()); // emitting (sliced elements of array)

  }

  updateIngredient(index: number, newIngredient: Ingredient) {
    this.ingredients[index] = newIngredient;
    this.ingredientsChanged.next(this.ingredients.slice()); // emitting (sliced elements of array)
  }

  deleteIngredient(index: number) {
    this.ingredients.splice(index, 1);  // splice(starting index, amount of removed elements)
    this.ingredientsChanged.next(this.ingredients.slice()); // if slice() is empty it passes copy of array (there in no sliced elements)
  }

}

