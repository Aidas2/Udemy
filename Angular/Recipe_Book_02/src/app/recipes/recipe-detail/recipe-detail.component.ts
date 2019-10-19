import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

import { Recipe } from '../recipe.model';
import { RecipeService } from '../recipe-service';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {

  // @Input() recipe: Recipe; //used before routes
  recipe: Recipe;
  id: number;

  constructor(private recipeService: RecipeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    // const id = this.route.snapshot.params['id']; // not good aproach (works once and do not updates)
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = +params['id'];
          this.recipe = this.recipeService.getRecipeById(this.id)
        }
      );
      // in some case you need .unsubscribe();
  }

  onAddToShoppingList() {
    this.recipeService.addIngredientsToShoppingList(this.recipe.ingredients);
  }

  onEditRecipe() {
    this.router.navigate(['edit'], {relativeTo: this.route});              // not to complex
    // this.router.navigate(['../', this.id, 'edit'], {relativeTo: this.route}); // to complex
  }


  onDeleteRecipe() {
    this.recipeService.deleteRecipe(this.id);
    this.router.navigate(['/recipes'], {relativeTo: this.route});
  }

}
