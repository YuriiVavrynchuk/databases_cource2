USE books_db;
DROP PROCEDURE IF EXISTS books_generation;

DELIMITER //
CREATE PROCEDURE `books_generation`()
BEGIN
	DECLARE i INT DEFAULT 1;
	inserting_loop : LOOP
		IF i <= 10 THEN
			INSERT INTO book_table (`title`, `author`, `UDK`, `rate`) VALUES (CONCAT("Noname", i), "Vavruk", "Milicioner", 10);
            SET i = i + 1;
            ITERATE inserting_loop;
		ELSE LEAVE inserting_loop;
        END IF;
	END LOOP inserting_loop;
END //
DELIMITER ;