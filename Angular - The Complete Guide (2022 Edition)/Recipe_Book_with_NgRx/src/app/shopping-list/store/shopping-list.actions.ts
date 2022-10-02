import { Action } from '@ngrx/store';
import { Ingredient } from 'src/app/shared/ingredient.model';

export const ADD_IGREDIENT = 'ADD_IGREDIENT';
export const ADD_IGREDIENTS = 'ADD_IGREDIENTS';
export const UPDATE_INGREDIENT = 'UPDATE_INGREDIENT';
export const DELETE_INGREDIENT = 'DELETE_INGREDIENT';
export const START_EDIT = 'START_EDIT';
export const STOP_EDIT = 'STOP_EDIT';

export class AddIngredient implements Action {
  readonly type = ADD_IGREDIENT;
  // payload: Ingredient;
  constructor(public payload: Ingredient) {}  // creating payload via constructor (finaly it does something useful :) )
}

export class AddIngredients implements Action {
  readonly type = ADD_IGREDIENTS;

  constructor(public payload: Ingredient[]) {}
}

export class UpdateIngredient implements Action {
  readonly type = UPDATE_INGREDIENT;

  // constructor(public payload: {index: number, ingredient: Ingredient}) {}
  constructor(public payload: Ingredient) {}

}

export class DeleteIngredient implements Action {
readonly type = DELETE_INGREDIENT;

// constructor(public payload: number) {}
}

export class StartEdit implements Action {
  readonly type = START_EDIT;

  constructor(public payload: number) {}
}

export class StopEdit implements Action {
  readonly type = STOP_EDIT;
}

export type ShoppingListActions =
| AddIngredient
| AddIngredients
| UpdateIngredient
| DeleteIngredient
| StartEdit
| StopEdit;  // combined types
