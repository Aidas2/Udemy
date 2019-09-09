// Global app controller
/*
import num from './test';
const x = 23;
// console.log(`I imported ${num} from another module`)
console.log(`I imported ${num} from another module called test.js! Variable x is ${x}`);
*/

import str from './models/Search';
// import { add as a, multiply as m, ID } from './views/searchView';
import * from './views/searchView';

console.log(`Using imported functions! ${a(ID, 2)} and ${m(3, 5)}. ${str}`);
