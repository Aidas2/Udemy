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

/*
import axios from 'axios';

async function getResults(query) {
    const proxy = 'https://cors-anywhere.herokuapp.com/';
    const key = '9cf1ece1da7608ad4a540b6a0ccf358b';
    try{
        const res = await axios(`${proxy}https://www.food2fork.com/api/search?${key}&q=${query}`); //bad url ?
        //http://food2fork.com/api/search?key='9cf1ece1da7608ad4a540b6a0ccf358b'&q='pizza'
        //const res = await axios(`${proxy}http://food2fork.com/api/search?key=${key}&q=${query}`);
        console.log(res);

        const recipes = res.data.recipes;
        console.log(recipes);
    } catch (error) {
        alert(error);
    }

}
getResults('pizza');
*/

/*
import axios from 'axios';

async function getResult(query){
    const key = '9cf1ece1da7608ad4a540b6a0ccf358b'
    try{
        const res = await axios(`https://www.food2fork.com/api/search?key=${key}&q=${query}`)
        console.log(res);
        console.log('====================================================')
        const recipes = res.data.recipes;
        console.log(recipes);

    } catch(error) {
        alert(error)
    }

}

getResult('tomato');
*/

import Search from './models/Search';
import * as searchView from './views/searchView'
import { elements } from './views/base';

/** Global state of app 
 * - Search object
 * - Current recipe object
 * - Shopping list object
 * - Liked recipies
*/
const state = {};

const controlSearch = async () => {
    // 1. Get query from view
    const query = searchView.getInput();
    console.log(query);

    if (query) {
        // 2) New search object and add to state
        state.search = new Search(query);

        // 3) prepare UI for results
        searchView.clearInput();
        searchView.clearResults();

        // 4) Search for recipes
        await state.search.getResult();

        //5) render results on UI
        searchView.renderResults(state.search.result);
    }

}

elements.searchForm.addEventListener('submit', e => {
    e.preventDefault();
    controlSearch();
})

// const search = new Search('pizza');
// console.log(search);
