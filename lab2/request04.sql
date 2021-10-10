SELECT distinct ships.class, classes.country 
FROM ships INNER JOIN classes
ON ships.class = classes.class
WHERE country = 'USA';