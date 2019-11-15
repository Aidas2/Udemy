import { Ingredient } from '../../shared/ingredient.model';
import { Action } from '@ngrx/store';
import * as ShopingListActions from './shopping-list.actions';

export interface State {    // creating interface just to escape necessarity to edit state fields everywhere
  ingredients: Ingredient[];
  editedIngredient: Ingredient;
  editedIngredientIndex: number;
}

export interface AppState {    // application wide inderface, not just for this reducer as previous
  shoppingList: State;
}


const initialState: State = {
  ingredients: [
    new Ingredient('Apples', 5),
    new Ingredient('Tomatoes', 10)
  ],
  editedIngredient: null,    // means not exist
  editedIngredientIndex: -1  // means not valid (doesn't exist in aray)
};

export function shoppingListReducer(
  state: State = initialState,
  action: ShopingListActions.ShoppingListActions // fist is imported class,  second is from this class exported type
  ) {
  switch (action.type) {
    case ShopingListActions.ADD_IGREDIENT:
      // state.ingredients.push(); // forbidden aproach, do not use! Should work with copy of state !
      return {
        ...state,        // 'copying' state
        ingredients: [...state.ingredients, action.payload]  // 'copying' ingredients of state amd adding new ingredients
      };
    case ShopingListActions.ADD_IGREDIENTS:
      return {
        ...state,
        ingredients: [...state.ingredients, ... action.payload]
      };
      case ShopingListActions.UPDATE_INGREDIENT: // this is recomended pattern (original state stays immutable, working with copy of it)
        const ingredientToUpdate = state.ingredients[action.payload.index];
        const updatedIngredient = {
          ...ingredientToUpdate,        // copying original ingredient
          ...action.payload.ingredient  // overwriting with ingredient from payload
        };
        const updatedIngredients = [...state.ingredients];              // copying original array
        updatedIngredients[action.payload.index] = updatedIngredient;    // replacing old element in array

        return {
          ...state,
          ingredients: updatedIngredients
        };
      case ShopingListActions.DELETE_INGREDIENT:
        return {
          ...state,
          ingredients: state.ingredients.filter((ig, igIndex) => {
            return igIndex !== action.payload;    // if return true means that this elements stays in array
          })
        };
      case ShopingListActions.START_EDIT:
        return {}

      case ShopingListActions.STOP_EDIT:
        return{}

    default:
      return state;
  }
}
