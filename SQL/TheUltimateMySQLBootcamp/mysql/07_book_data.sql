# mysql-ctl cli; exit;
# show databases;
# select database();
# USE book_shop; 
SELECT
  CONCAT(author_fname, ' ', author_lname)
  AS 'full name'
FROM books;
 
SELECT author_fname AS first, author_lname AS last, 
  CONCAT(author_fname, ' ', author_lname) AS full
FROM books;

SELECT CONCAT(title, ' - ', author_fname, ' - ', author_lname) FROM books;
 
SELECT 
    CONCAT_WS(' - ', title, author_fname, author_lname) 
FROM books;

SELECT CONCAT
    (
        SUBSTRING(title, 1, 10),
        '...'
    ) AS 'short title'
FROM books;

SELECT
   CONCAT
   (
       SUBSTRING(title, 1, 10),
       '...'
   ) AS 'short title'
FROM books;

SELECT CONCAT(author_fname, REVERSE(author_fname)) FROM books;

SELECT author_lname, CHAR_LENGTH(author_lname) AS 'length' FROM books;
 
SELECT CONCAT(author_lname, ' is ', CHAR_LENGTH(author_lname), ' characters long') FROM books;

SELECT CONCAT('MY FAVORITE BOOK IS ', UPPER(title)) FROM books;
 
SELECT CONCAT('MY FAVORITE BOOK IS ', LOWER(title)) FROM books;

# String Function Challenges Solution
SELECT 
   author_lname AS forwards,
   REVERSE(author_lname) AS backwards 
FROM books;

SELECT
   UPPER
   (
      CONCAT(author_fname, ' ', author_lname)
   ) AS 'full name in caps'
FROM books;

SELECT
   CONCAT(title, ' was released in ', released_year) AS blurb
FROM books;
SELECT
   title,
   CHAR_LENGTH(title) AS 'character count'
FROM books;

SELECT
   CONCAT(SUBSTRING(title, 1, 10), '...') AS 'short title',
   CONCAT(author_lname, ',', author_fname) AS author,
   CONCAT(stock_quantity, ' in stock') AS quantity
FROM books

# source 07_book_data.sql;