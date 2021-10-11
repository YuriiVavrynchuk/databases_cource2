USE labor_sql;

/* 1. Знайти всі кораблі, що були спущені на воду в термін
між 1920 та 1942 роками. Вивести: name, launched. Вихідні дані впо-
рядкувати за спаданням за стовпцем launched.
*/
SELECT name FROM ships
WHERE launched > 1920 AND launched < 1942
ORDER BY launched DESC;

/* 2. З таблиці Trip вивести інформацію про рейси, що
вилітають в інтервалі часу між 12 та 17 годинами включно.
*/
SELECT * FROM trip
WHERE CAST(time_out AS TIME) > '12:00:00' and CAST(time_out AS TIME) < '17:00:00';

/* 3. Знайдіть пари моделей ноутбуків, що мають
однакові об’єми жорстких дисків та RAM (таблиця Laptop). У
результаті кожна пара виводиться лише один раз. Порядок виведення:
модель із більшим номером, модель із меншим номером, об’єм диску
та RAM.
*/
SELECT lap1.code, lap2.code, lap1.model, lap2.model, lap1.hd, lap2.hd, lap1.ram, lap2.ram
FROM labor_sql.laptop lap1
INNER JOIN labor_sql.laptop lap2
ON lap1.ram = lap2.ram AND lap1.hd = lap2.hd AND lap1.code < lap2.code 
WHERE lap1.code <> lap2.code;

/*4. БД «Кораблі». Вивести класи всіх кораблів США ('USA'). Якщо в БД
немає класів кораблів США, тоді вивести класи для всіх наявних у БД
країн. Вивести: country, class.
*/
SELECT distinct ships.class, classes.country 
FROM ships INNER JOIN classes
ON ships.class = classes.class
WHERE country = 'USA';

/*5. БД «Комп. фірма». Знайти тих виробників ПК, усі моделі ПК яких є
в наявності в таблиці PC (використовуючи операцію EXISTS). Вивести
maker.
*/
SELECT distinct maker FROM product
WHERE EXISTS
(SELECT model FROM pc
WHERE model = product.model)
ORDER BY maker ASC;

/*6. БД «Комп. фірма». Виведіть середню ціну ноутбуків із попереднім
текстом 'середня ціна = '.
*/
SELECT AVG(price) 'середня ціна =' 
FROM pc;

/*7. БД «Комп. фірма». Знайдіть кількість ПК та середню ціну для кож-
ної моделі при умові, що середня ціна є меншою 800 дол.
*/
SELECT model, AVG(price)
FROM labor_sql.pc
GROUP BY model
HAVING AVG(price) < 800;

/*8. БД «Комп. фірма». Знайдіть виробників, які б випускали ПК із міні-
мальною швидкістю не менше 500 МГц. Вивести: maker, мінімальна
швидкість. (Підказка: використовувати підзапити в якості обчис-
лювальних стовпців)
*/
SELECT product.maker, MIN(speed)
FROM pc INNER JOIN product
ON pc.model = product.model
GROUP BY maker
HAVING MIN(speed) <= 500;

/*9. БД «Комп. фірма». Для таблиці Product отримати підсумковий набір
у вигляді таблиці зі стовпцями maker, laptop, у якій для кожного ви-
робника необхідно вказати, чи виробляє він ('yes'), чи ні ('no')
відповідний тип продукції. У першому випадку ('yes') додатково
вказати поруч у круглих дужках загальну кількість наявної (тобто, що
знаходиться в таблиці Laptop) продукції, наприклад, 'yes(2)'. (Підказка:
використовувати підзапити в якості обчислювальних стовпців та
оператор CASE)
*/
SELECT maker,
CASE
	WHEN count(*) = 0 THEN 'No'
	WHEN count(*) > 0 THEN CONCAT('Yes(', count(type), ')')

END AS laptop
FROM labor_sql.product
WHERE type = 'laptop'
GROUP BY maker;

/*10. БД «Комп. фірма». Знайдіть номери моделей та ціни всіх
продуктів (будь-якого типу), що випущені виробником 'B'. Вивести:
maker, model, type, price. (Підказка: використовувати оператор UNION)
*/
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
ORDER BY maker ASC;