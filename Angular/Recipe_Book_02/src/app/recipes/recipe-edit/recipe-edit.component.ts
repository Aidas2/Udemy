import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { RecipeService } from '../recipe-service';
import { Recipe } from '../recipe.model';

@Component({
  selector: 'app-recipe-edit',
  templateUrl: './recipe-edit.component.html',
  styleUrls: ['./recipe-edit.component.css']
})
export class RecipeEditComponent implements OnInit {
  id: number;
  editMode = false;
  recipeForm: FormGroup;

  constructor(private route: ActivatedRoute, private recipeService: RecipeService,
    private router: Router) { }

  ngOnInit() {
    this.route.params
    .subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.editMode = params['id'] != null; // if  id presents return true(edit mode), if undefined returns false (new mode)
        // console.log(this.editMode);
        this.initForm();
      }
    );
      // in some cases(e.g. using own Observables) you need .unsubscribe();
  }

  onSubmit() {
    // console.log(this.recipeForm);

    // const newRecipe = new Recipe(    // all this can be replaced with this.recipeForm.value
    //   this.recipeForm.value['name'],
    //   this.recipeForm.value['description'],
    //   this.recipeForm.value['imagePath'],
    //   this.recipeForm.value['ingredients'],)
    if(this.editMode) {
    this.recipeService.updateRecipe(this.id, /*newRecipe*/ this.recipeForm.value);
    } else {
      this.recipeService.addRecipe(/*newRecipe*/ this.recipeForm.value);
    }

    this.onCancel();

  }

  onAddIngredient() {
    (<FormArray>this.recipeForm.get('ingredients')).push(
      new FormGroup({
        'name': new FormControl(null, Validators.required),
        'amount': new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]+[0-9]*$/)])
      })
    );

  }

  onDeleteIngredient(index: number) {
    (<FormArray>this.recipeForm.get('ingredients')).removeAt(index);
    // from Angular 8, to remove all items in array:
    // (<FormArray>this.recipeForm.get('ingredients')).clear();
  }

  onCancel() {
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  private initForm() {
    let recipeName = '';
    let recipeImagePath = '';
    let recipeDescription = '';
    let recipeIngredients = new FormArray([]);

    if (this.editMode) {
      const recipe = this.recipeService.getRecipeById(this.id);
      recipeName = recipe.name;
      recipeImagePath = recipe.imagePath;
      recipeDescription = recipe.description;
      if(recipe['ingredients']) {  // if recipe has ingredients (?!)
        for (let ingredient of recipe.ingredients) {
          recipeIngredients.push(
            new FormGroup({
              'name': new FormControl(ingredient.name, Validators.required),
              'amount': new FormControl(ingredient.amount,
                 [Validators.required, Validators.pattern(/^[1-9]+[0-9]*$/)])
            })
          );
        }
      }
    }

    this.recipeForm = new FormGroup({
      'name': new FormControl(recipeName, Validators.required),    // 'name' should match in html (formControlName="name")
      'imagePath': new FormControl(recipeImagePath, Validators.required),
      'description': new FormControl(recipeDescription, Validators.required),
      'ingredients': recipeIngredients  // should match in html (formArrayName="ingredients", also in *ngFor)
    });
  }

  getControls() {
    return (<FormArray>this.recipeForm.get('ingredients')).controls;
  }
}
