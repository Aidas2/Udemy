import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { Ingredient } from '../shared/ingredient.model';
import { ShoppingListService } from './shopping-list.service';
import { LoggingService } from '../logging.service';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent implements OnInit, OnDestroy {

  ingredients: Ingredient[];
  private subscription: Subscription;

  constructor(private slService: ShoppingListService, private loggingService: LoggingService) { }

  ngOnInit() {
    this.ingredients = this.slService.getIngredients();
    this.subscription = this.slService.ingredientsChanged
      .subscribe(
        (ingredients: Ingredient[]) => {
          this.ingredients = ingredients;
        }
      );
    // in some cases(e.g. using own Observables) you need .unsubscribe();

    this.loggingService.printLog('Hello from ShoppingListComponent ngOnInit!');
  }

  onEditItem(index: number) {
    // emitting this index (to be able to listen to it in some another place (shopping-edit.component.html)):
    this.slService.startedEditing.next(index);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }


}
