USE books_db;

-- password

DROP TRIGGER IF EXISTS password_delete;

DELIMITER //
CREATE TRIGGER password_delete
BEFORE DELETE
ON password_table FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT password_id FROM user_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete password, some user still have fk to password";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS password_update;

DELIMITER //
CREATE TRIGGER password_update
BEFORE UPDATE
ON password_table FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT password_id FROM user_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update password, some user still have fk to password";
    END IF;
END //
DELIMITER ;

-- book_email

DROP TRIGGER IF EXISTS book_email_delete;

DELIMITER //
CREATE TRIGGER book_email_delete
BEFORE DELETE
ON reference_table FOR EACH ROW
BEGIN
	IF (old.book_email IN (SELECT book_email FROM book_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete book email, some user still have fk to book";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS book_email_update;

DELIMITER //
CREATE TRIGGER book_email_update
BEFORE UPDATE
ON reference_table FOR EACH ROW
BEGIN
	IF (old.book_email IN (SELECT book_email FROM book_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update book email, some user still have fk to book";
    END IF;
END //
DELIMITER ;

-- catalog

DROP TRIGGER IF EXISTS catalog_delete;

DELIMITER //
CREATE TRIGGER catalog_delete
BEFORE DELETE
ON catalog_table FOR EACH ROW
BEGIN
	IF (old.topic IN (SELECT topic FROM book_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete topic, some book still have fk to topic";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS catalog_update;

DELIMITER //
CREATE TRIGGER catalog_update
BEFORE UPDATE
ON catalog_table FOR EACH ROW
BEGIN
	IF (old.topic IN (SELECT topic FROM book_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update topic, some book still have fk to topic";
    END IF;
END //
DELIMITER ;

-- book

DROP TRIGGER IF EXISTS book_delete;

DELIMITER //
CREATE TRIGGER book_delete
BEFORE DELETE
ON book_table FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT book_id FROM book_user_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete book, some user(s) still have fk to book";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS book_update;

DELIMITER //
CREATE TRIGGER book_update
BEFORE DELETE
ON book_table FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT book_id FROM book_user_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update book, some user(s) still have fk to book";
    END IF;
END //
DELIMITER ;

-- user

DROP TRIGGER IF EXISTS user_delete;

DELIMITER //
CREATE TRIGGER user_delete
BEFORE DELETE
ON user_table FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT user_id FROM book_user_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete user, some book(s) still have fk to user";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS user_update;

DELIMITER //
CREATE TRIGGER user_update
BEFORE DELETE
ON user_table FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT user_id FROM book_user_table))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update user, some book(s) still have fk to user";
    END IF;
END //
DELIMITER ;