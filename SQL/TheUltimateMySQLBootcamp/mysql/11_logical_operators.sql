# mysql-ctl cli; exit;
# show databases;
# select database();
# USE book_shop;

SELECT title FROM books WHERE released_year != 2017;
SELECT title, author_lname FROM books WHERE author_lname != 'Harris';

SELECT title FROM books WHERE title LIKE 'W%';
SELECT title FROM books WHERE title NOT LIKE 'W%';

SELECT title, released_year FROM books WHERE released_year >= 2000 ORDER BY released_year;
SELECT title, stock_quantity FROM books WHERE stock_quantity >= 100;
SELECT 'a' > 'b';
-- false 0
SELECT 'A' > 'a';
-- false 0
SELECT 'A' >=  'a';
-- true 1
SELECT title, author_lname FROM books WHERE author_lname = 'Eggers';
SELECT title, author_lname FROM books WHERE author_lname = 'eggers';
SELECT title, author_lname FROM books WHERE author_lname = 'eGGers';

SELECT title, author_lname, released_year FROM books
WHERE author_lname='Eggers';
 
SELECT title, author_lname, released_year FROM books
WHERE author_lname='Eggers' AND released_year > 2010;
SELECT * FROM books WHERE author_lname='Eggers' 
    AND released_year > 2010 
    AND title LIKE '%novel%';
    
SELECT title, author_lname,  released_year, stock_quantity FROM   books 
WHERE  author_lname = 'Eggers' 
    OR released_year > 2010 
    OR stock_quantity > 100;
    
SELECT title, released_year FROM books WHERE released_year BETWEEN 2004 AND 2015;
SELECT title, released_year FROM books WHERE released_year NOT BETWEEN 2004 AND 2015;
SELECT CAST('2020-06-07' AS DATETIME);
use new_testing_db;
SELECT name, birthdt FROM people WHERE birthdt BETWEEN '1980-01-01' AND '2000-01-01';
SELECT name, birthdt FROM people WHERE 
    birthdt BETWEEN CAST('1980-01-01' AS DATETIME)
    AND CAST('2000-01-01' AS DATETIME);
 
use book_shop;
SELECT title, author_lname FROM books WHERE author_lname IN ('Carver', 'Lahiri', 'Smith');
SELECT title, released_year FROM books WHERE released_year IN (2017, 1985);
SELECT title, released_year FROM books WHERE released_year NOT IN (2000,2002,2004,2006,2008,2010,2012,2014,2016);
SELECT title, released_year FROM books WHERE released_year >= 2000 AND released_year NOT IN 
(2000,2002,2004,2006,2008,2010,2012,2014,2016);
SELECT title, released_year FROM books WHERE released_year >= 2000 AND released_year % 2 != 0;
SELECT title, released_year FROM books WHERE released_year >= 2000 AND released_year % 2 != 0 ORDER BY released_year;

SELECT title, released_year,
       CASE 
         WHEN released_year >= 2000 THEN 'Modern Lit'
         ELSE '20th Century Lit'
       END AS GENRE
FROM books;

SELECT title, stock_quantity,
    CASE 
        WHEN stock_quantity BETWEEN 0 AND 50 THEN '*'
        WHEN stock_quantity BETWEEN 51 AND 100 THEN '**'
        ELSE '***'
    END AS STOCK
FROM books;

SELECT title, stock_quantity,
    CASE 
        WHEN stock_quantity <= 50 THEN '*'
        WHEN stock_quantity <= 100 THEN '**'
        ELSE '***'
    END AS STOCK
FROM books;

# Logical Operators Challenges Solution
SELECT title, released_year FROM books WHERE released_year < 1980;
SELECT title, author_lname FROM books WHERE author_lname='Eggers' OR author_lname='Chabon';
SELECT title, author_lname FROM books WHERE author_lname IN ('Eggers','Chabon');
SELECT title, author_lname, released_year FROM books WHERE author_lname = 'Lahiri' && released_year > 2000;
SELECT title, pages FROM books WHERE pages >= 100 && pages <=200;
SELECT title, pages FROM books WHERE pages BETWEEN 100 AND 200;
SELECT title, author_lname FROM books WHERE author_lname LIKE 'C%' OR author_lname LIKE 'S%';
SELECT title, author_lname FROM books WHERE SUBSTR(author_lname,1,1) = 'C' OR SUBSTR(author_lname,1,1) = 'S';
SELECT title, author_lname FROM books WHERE SUBSTR(author_lname,1,1) IN ('C', 'S');
 
SELECT 
    title, 
    author_lname,
    CASE
        WHEN title LIKE '%stories%' THEN 'Short Stories'
        WHEN title = 'Just Kids' OR title = 'A Heartbreaking Work of Staggering Genius' THEN 'Memoir'
        ELSE 'Novel'
    END AS TYPE
FROM books;
 
SELECT author_fname, author_lname,
    CASE 
        WHEN COUNT(*) = 1 THEN '1 book'
        ELSE CONCAT(COUNT(*), ' books')
    END AS COUNT
FROM books 
GROUP BY author_lname, author_fname;   

# source 11_logocal_operators.sql;