SELECT product.maker, MIN(speed)
FROM pc INNER JOIN product
ON pc.model = product.model
GROUP BY maker
HAVING MIN(speed) <= 500;