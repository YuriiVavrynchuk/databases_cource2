SELECT lap1.code, lap2.code, lap1.model, lap2.model, lap1.hd, lap2.hd, lap1.ram, lap2.ram
FROM labor_sql.laptop lap1
INNER JOIN labor_sql.laptop lap2
ON lap1.ram = lap2.ram AND lap1.hd = lap2.hd AND lap1.code < lap2.code 
WHERE lap1.code <> lap2.code