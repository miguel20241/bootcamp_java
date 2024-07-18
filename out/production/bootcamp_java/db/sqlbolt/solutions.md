# Practicas de MySQL

Solución a los ejercicios de [https://sqlbolt.com](https://sqlbolt.com/)

# Lesson 1: SELECT queries 101
## Exercise 1 - Tasks
1. Find the title of each film.
~~~sql 
SELECT title FROM movies;
~~~
2. Find the director of each film
~~~sql
SELECT director FROM movies;
~~~
3. Find the title and director of each film.
~~~sql
SELECT title, director FROM movies;
~~~
4. Find the title and year of each film.
~~~sql
SELECT title, year FROM movies;
~~~
5. Find all the information about each film.
~~~sql
SELECT * FROM movies;
~~~

# Lesson 2: Queries with constraints (Pt. 1)
## Exercise 2 - Tasks
1. Find the movie with a row id of 6.
~~~sql
SELECT * FROM movies 
WHERE id = 6;
~~~
2. Find the movies released in the years between 2000 and 2010.
~~~sql
SELECT * FROM movies 
WHERE year >= 2000 AND year <= 2010;
~~~
3. Find the movies not released in the years between 2000 and 2010.
~~~sql
SELECT * FROM movies 
WHERE year NOT BETWEEN 2000 AND 2010;
~~~
4. Find the first 5 Pixar movies and their release year
~~~sql
SELECT * FROM movies LIMIT 5;
~~~
# Lesson 3: Queries with constraints (Pt. 2)
## Exercise 3 - Tasks
1. Find all the Toy Story movies
~~~sql
SELECT * FROM movies 
WHERE title LIKE "%Toy%";
~~~
2. Find all the movies directed by John Lasseter.
~~~sql
SELECT * FROM movies 
WHERE director = "John Lasseter";
~~~
3. Find all the movies (and director) not directed by John Lasseter
~~~sql
SELECT title, director FROM movies 
WHERE director <> "John Lasseter";
~~~
4. Find all the WALL-* movies
~~~sql
SELECT * FROM movies 
WHERE title LIKE "%wall%";
~~~
# Lesson 4: Filtering and sorting Query results
## Exercise 4 - Tasks
1. List all directors of Pixar movies (alphabetically), without duplicates
~~~sql
SELECT * FROM movies GROUP BY director ORDER ASC;
~~~
2. List the last four Pixar movies released (ordered from most recent to least)
~~~sql
SELECT * FROM movies ORDER BY year DESC LIMIT 4;
~~~
3. List the first five Pixar movies sorted alphabetically
~~~sql
SELECT * FROM movies ORDER BY title ASC LIMIT 5;
~~~
4. List the next five Pixar movies sorted alphabetically
~~~sql
SELECT * FROM movies ORDER BY title ASC LIMIT 5 OFFSET 5;
~~~

# Review: Simple SELECT Queries
## Review 1 - Tasks
1. List all the Canadian cities and their populations
~~~sql
SELECT * FROM north_american_cities 
WHERE country = 'Canada';
~~~
2. Order all the cities in the United States by their latitude from north to south
~~~sql
SELECT * FROM north_american_cities 
WHERE country = 'United States' ORDER BY latitude DESC;
~~~
3. List all the cities west of Chicago, ordered from west to east
~~~sql
SELECT city, longitude FROM north_american_cities
WHERE longitude < -87.629798
ORDER BY longitude ASC;
~~~
4. List the two largest cities in Mexico (by population)
~~~sql
SELECT * FROM north_american_cities
WHERE country = 'Mexico'
ORDER BY population DESC LIMIT 2;
~~~
5. List the third and fourth largest cities (by population) in the United States and their population
~~~sql
SELECT * FROM north_american_cities 
WHERE country = "United States" 
ORDER BY population DESC LIMIT 2 OFFSET 2;
~~~
# Lesson 6: Multi-table queries with JOINs
## Exercise 6 - Tasks
1. Find the domestic and international sales for each movie
~~~sql
SELECT * FROM movies m
LEFT JOIN boxoffice b ON m.id = b.movie_id;
~~~
2. Show the sales numbers for each movie that did better internationally rather than domestically
~~~sql
SELECT * FROM movies m
LEFT JOIN boxoffice b ON m.id = b.movie_id
WHERE b.domestic_sales < b.international_sales;
~~~
3. List all the movies by their ratings in descending order
~~~sql
SELECT m.title, b.rating
FROM movies m JOIN boxoffice b ON m.id = b.movie_id
ORDER BY b.rating DESC;
~~~

# Lesson 7: OUTER JOINs
## Exercise 7 - Tasks
1. Find the list of all buildings that have employees
~~~sql
SELECT building FROM employees 
GROUP BY building;
~~~
2. Find the list of all buildings and their capacity
~~~sql
SELECT * FROM buildings;
~~~
3. List all buildings and the distinct employee roles in each building (including empty buildings)
~~~sql
SELECT * FROM buildings b 
LEFT JOIN employees e ON b.building_name = e.building
GROUP BY b.building_name, e.role;
~~~

# Lesson 8: A short note on NULLs
## Exercise 8 - Tasks
1. Find the name and role of all employees who have not been assigned to a building
~~~sql
SELECT * FROM employees 
WHERE building IS NULL;
~~~
2. Find the names of the buildings that hold no employees
~~~sql
SELECT * FROM buildings b 
LEFT JOIN employees e  ON e.building = b.building_name
WHERE e.building IS NULL;
~~~

# Lesson 9: Queries with expressions
## Exercise 9 - Tasks
1. List all movies and their combined sales in millions of dollars
~~~sql
SELECT m.title, (b.domestic_sales + b.international_sales)/1000000 AS sum 
FROM movies m 
LEFT JOIN boxoffice b ON m.id = b.movie_id;
~~~
2. List all movies and their ratings in percent
~~~sql
SELECT m.title, b.rating * 10 AS rating_percent
FROM movies m
JOIN boxoffice b ON m.id = b.movie_id;
~~~
3. List all movies that were released on even number years
~~~sql
SELECT m.title, m.year
FROM movies m
WHERE m.year % 2 = 0;
~~~

# Lesson 10: Queries with aggregates (Pt. 1)
## Exercise 10 - Tasks
1. Find the longest time that an employee has been at the studio
~~~sql
SELECT MAX(years_employed) FROM employees;
~~~
2. For each role, find the average number of years employed by employees in that role
~~~sql
SELECT AVG(e.years_employed), e.role 
FROM employees e
GROUP BY e.role
~~~
3. Find the total number of employee years worked in each building
~~~sql
SELECT TOTAL(e.years_employed), e.building FROM employees e GROUP BY e.building;
~~~

# Lesson 11: Queries with aggregates (Pt. 2)
## Exercise 11 - Tasks
1. Find the number of Artists in the studio (without a HAVING clause)
~~~sql
SELECT COUNT(name) 
FROM employees 
WHERE role = "Artist";
~~~
2. Find the number of Employees of each role in the studio
~~~sql
SELECT COUNT(e.name), e.role 
FROM employees e 
GROUP BY e.role;
~~~
3. Find the total number of years employed by all Engineers
~~~sql
SELECT TOTAL(e.years_employed), e.role 
FROM employees e 
WHERE e.role = "Engineer";
~~~

# Lesson 12: Order of execution of a Query
## Exercise 12 - Tasks
1. Find the number of movies each director has directed
~~~sql
SELECT COUNT(title), director 
FROM movies 
GROUP BY director;
~~~
2. Find the total domestic and international sales that can be attributed to each director
~~~sql
SELECT m.director, SUM(b.domestic_sales + b.international_sales) as Total
FROM movies m
INNER JOIN boxoffice b ON m.id = b.movie_id
GROUP BY m.director;
~~~

# Lesson 13: Inserting rows
## Exercise 13 - Tasks
1. Add the studio's new production, Toy Story 4 to the list of movies (you can use any director)
~~~sql
INSERT INTO movies (title, director, year, length_minutes)
VALUES ("Toy Story 4", "John Lasseter",	2024, 90);
~~~
2. Toy Story 4 has been released to critical acclaim! It had a rating of 8.7, and made 340 million domestically and 270 million internationally. Add the record to the BoxOffice table.
~~~sql
INSERT INTO boxoffice (movie_id, rating, domestic_sales, international_sales)
VALUES (16, 8.7, 340000000, 270000000);
~~~

# Lesson 14: Updating rows
## Exercise 14 - Tasks
1. The director for A Bug's Life is incorrect, it was actually directed by John Lasseter
~~~sql
UPDATE movies 
SET director = "John Lasseter" 
WHERE title = "A Bug's Life";
~~~
2. The year that Toy Story 2 was released is incorrect, it was actually released in 1999
~~~sql
UPDATE movies 
SET year = 1999
WHERE title = "Toy Story 2";
~~~
3. Both the title and director for Toy Story 8 is incorrect! The title should be "Toy Story 3" and it was directed by Lee Unkrich 
~~~sql
UPDATE movies 
SET title = "Toy Story 3", director = "Lee Unkrich"
WHERE title = "Toy Story 8";
~~~

# Lesson 15: Deleting rows
## Exercise 15 - Tasks
1. This database is getting too big, lets remove all movies that were released before 2005.
~~~sql
DELETE FROM movies
WHERE year < 2005;
~~~
2. Andrew Stanton has also left the studio, so please remove all movies directed by him.
~~~sql
DELETE FROM movies
WHERE director = "Andrew Stanton";
~~~


# Lesson 16: Creating tables
## Exercise 16 - Tasks
1. Create a new table named Database with the following columns: \
– Name A string (text) describing the name of the database \
– Version A number (floating point) of the latest version of this database \
– Download_count An integer count of the number of times this database was downloaded \
This table has no constraints.
~~~sql
CREATE TABLE IF NOT EXISTS database (
    name VARCHAR,
    version FLOAT,
    download_count INT
);
~~~

# Lesson 17: Altering tables
## Exercise 17 - Tasks
1. Add a column named Aspect_ratio with a FLOAT data type to store the aspect-ratio each movie was released in.
~~~sql
ALTER TABLE Movies
ADD Aspect_ratio FLOAT;
~~~
2. Add another column named Language with a TEXT data type to store the language that the movie was released in. Ensure that the default for this language is English.
~~~sql
ALTER TABLE Movies
ADD Language VARCHAR DEFAULT "English";
~~~

# Lesson 18: Dropping tables
## Exercise 18 - Tasks
1. We've sadly reached the end of our lessons, lets clean up by removing the Movies table
~~~sql
DROP TABLE Movies;
~~~
2. And drop the BoxOffice table as well
~~~sql
DROP TABLE BoxOffice;
~~~