SELECT model, AVG(price)
FROM labor_sql.pc
GROUP BY model
HAVING AVG(price) < 800;