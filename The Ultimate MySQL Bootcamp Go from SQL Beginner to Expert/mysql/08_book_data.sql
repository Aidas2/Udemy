# mysql-ctl cli; exit;
# show databases;
# select database();
# USE book_shop; 
INSERT INTO books
    (title, author_fname, author_lname, released_year, stock_quantity, pages)
    VALUES ('10% Happier', 'Dan', 'Harris', 2014, 29, 256), 
           ('fake_book', 'Freida', 'Harris', 2001, 287, 428),
           ('Lincoln In The Bardo', 'George', 'Saunders', 2017, 1000, 367);

SELECT DISTINCT CONCAT(author_fname,' ', author_lname) FROM books;
SELECT DISTINCT author_fname, author_lname FROM books;

SELECT author_lname FROM books ORDER BY author_lname DESC;
SELECT title, released_year, pages FROM books ORDER BY released_year;
SELECT title, author_fname, author_lname FROM books ORDER BY 3;
SELECT author_fname, author_lname FROM books ORDER BY author_lname, author_fname;

SELECT title, released_year FROM books ORDER BY released_year DESC LIMIT 5;
SELECT title, released_year FROM books ORDER BY released_year DESC LIMIT 0,5;
SELECT title, released_year FROM books ORDER BY released_year DESC LIMIT 10,1;
SELECT * FROM tbl LIMIT 95,18446744073709551615;

SELECT title FROM books WHERE title LIKE '%the%';
SELECT title, stock_quantity FROM books WHERE stock_quantity LIKE '____';
SELECT title FROM books WHERE title LIKE '%\%%'
SELECT title FROM books WHERE title LIKE '%\_%'
# (235)234-0987 LIKE '(___)___-____'

# Refining Selections Challenges Solution
SELECT title FROM books WHERE title LIKE '%stories%';
 
SELECT title, pages FROM books ORDER BY pages DESC LIMIT 1;
 
SELECT 
    CONCAT(title, ' - ', released_year) AS summary 
FROM books ORDER BY released_year DESC LIMIT 3;
 
SELECT title, author_lname FROM books WHERE author_lname LIKE '% %';
 
SELECT title, released_year, stock_quantity 
FROM books ORDER BY stock_quantity LIMIT 3;
 
SELECT title, author_lname 
FROM books ORDER BY author_lname, title;
 
SELECT title, author_lname 
FROM books ORDER BY 2,1;
 
SELECT
    CONCAT(
        'MY FAVORITE AUTHOR IS ',
        UPPER(author_fname),
        ' ',
        UPPER(author_lname),
        '!'
    ) AS yell
FROM books ORDER BY author_lname;

# source 08_book_data.sql;