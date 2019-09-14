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
import List from './models/List';
import Likes from './models/Likes';
import * as searchView from './views/searchView';
import * as recipeView from './views/recipeView';
import * as listView from './views/listView';
import * as likesView from './views/likesView';
import { elements, renderLoader, clearLoader } from './views/base';

/** Global state of app 
 * - Search object
 * - Current recipe object
 * - Shopping list object
 * - Liked recipies
*/
const state = {};

// window.state = state; // hack to have state in console

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


// event delegation with closest (adding event listener to parent ant delegating to target (closest child when he apears)) !!!
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
            recipeView.renderRecipe(
                state.recipe,
                state.likes.isLiked(id) //renders apropriate heart after page is reloaded (doesn work without local storage)
                ); 

        } catch (err) {
            alert(`Message from method controlRecipe(): Error processing recipe!: ${err}`);
        }
    }
}

// window.addEventListener('hashchange', controlRecipe);
// window.addEventListener('load', controlRecipe);
['hashchange', 'load'].forEach(event => window.addEventListener(event, controlRecipe));

/**
 * LIST CONTROLLER
*/
const controlList = () => {
    // Create a new list IF there is none yet
    if(!state.list) state.list = new List();

    // Add each ingredient to the list and UI
    state.recipe.ingredients.forEach(el => {
        const item = state.list.addItem(el.count, el.unit, el.ingredient);
        listView.renderItem(item);
    });  
}

// Handle delete and update list item events
elements.shopping.addEventListener('click', e => {
    const id = e.target.closest('.shopping__item').dataset.itemid;

    // Handle the delete button
    if(e.target.matches('.shopping__delete, .shopping__delete *')) {
        state.list.deleteItem(id);

        // Delete from UI
        listView.deleteItem(id);

        // handle the count update
    } else if (e.target.matches('.shopping__count--value')) {
        const val = parseFloat(e.target.value, 10); // value of input field
        state.list.updateCount(id, val);
    }
});

/**
 * LIKE CONTROLLER
*/
// state.likes = new Likes(); // same hack :) (just for testing)

const controlLike = () => {
    if (!state.likes) state.likes = new Likes();
    const currentID = state.recipe.id;

    // User has NOT yet liked current recipe
    if (!state.likes.isLiked(currentID)) {
        // Add like to the state
        const newLike = state.likes.addLike(
            currentID,
            state.recipe.title,
            state.recipe.author,
            state.recipe.img
        );
        // Toggle the like button
        likesView.toggleLikeBtn(true);

        // Add like to UI list
        console.log(state.likes);
        likesView.renderLike(newLike);

    // User HAS liked current recipe
    } else {
        // Remove like from the state
        state.likes.deleteLike(currentID);

        // Toggle the like button
        likesView.toggleLikeBtn(false);

        // Remove like from UI list
        console.log(state.likes);        
        likesView.deleteLike(currentID);
    }
    likesView.toggleLikeMenu(state.likes.getNumLikes());
};

// Restore liked recipes on page load
window.addEventListener('load', () => {
    state.likes = new Likes();
    
    // Restore likes
    state.likes.readStorage();

    // Toggle like menu button
    likesView.toggleLikeMenu(state.likes.getNumLikes());

    // Render the existing likes
    state.likes.likes.forEach(like => likesView.renderLike(like));
});


// Handling recipe button clicks
// event delegation with matches !!!
elements.recipe.addEventListener('click', e => {
    if (e.target.matches('.btn-decrease, .btn-decrease *')) {        // * any child
        // decrease button is clicked
        if(state.recipe.servings > 1) {
            state.recipe.updateServings('dec');
            recipeView.updateServingsIngredients(state.recipe);
        }
    } else if (e.target.matches('.btn-increase, .btn-increase *')) {        // * any child
        // increase button is clicked
        state.recipe.updateServings('inc');
        recipeView.updateServingsIngredients(state.recipe);
    } else if (e.target.matches('.recipe__btn--ad, .recipe__btn--ad *')) {
        // Add ingredients to shooping list
        controlList();
    } else if (e.target.matches('.recipe__love, .recipe__love *')) {
        // Like controller
        controlLike();
    }


    console.log(state.recipe);

});

// window.l = new List(); // hack to have object directly in console :)

