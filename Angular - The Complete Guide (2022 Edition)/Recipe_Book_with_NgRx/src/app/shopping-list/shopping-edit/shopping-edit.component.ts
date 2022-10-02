import { Component, OnInit, ElementRef, ViewChild, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { NgForm } from '@angular/forms';
import { Store } from '@ngrx/store';

import { Ingredient } from 'src/app/shared/ingredient.model';
// import { ShoppingListService } from '../shopping-list.service';
import * as ShoppingListActions from '../store/shopping-list.actions';
import * as fromShoppingList from '../store/shopping-list.reducer';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit, OnDestroy {

  // @ViewChild('nameInput'/*, { static: false }*/) nameInputRef: ElementRef;
  // @ViewChild('amountInput'/*, { static: false }*/) amountInputRef: ElementRef;

  // THIS IS A TEMPLATE-DRIVEN APPROACH!

  @ViewChild('f' /*, { static: false }*/) slForm: NgForm;    // enable access to form
  subscription: Subscription;
  editMode = false;
  // editedItemIndex: number;
  editedItem: Ingredient;

  constructor(
    // private shoppingListService: ShoppingListService,
    // private store: Store<{shoppingList: {ingredients: Ingredient[]}}>
    private store: Store<fromShoppingList.AppState>
    ) { }

  ngOnInit() {
    this.subscription =  this.store.select('shoppingList').subscribe(stateData => {
      if (stateData.editedIngredientIndex > -1) {
        this.editMode = true;
        this.editedItem = stateData.editedIngredient;
        this.slForm.setValue({
          name: this.editedItem.name,
          amount: this.editedItem.amount
        });
      } else {
        this.editMode = false;
      }
    });

    /* // before ngrx
    // listening to emitted index (shoping-list.component.ts) ir taking actions:
    this.subscription = this.shoppingListService.startedEditing.subscribe(
      (index: number) => {
        this.editedItemIndex = index;
        this.editMode = true;
        this.editedItem = this.shoppingListService.getIngredient(index);
        this.slForm.setValue({
          name: this.editedItem.name,
          amount: this.editedItem.amount
        });
      }
    );
    */
  }

  // before ngForm:
  // onAddItem() {
  //   const ingName = this.nameInputRef.nativeElement.value;
  //   const ingAmount = this.amountInputRef.nativeElement.value;
  //   const newIngredient = new Ingredient(ingName, ingAmount);
  //   this.shoppingListService.addIngredient(newIngredient);
  // }

  onSubmit(form: NgForm) {
    const value = form.value;
    const newIngredient = new Ingredient(value.name, value.amount);
    if (this.editMode) {
      // this.shoppingListService.updateIngredient(this.editedItemIndex, newIngredient);
      this.store.dispatch(
        new ShoppingListActions.UpdateIngredient(
        // {index: this.editedItemIndex, ingredient: newIngredient}
        newIngredient
        )
      );
    } else {
      // this.shoppingListService.addIngredient(newIngredient);
      this.store.dispatch(new ShoppingListActions.AddIngredient(newIngredient));
    }
    this.editMode = false;
    form.reset();
  }

  onClear() {
    this.slForm.reset();
    this.editMode = false;
    this.store.dispatch(new ShoppingListActions.StopEdit());
  }

  onDelete() {
    // this.shoppingListService.deleteIngredient(this.editedItemIndex);
    this.store.dispatch(new ShoppingListActions.DeleteIngredient(/*this.editedItemIndex*/));
    this.onClear();

  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
    this.store.dispatch(new ShoppingListActions.StopEdit());
  }
}
