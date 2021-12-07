USE books_db;

INSERT INTO `books_db`.`password_table` (`user_password`) VALUES ('qwerty123'), ('12345'), ('09876');
INSERT INTO `books_db`.`reference_table` (`book_email`) VALUES ('qwerty'), ('fdsfs'), ('khofsd');
INSERT INTO `books_db`.`catalog_table` (`topic`) VALUES ('Adventures'), ('Fights'), ('Romantic');
INSERT INTO `books_db`.`user_table` (`login`, `password_id`, `name`, `surname`, `middle_name`, `birthday`, `birth_place`, `living_place`, `notes`, `rate`)
VALUES
('yvavryk', 1, 'Yura', 'Юрмих', 'Palych', '10.11.2002', 'Харків', 'Lviv', 'Bebebe', 10), 
('yvavryk', 2, 'Yura', 'Ютич', 'Palych', '10.11.2002', 'Вінниця', 'Lviv', 'Bebebe', 10),
('yvavryk', 3, 'Yura', 'Юмик', 'Palych', '10.11.2002', 'Дніпропетровськ', 'Lviv', 'Bebebe', 10);
INSERT INTO `books_db`.`book_table` (`book_email`, `topic`, `title`, `author`, `UDK`, `rate`)
VALUES
('qwerty', 'Adventures', 'YuraPura', 'Shevchenko', 'A434FD', 2),
('fdsfs', 'Fights', 'YuraGora', 'Kalinichenko', 'A434FD', 2),
('khofsd', 'Romantic', 'YuraNoga', 'Lazarenko', 'A434FD', 2);
INSERT INTO `books_db`.`book_user_table` (`book_id`, `user_id`) VALUES (1, 1), (2, 2), (3, 3);