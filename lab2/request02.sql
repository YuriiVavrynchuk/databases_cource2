SELECT * FROM labor_sql.trip
WHERE CAST(time_out AS TIME) > '12:00:00' and CAST(time_out AS TIME) < '17:00:00';