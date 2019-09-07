/////////////////////////////////
// CODING CHALLENGE

/*

Suppose that you're working in a small town administration, and you're in charge of two town elements:
1. Parks
2. Streets

It's a very small town, so right now there are only 3 parks and 4 streets. All parks and streets have a name and a build year.

At an end-of-year meeting, your boss wants a final report with the following:
1. Tree density of each park in the town (forumla: number of trees/park area)
2. Average age of each town's park (forumla: sum of all ages/number of parks)
3. The name of the park that has more than 1000 trees
4. Total and average length of the town's streets
5. Size classification of all streets: tiny/small/normal/big/huge. If the size is unknown, the default is normal

All the report data should be printed to the console.

HINT: Use some of the ES6 features: classes, subclasses, template strings, default parameters, maps, arrow functions, destructuring, etc.

*/

class Park {
    constructor(name, buildYear, area, numberOfTrees) {
        this.name = name;
        this.area = area;
        this.buildYear = buildYear;
        this.numberOfTrees = numberOfTrees;
    }

    calculateAge() {
        return new Date().getFullYear() - this.buildYear;
        //console.log(age);
    }

    calculateDensity() {
        return Math.round(this.numberOfTrees / this.area);
        //console.log(density);
    }
}

class Street {
    constructor(name, buildYear, lengthOfStreet, size = 'normal') {
        this.name = name;
        this.buildYear = buildYear;
        this.lengthOfStreet = lengthOfStreet;
        this.size = size;
    }
}

const greenPark = new Park('Green Park', 1987, 0.2, 215);
const nationalPark = new Park('National Park', 1894, 2.9, 3541);
const oakPark = new Park('Oak Park', 1953, 0.4, 949);

/*
greenPark.age = greenPark.calculateAge();
greenPark.density = greenPark.calculateDensity();

nationalPark.age = nationalPark.calculateAge();
nationalPark.density = nationalPark.calculateDensity();

oakPark.age = oakPark.calculateAge();
oakPark.density = oakPark.calculateDensity();
*/

const allParks = [greenPark, nationalPark, oakPark];

function reportAge (array) {
    let quantity = array.length;
    let ages = array.map(element => element.calculateAge());
    const arrSum = arr => arr.reduce((a,b) => a + b, 0);
    let sum = arrSum(ages);
    console.log('== amziai ' + ages);
    console.log('== suma ' + sum);
    let avgAge = sum / quantity;

    console.log(`Our ${quantity} parks have an average of ${avgAge} years.`);
}

function reportDensity (array) {
    array.forEach(element => {
        let density = element.calculateDensity();
        console.log(`${element.name} has a tree density of ${density} trees per square km.`);
    });
}

function reportAbove1000 (array) {
    let quantities = array.map(element => element.numberOfTrees);
    let index = quantities.findIndex(element => element >= 1000);

    //let index = array.map(element => element.numberOfTrees).findIndex(element => element >= 1000);
    console.log(`${array[index].name} has more than 1000 trees.`);
}



console.log(greenPark);
console.log(allParks);
reportAge(allParks);
reportDensity(allParks);
reportAbove1000(allParks);
