DROP TRIGGER IF EXISTS user_birth_place_trigger;
DELIMITER //
CREATE TRIGGER user_birth_place_trigger
    BEFORE INSERT
    ON user_table
    FOR EACH ROW
BEGIN
    if (new.birth_place not in ('Харків', 'Вінниця', 'Дніпропетровськ', 'Ужгород')) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Wrong birth place';
    END IF;
END //
DELIMITER ;