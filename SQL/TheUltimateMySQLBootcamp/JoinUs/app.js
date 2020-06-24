// cd JoinUs
// npm init
// npm install express --save
// npm install faker mysql -- save
// npm install --save ejs
// npm install --save body-parser
// PROJECT --> Running Url and Port --> https://mysql-pxqlc.run-eu-central1.goorm.io/
// Run in different terminals: node app.js and mysql-ctl cli; USE 16_join_us; 

var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');
var app = express();

app.set("view engine", "ejs");
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(__dirname + "/public"));

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',     // your root username
  database : '16_join_us'   // the name of your db
});
 
// app.get("/", function(req, res){
//  res.send("HELLO FROM OUR WEB APP!");
// });

app.get("/joke", function(req, res){
 var joke = "What do you call a dog that does magic tricks? A labracadabrador.";
 res.send(joke);
});

app.get("/random_num", function(req, res){
 var num = Math.floor((Math.random() * 10) + 1);
 res.send("Your lucky number is " + num);
});
 
// app.get("/", function(req, res){
//  var q = 'SELECT COUNT(*) as count FROM users';
//  connection.query(q, function (error, results) {
//  if (error) throw error;
//  var msg = "We have " + results[0].count + " users";
//  res.send(msg);
//  });
// });

app.get("/", function(req, res){
 var q = 'SELECT COUNT(*) as count FROM users';
 connection.query(q, function (error, results) {
 if (error) throw error;
	var count = results[0].count
	 res.render("home", {data: count});
 });
});

app.post('/register', function(req,res){
 var person = {email: req.body.email};
 connection.query('INSERT INTO users SET ?', person, function(err, result) {
 console.log(err);
 console.log(result);
 res.redirect("/");
 });
});



app.listen(3000, function () {
 console.log('App listening on port 3000!');
});