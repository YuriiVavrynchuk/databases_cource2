DROP PROCEDURE IF EXISTS book_cursor_insert;

DELIMITER //
CREATE PROCEDURE book_cursor_insert()
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE title VARCHAR(45);
	DECLARE book_cursor CURSOR FOR SELECT book_table.title FROM book_table;
	DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE;
OPEN book_cursor;
book_loop: LOOP
   FETCH book_cursor INTO title;
   IF done = TRUE THEN LEAVE book_loop;
   END IF;
   SET @table_count = 1;
while_loop: WHILE @table_count < 6 DO
    SET @new_table = CONCAT('CREATE TABLE IF NOT EXISTS ', title, '(id INT, name VARCHAR(45));');
    SELECT @new_table;
    PREPARE myquery FROM @new_table;
    EXECUTE myquery;
    SET @table_count = @table_count + 1;
   END WHILE;
  END LOOP;
  CLOSE book_cursor;
END ;
//