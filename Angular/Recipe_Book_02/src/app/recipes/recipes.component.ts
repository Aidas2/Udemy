import { Component, OnInit } from '@angular/core';
import { Recipe } from './recipe.model';
import { RecipeService } from './recipe-service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css'],
  providers: [RecipeService]
})
export class RecipesComponent implements OnInit {


  selectedRecipe: Recipe;

  constructor(private recipeService: RecipeService) { }

  ngOnInit() {
    this.recipeService.recipeSelected
      .subscribe( // subscribe() means listening to emitted event
        (recipe: Recipe) => {
          this.selectedRecipe = recipe;
        }
      );
      // in some cases(e.g. using own Observables) you need .unsubscribe();
  }

}
