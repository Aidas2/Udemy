import { Action } from '@ngrx/store';
import { Ingredient } from 'src/app/shared/ingredient.model';

export const ADD_IGREDIENT = 'ADD_IGREDIENT';
export const ADD_IGREDIENTS = 'ADD_IGREDIENTS';


export class AddIngredient implements Action {
  readonly type = ADD_IGREDIENT;
  // payload: Ingredient;
  constructor(public payload: Ingredient) {}
}

export class AddIngredients implements Action {
  readonly type = ADD_IGREDIENTS;

  constructor(public payload: Ingredient[]) {}
}

export type ShoppingListActions = AddIngredient | AddIngredients;  // combined types
