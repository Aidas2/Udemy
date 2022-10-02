// 282 ============================================================================
//Print "HELLO WORLD" 500 times using Node
// for(var i = 0; i < 500; i++){
//   console.log("HELLO WORLD!");
// }
// Execute file with: node filename.js 

// Find Faker Docs Here: https://github.com/marak/Faker.js/
// STEP 1: Install and Require Faker
// Install Faker via command line:
// npm install faker 

// Require it inside of a JS file:
var faker = require('faker'); 
var mysql = require('mysql');

// STEP 2: Use Faker!
// Print a random email
console.log(faker.internet.email()); 

// Print a random past date
console.log(faker.date.past()); 

// Print a random city
console.log(faker.address.city()); 

// We can define a new function
function generateAddress(){
  console.log(faker.address.streetAddress());
  console.log(faker.address.city());
  console.log(faker.address.state());
}

// And then execute that function:
generateAddress(); 

// 284 ============================================================================
// Step 1: Install the MySQL Node Package
// npm install mysql 

// Step 2: Connect to Database*
var mysql = require('mysql');
 
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',     // your root username
  database : '16_join_us'   // the name of your db
});

// Step 3: Run Queries
// Running a super simple SQL query like:
// SELECT 1 + 1; 
// Using the MySQL Node Package:
connection.query('SELECT 1 + 1 AS solution', function (error, results, fields) {
   if (error) throw error;
   console.log('The solution is: ', results[0].solution);
});

// Another sample query, this time selecting 3 things:
var q = 'SELECT CURTIME() as time, CURDATE() as date, NOW() as now';
connection.query(q, function (error, results, fields) {
  if (error) throw error;
  console.log(results[0].time);
  console.log(results[0].date);
  console.log(results[0].now);
});
// The equivalent SQL query:
// SELECT CURTIME() as time, CURDATE() as date, NOW() as now;

// 288 ============================================================================
// # To SELECT all users from database:
var q = 'SELECT * FROM users ';
connection.query(q, function (error, results, fields) {
  if (error) throw error;
  console.log(results);
});

// # To count the number of users in the database:
var q = 'SELECT COUNT(*) AS total FROM users ';
connection.query(q, function (error, results, fields) {
  if (error) throw error;
  console.log(results[0].total);
});

// 291 ============================================================================
// var q = 'INSERT INTO users (email) VALUES ("rusty_the_dog@gmail.com")';
// connection.query(q, function (error, results, fields) {
//   if (error) throw error;
//   console.log(results);
// });

var person = {
    email: faker.internet.email(),
    created_at: faker.date.past()
};
var end_result = connection.query('INSERT INTO users SET ?', person, function(err, result) {
  if (err) throw err;
  console.log(result);
});

// 291 ============================================================================
var data = [];
for(var i = 0; i < 500; i++){
    data.push([
        faker.internet.email(),
        faker.date.past()
    ]);
}
 
var q = 'INSERT INTO users (email, created_at) VALUES ?';
 
connection.query(q, [data], function(err, result) {
  console.log(err);
  console.log(result);
});
 
connection.end();