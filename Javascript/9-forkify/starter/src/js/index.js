// Global app controller
/*
import num from './test';
const x = 23;
// console.log(`I imported ${num} from another module`)
console.log(`I imported ${num} from another module called test.js! Variable x is ${x}`);
*/

/*
import str from './models/Search';
// import { add, multiply, ID } from './views/searchView';
// import { add as a, multiply as m, ID } from './views/searchView';
import * as searchView from './views/searchView';

// console.log(`Using imported functions! ${add(ID, 2)} and ${multiply(3, 5)}. ${str}`);
//console.log(`Using imported functions! ${a(ID, 2)} and ${m(3, 5)}. ${str}`);
console.log(`Using imported functions! ${searchView.add(searchView.ID, 2)} and ${searchView.multiply(3, 5)}. ${str}`);
*/

import Search from './models/Search';
import Recipe from './models/Recipe';
import * as searchView from './views/searchView';
import * as recipeView from './views/recipeView';
import { elements, renderLoader, clearLoader } from './views/base';

/** Global state of app 
 * - Search object
 * - Current recipe object
 * - Shopping list object
 * - Liked recipies
*/
const state = {};

/** 
 * SEARCH CONTROLLER
*/
const controlSearch = async () => {
    // 1. Get query from view
    const query = searchView.getInput();
    //const query = 'pizza'; //FOR TESTING

    console.log(query);

    if (query) {
        // 2) New search object and add to state
        state.search = new Search(query);

        // 3) prepare UI for results
        searchView.clearInput();
        searchView.clearResults();
        renderLoader(elements.searchRes);

        try {
            // 4) Search for recipes
            await state.search.getResult();

            //5) render results on UI
            clearLoader();
            searchView.renderResults(state.search.result);
            // searchView.renderResults(state.search.result, 1); //the same
        } catch (err) {
            alert(`Message from method controlSearch(): Something wrong with the search ... ${err}`);
            clearLoader();
        }
    }

};

elements.searchForm.addEventListener('submit', e => {
    e.preventDefault();
    controlSearch();
});

// TESTING
// window.addEventListener('load', e => {
//     e.preventDefault();
//     controlSearch();
// });


// event delegation (adding event listener to parent ant delegating to target (child when he apears)) !!!
elements.searchResPages.addEventListener('click', e => {
    const btn = e.target.closest('.btn-inline');
    console.log(btn);
    if (btn) {
        const goToPage = parseInt(btn.dataset.goto, 10); //reading from atribute dataset (not from span) //10 means numbers from 0 to 10
        searchView.clearResults();
        searchView.renderResults(state.search.result, goToPage);
        console.log(goToPage);
    }
});

/**
 * RECIPE CONTROLLER
*/

const controlRecipe = async () => {
    // Get ID from url
    const id = window.location.hash.replace('#', '');
    console.log(id);

    if (id) {
        // Prepare UI for changes
        recipeView.clearRecipe();
        renderLoader(elements.recipe);

        // Highlight selected search item
        if(state.search) searchView.highlightSelected(id);


        // Create new recipe object
        state.recipe = new Recipe(id); 

        // TESTING
        //window.r = state.recipe; // hack to have access to object in console
                                // r.parseIngredients() now you can write in console

        try {
            // Get recipe data and parse ingredients
            await state.recipe.getRecipe();
            console.log(state.recipe.ingredients);
            state.recipe.parseIngredients();


            // Calculate servings and time
            state.recipe.calcTime();
            state.recipe.calcServings();

            //Render recipe
            //console.log(state.recipe);
            clearLoader();
            recipeView.renderRecipe(state.recipe);

        } catch (err) {
            alert(`Message from method controlRecipe(): Error processing recipe!: ${err}`);
        }
    }
}


// window.addEventListener('hashchange', controlRecipe);
// window.addEventListener('load', controlRecipe);
['hashchange', 'load'].forEach(event => window.addEventListener(event, controlRecipe));

