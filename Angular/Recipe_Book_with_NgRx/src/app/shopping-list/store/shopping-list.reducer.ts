import { Ingredient } from '../../shared/ingredient.model';
import { Action } from '@ngrx/store';
import * as ShopingListActions from './shopping-list.actions';

const initialState = {
  ingredients: [
    new Ingredient('Apples', 5),
    new Ingredient('Tomatoes', 10)
  ],
};

export function shoppingListReducer(
  state = initialState,
  action: ShopingListActions.ShoppingListActions // fist is imported class,  second is from this class exported type
  ) {
  switch (action.type) {
    case ShopingListActions.ADD_IGREDIENT:
      // state.ingredients.push(); // forbidden aproach, do not use!
      return {
        ...state,        // 'copying' state
        ingredients: [...state.ingredients, action.payload]  // 'copying' ingredients of state amd adding new ingredients
      };
    case ShopingListActions.ADD_IGREDIENTS:
      return{
        ...state,
        ingredients: [...state.ingredients, ... action.payload]
      }
    default:
      return state;
  }
}
