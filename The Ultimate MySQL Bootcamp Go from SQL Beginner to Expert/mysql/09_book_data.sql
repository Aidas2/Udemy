# mysql-ctl cli; exit;
# show databases;
# select database();
# USE book_shop; 
SELECT COUNT(DISTINCT author_lname) FROM books;
SELECT COUNT(DISTINCT author_lname, author_fname) FROM books;
SELECT COUNT(*) FROM books WHERE title LIKE '%the%';

SELECT author_fname, author_lname, COUNT(*) FROM books GROUP BY author_lname, author_fname;
SELECT released_year, COUNT(*) FROM books GROUP BY released_year;
SELECT CONCAT('In ', released_year, ' ', COUNT(*), ' book(s) released') AS year FROM books GROUP BY released_year;

SELECT MIN(pages) FROM books;
SELECT MAX(pages) FROM books;
SELECT title, pages FROM books WHERE pages = (SELECT Max(pages) FROM books); 
SELECT title, pages FROM books WHERE pages = (SELECT Min(pages) FROM books); 
SELECT * FROM books ORDER BY pages ASC LIMIT 1;
SELECT title, pages FROM books ORDER BY pages DESC LIMIT 1;

SELECT author_fname, author_lname, Min(released_year) FROM books 
        GROUP  BY author_lname, author_fname;
SELECT author_fname, author_lname, Max(pages) FROM books
        GROUP BY author_lname,  author_fname;
SELECT CONCAT(author_fname, ' ', author_lname) AS author, MAX(pages) AS 'longest book' FROM books
        GROUP BY author_lname, author_fname;

SELECT SUM(pages) FROM books;
SELECT author_fname, author_lname, Sum(pages) FROM books
        GROUP BY author_lname, author_fname;

SELECT AVG(pages) FROM books;
SELECT released_year, AVG(stock_quantity) FROM books GROUP BY released_year;
SELECT author_fname, author_lname, AVG(pages) FROM books GROUP BY author_lname, author_fname;

# The Magic of Aggregate Functions Challenges Solution
SELECT COUNT(*) FROM books;
SELECT COUNT(*) FROM books GROUP BY released_year;
SELECT released_year, COUNT(*) FROM books GROUP BY released_year;
SELECT Sum(stock_quantity) FROM BOOKS;
SELECT author_fname, author_lname, AVG(released_year) FROM books GROUP BY author_lname, author_fname;
SELECT CONCAT(author_fname, ' ', author_lname) FROM books WHERE pages = (SELECT Max(pages) FROM books);
SELECT CONCAT(author_fname, ' ', author_lname) FROM books ORDER BY pages DESC LIMIT 1;
SELECT pages, CONCAT(author_fname, ' ', author_lname) FROM books ORDER BY pages DESC;
SELECT released_year AS year,
    COUNT(*) AS '# of books',
    AVG(pages) AS 'avg pages'
FROM books
    GROUP BY released_year;

# source 09_book_data.sql;