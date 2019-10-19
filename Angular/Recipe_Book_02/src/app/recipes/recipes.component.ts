import { Component, OnInit } from '@angular/core';
import { Recipe } from './recipe.model';
import { RecipeService } from './recipe-service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css'],
  // providers: [RecipeService] // moved to app.module
})
export class RecipesComponent implements OnInit {

  // selectedRecipe: Recipe;  // do not need after routers

  constructor(/*private recipeService: RecipeService*/) { }

  ngOnInit() {
    // do not need after routers
    // this.recipeService.recipeSelected
    //   .subscribe( // subscribe() means listening to emitted event
    //     (recipe: Recipe) => {
    //       this.selectedRecipe = recipe;
    //     }
    //   );
      // in some cases(e.g. using own Observables) you need .unsubscribe();
  }

}
