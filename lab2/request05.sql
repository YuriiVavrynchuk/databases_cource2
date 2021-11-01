SELECT distinct maker FROM product
WHERE EXISTS
(SELECT model FROM pc
WHERE model = product.model)
ORDER BY maker ASC;