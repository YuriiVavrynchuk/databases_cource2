USE books_db;

DROP FUNCTION IF EXISTS get_users_passwords;
DELIMITER //
CREATE FUNCTION get_users_passwords(
	id_to_find INT
)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	return(
		SELECT user_password FROM password_table
			WHERE id = (SELECT password_id FROM user_table WHERE password_id = id_to_find)
    );
END //
DELIMITER ;

SELECT login, get_users_passwords(id), name, surname, middle_name, birthday, birth_place, living_place, notes, rate FROM user_table;