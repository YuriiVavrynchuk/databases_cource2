SELECT maker, product.model, product.type, price
FROM labor_sql.product
INNER JOIN labor_sql.printer
ON product.model = printer.model
UNION
SELECT maker, product.model, product.type, price
FROM labor_sql.product
INNER JOIN labor_sql.laptop
ON product.model = laptop.model
UNION
SELECT maker, product.model, product.type, price
FROM labor_sql.product
INNER JOIN labor_sql.pc
ON product.model = pc.model
ORDER BY maker ASC
;