USE books_db;

DROP FUNCTION IF EXISTS get_average_rating;
DELIMITER //
CREATE FUNCTION get_average_rating()
RETURNS FLOAT
DETERMINISTIC
BEGIN
	return(SELECT AVG(rate) FROM user_table);
END;
SELECT * FROM user_table WHERE rate < get_average_rating()//
DELIMITER ;