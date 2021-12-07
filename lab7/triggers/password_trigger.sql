DROP TRIGGER IF EXISTS password_trigger;
DELIMITER //
CREATE TRIGGER password_trigger
    AFTER INSERT
    ON `password_table`
    FOR EACH ROW
BEGIN
    if (SELECT COUNT(*) FROM password_table) > 5 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Wrong password amount';
    END IF;
END //
DELIMITER ;