SELECT maker,
CASE
	WHEN count(*) = 0 THEN 'No'
	WHEN count(*) > 0 THEN CONCAT('Yes(', count(type), ')')

END AS laptop
FROM labor_sql.product
WHERE type = 'laptop'
GROUP BY maker