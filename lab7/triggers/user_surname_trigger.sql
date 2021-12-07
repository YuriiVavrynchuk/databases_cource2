DROP TRIGGER IF EXISTS user_surname_trigger;
DELIMITER //
CREATE TRIGGER user_surname_trigger
    BEFORE INSERT
    ON user_table
    FOR EACH ROW
BEGIN
    if (LEFT(new.surname, 1) <> 'Ю') THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Wrong surname';
    END IF;
END //
DELIMITER ;