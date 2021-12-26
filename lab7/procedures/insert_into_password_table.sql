DROP PROCEDURE IF EXISTS insert_into_passwod_table;

DELIMITER //
CREATE PROCEDURE `insert_into_passwod_table` (
	IN user_password VARCHAR(20)
)
BEGIN
	INSERT INTO password_table (`user_password`) VALUES
		(user_password);
END //
DELIMITER ;