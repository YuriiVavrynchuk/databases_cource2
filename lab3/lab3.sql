-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema animators_orders
-- -----------------------------------------------------

DROP TABLE IF EXISTS `animators_orders`.`animator`;
DROP TABLE IF EXISTS `animators_orders`.`country`;
DROP TABLE IF EXISTS `animators_orders`.`animators_agency`;
DROP TABLE IF EXISTS `animators_orders`.`event`;
DROP TABLE IF EXISTS `animators_orders`.`client_account`;
DROP TABLE IF EXISTS `animators_orders`.`order`;
DROP TABLE IF EXISTS `animators_orders`.`bill`;
DROP TABLE IF EXISTS `animators_orders`.`feedback`;
DROP TABLE IF EXISTS `animators_orders`.`animators_agency_has_animator`;
DROP TABLE IF EXISTS `animators_orders`.`animator_has_event`;

-- -----------------------------------------------------
-- Schema animators_orders
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `animators_orders` DEFAULT CHARACTER SET utf8 ;
USE `animators_orders` ;

-- -----------------------------------------------------
-- Table `animators_orders`.`animator`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`animator` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `character` VARCHAR(45) NULL,
  `salary` INT NOT NULL,
  `experience` INT NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`country`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`animators_agency`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`animators_agency` (
  `business_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `workers_number` INT NOT NULL,
  `license` VARCHAR(45) NOT NULL,
  `bank_account` VARCHAR(45) NOT NULL,
  `registration_country` INT NOT NULL,
  PRIMARY KEY (`business_id`),
  INDEX `fk_animators_agency_country1_idx` (`registration_country` ASC) VISIBLE,
  INDEX `animator_agency_name_idx` (`name` ASC) VISIBLE,
  CONSTRAINT `fk_animators_agency_country1`
    FOREIGN KEY (`registration_country`)
    REFERENCES `animators_orders`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`event`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `guests_number` INT NULL,
  `address` VARCHAR(45) NOT NULL,
  `date_start` DATETIME NOT NULL,
  `date_end` DATETIME NOT NULL,
  `time_start` TIME NOT NULL,
  `time_end` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `event_address_idx` (`address` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`client_account`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`client_account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `debt` INT NOT NULL,
  `bonuses` INT NULL,
  `blacklist_presence` TINYINT NOT NULL,
  `animators_agency_business_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_account_animators_agency1_idx` (`animators_agency_business_id` ASC) VISIBLE,
  CONSTRAINT `fk_client_account_animators_agency1`
    FOREIGN KEY (`animators_agency_business_id`)
    REFERENCES `animators_orders`.`animators_agency` (`business_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`order`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_datetime` DATETIME NOT NULL,
  `client` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `amount_of_animators` INT NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `event_id` INT NOT NULL,
  `client_account_id` INT NOT NULL,
  `animators_agency_business_id` INT NOT NULL,
  PRIMARY KEY (`id`, `event_id`),
  INDEX `fk_order_event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_order_client_account1_idx` (`client_account_id` ASC) VISIBLE,
  INDEX `fk_order_animators_agency1_idx` (`animators_agency_business_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `animators_orders`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_client_account1`
    FOREIGN KEY (`client_account_id`)
    REFERENCES `animators_orders`.`client_account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_animators_agency1`
    FOREIGN KEY (`animators_agency_business_id`)
    REFERENCES `animators_orders`.`animators_agency` (`business_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`bill`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `client` VARCHAR(45) NOT NULL,
  `bill_datetime` DATETIME NOT NULL,
  `animators_number` INT NOT NULL,
  `perfomance_duration` INT NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `organizer` VARCHAR(45) NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`id`, `order_id`),
  INDEX `fk_bill_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_bill_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `animators_orders`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`feedback`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`feedback` (
  `client` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `text` VARCHAR(200) NULL,
  `rate` INT NULL,
  `event_id` INT NOT NULL,
  `client_account_id` INT NOT NULL,
  PRIMARY KEY (`event_id`),
  INDEX `fk_feedback_event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_feedback_client_account1_idx` (`client_account_id` ASC) VISIBLE,
  CONSTRAINT `fk_feedback_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `animators_orders`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_client_account1`
    FOREIGN KEY (`client_account_id`)
    REFERENCES `animators_orders`.`client_account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`animators_agency_has_animator`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`animators_agency_has_animator` (
  `animators_agency_business_id` INT NOT NULL,
  `animator_id` INT NOT NULL,
  PRIMARY KEY (`animators_agency_business_id`, `animator_id`),
  INDEX `fk_animators_agency_has_animator_animator1_idx` (`animator_id` ASC) VISIBLE,
  INDEX `fk_animators_agency_has_animator_animators_agency_idx` (`animators_agency_business_id` ASC) VISIBLE,
  CONSTRAINT `fk_animators_agency_has_animator_animators_agency`
    FOREIGN KEY (`animators_agency_business_id`)
    REFERENCES `animators_orders`.`animators_agency` (`business_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animators_agency_has_animator_animator1`
    FOREIGN KEY (`animator_id`)
    REFERENCES `animators_orders`.`animator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`animator_has_event`
-- -----------------------------------------------------
CREATE TABLE `animators_orders`.`animator_has_event` (
  `animator_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`animator_id`, `event_id`),
  INDEX `fk_animator_has_event_event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_animator_has_event_animator1_idx` (`animator_id` ASC) VISIBLE,
  CONSTRAINT `fk_animator_has_event_animator1`
    FOREIGN KEY (`animator_id`)
    REFERENCES `animators_orders`.`animator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animator_has_event_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `animators_orders`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `animators_orders`.`country` (`country`) VALUES ('Ukraine');
INSERT INTO `animators_orders`.`country` (`country`) VALUES ('USA');
INSERT INTO `animators_orders`.`country` (`country`) VALUES ('Uganda');
INSERT INTO `animators_orders`.`country` (`country`) VALUES ('Portugal');
INSERT INTO `animators_orders`.`country` (`country`) VALUES ('CumBodga');
INSERT INTO `animators_orders`.`country` (`country`) VALUES ('Germany');

INSERT INTO `animators_orders`.`animators_agency` (`name`, `address`, `workers_number`, `license`, `bank_account`, `registration_country`) VALUES ('TSUKAT', 'Bandera', '1000000', 'MIT', '911', '1');
INSERT INTO `animators_orders`.`animators_agency` (`name`, `address`, `workers_number`, `license`, `bank_account`, `registration_country`) VALUES ('Microsoft', 'Bandera', '1000000', 'MIT', '911', '2');
INSERT INTO `animators_orders`.`animators_agency` (`name`, `address`, `workers_number`, `license`, `bank_account`, `registration_country`) VALUES ('Apple', 'Bandera', '1000000', 'MIT', '911', '3');
INSERT INTO `animators_orders`.`animators_agency` (`name`, `address`, `workers_number`, `license`, `bank_account`, `registration_country`) VALUES ('B2B', 'Bandera', '1000000', 'MIT', '911', '4');
INSERT INTO `animators_orders`.`animators_agency` (`name`, `address`, `workers_number`, `license`, `bank_account`, `registration_country`) VALUES ('Veres inc', 'Bandera', '1000000', 'MIT', '911', '5');
INSERT INTO `animators_orders`.`animators_agency` (`name`, `address`, `workers_number`, `license`, `bank_account`, `registration_country`) VALUES ('Vavrynchuk ink', 'Bandera', '1000000', 'MIT', '911', '6');

INSERT INTO `animators_orders`.`animator` (`name`, `surname`, `age`, `gender`, `character`, `salary`, `experience`, `phone`, `email`) VALUES ('Yura', 'Vavryk', '100', 'Male', 'Luntik', '10000', '99', '911', 'veres');
INSERT INTO `animators_orders`.`animator` (`name`, `surname`, `age`, `gender`, `character`, `salary`, `experience`, `phone`, `email`) VALUES ('Oleg', 'Vavryk', '10', 'Male', 'Cloun', '1000', '99', '911', 'veres');
INSERT INTO `animators_orders`.`animator` (`name`, `surname`, `age`, `gender`, `character`, `salary`, `experience`, `phone`, `email`) VALUES ('Ivan', 'Vavryk', '1300', 'Male', 'BabaCapa', '103000', '99', '911', 'veres');
INSERT INTO `animators_orders`.`animator` (`name`, `surname`, `age`, `gender`, `character`, `salary`, `experience`, `phone`, `email`) VALUES ('Stepan', 'Vavryk', '1600', 'Male', 'Stepan', '10080', '99', '911', 'veres');
INSERT INTO `animators_orders`.`animator` (`name`, `surname`, `age`, `gender`, `character`, `salary`, `experience`, `phone`, `email`) VALUES ('George', 'Vavryk', '150', 'Male', 'Yurtan', '1400', '99', '911', 'veres');
INSERT INTO `animators_orders`.`animator` (`name`, `surname`, `age`, `gender`, `character`, `salary`, `experience`, `phone`, `email`) VALUES ('Punec', 'Vavryk', '1001', 'Male', 'Gopa', '10030', '99', '911', 'veres');

INSERT INTO `animators_orders`.`animators_agency_has_animator` (`animators_agency_business_id`, `animator_id`) VALUES ('1', '1');
INSERT INTO `animators_orders`.`animators_agency_has_animator` (`animators_agency_business_id`, `animator_id`) VALUES ('2', '2');
INSERT INTO `animators_orders`.`animators_agency_has_animator` (`animators_agency_business_id`, `animator_id`) VALUES ('3', '3');
INSERT INTO `animators_orders`.`animators_agency_has_animator` (`animators_agency_business_id`, `animator_id`) VALUES ('4', '4');
INSERT INTO `animators_orders`.`animators_agency_has_animator` (`animators_agency_business_id`, `animator_id`) VALUES ('5', '5');
INSERT INTO `animators_orders`.`animators_agency_has_animator` (`animators_agency_business_id`, `animator_id`) VALUES ('6', '6');

INSERT INTO `animators_orders`.`client_account` (`name`, `surname`, `age`, `gender`, `phone`, `email`, `debt`, `bonuses`, `blacklist_presence`, `animators_agency_business_id`) VALUES ('Yura', 'Vavryk', '100', 'Male', '02', 'veres', '1000', '0', '1', '1');
INSERT INTO `animators_orders`.`client_account` (`name`, `surname`, `age`, `gender`, `phone`, `email`, `debt`, `bonuses`, `blacklist_presence`, `animators_agency_business_id`) VALUES ('Oleg', 'Vavryk', '10', 'Male', '02', 'veres', '1000', '0', '1', '2');
INSERT INTO `animators_orders`.`client_account` (`name`, `surname`, `age`, `gender`, `phone`, `email`, `debt`, `bonuses`, `blacklist_presence`, `animators_agency_business_id`) VALUES ('Ivan', 'Vavryk', '1300', 'Male', '02', 'veres', '1000', '0', '1', '3');
INSERT INTO `animators_orders`.`client_account` (`name`, `surname`, `age`, `gender`, `phone`, `email`, `debt`, `bonuses`, `blacklist_presence`, `animators_agency_business_id`) VALUES ('Stepan', 'Vavryk', '1600', 'Male', '02', 'veres', '1000', '0', '1', '4');
INSERT INTO `animators_orders`.`client_account` (`name`, `surname`, `age`, `gender`, `phone`, `email`, `debt`, `bonuses`, `blacklist_presence`, `animators_agency_business_id`) VALUES ('George', 'Vavryk', '150', 'Male', '02', 'veres', '1000', '0', '1', '5');
INSERT INTO `animators_orders`.`client_account` (`name`, `surname`, `age`, `gender`, `phone`, `email`, `debt`, `bonuses`, `blacklist_presence`, `animators_agency_business_id`) VALUES ('Punec', 'Vavryk', '1001', 'Male', '02', 'veres', '1000', '0', '1', '6');

INSERT INTO `animators_orders`.`event` (`title`, `subject`, `guests_number`, `address`, `date_start`, `date_end`, `time_start`, `time_end`) VALUES ('Donbass', 'NY', '10000', 'Bandera', '2014-10-23 10:37:22', '2021-10-23 10:37:22', '00:00:00', '00:00:00');
INSERT INTO `animators_orders`.`event` (`title`, `subject`, `guests_number`, `address`, `date_start`, `date_end`, `time_start`, `time_end`) VALUES ('Uganda', 'NY', '10000', 'Bandera', '2014-10-23 10:37:22', '2021-10-23 10:37:22', '00:00:00', '00:00:00');
INSERT INTO `animators_orders`.`event` (`title`, `subject`, `guests_number`, `address`, `date_start`, `date_end`, `time_start`, `time_end`) VALUES ('Corporatyv', 'NY', '10000', 'Bandera', '2014-10-23 10:37:22', '2021-10-23 10:37:22', '00:00:00', '00:00:00');
INSERT INTO `animators_orders`.`event` (`title`, `subject`, `guests_number`, `address`, `date_start`, `date_end`, `time_start`, `time_end`) VALUES ('Vypusknii', 'NY', '10000', 'Bandera', '2014-10-23 10:37:22', '2021-10-23 10:37:22', '00:00:00', '00:00:00');
INSERT INTO `animators_orders`.`event` (`title`, `subject`, `guests_number`, `address`, `date_start`, `date_end`, `time_start`, `time_end`) VALUES ('Orgic', 'NY', '10000', 'Bandera', '2014-10-23 10:37:22', '2021-10-23 10:37:22', '00:00:00', '00:00:00');
INSERT INTO `animators_orders`.`event` (`title`, `subject`, `guests_number`, `address`, `date_start`, `date_end`, `time_start`, `time_end`) VALUES ('Orgic', 'NY', '10000', 'Bandera', '2014-10-23 10:37:22', '2021-10-23 10:37:22', '00:00:00', '00:00:00');

INSERT INTO `animators_orders`.`animator_has_event` (`animator_id`, `event_id`) VALUES ('1', '1');
INSERT INTO `animators_orders`.`animator_has_event` (`animator_id`, `event_id`) VALUES ('2', '2');
INSERT INTO `animators_orders`.`animator_has_event` (`animator_id`, `event_id`) VALUES ('3', '3');
INSERT INTO `animators_orders`.`animator_has_event` (`animator_id`, `event_id`) VALUES ('4', '4');
INSERT INTO `animators_orders`.`animator_has_event` (`animator_id`, `event_id`) VALUES ('5', '5');
INSERT INTO `animators_orders`.`animator_has_event` (`animator_id`, `event_id`) VALUES ('6', '6');

INSERT INTO `animators_orders`.`order` (`order_datetime`, `client`, `price`, `amount_of_animators`, `subject`, `event_id`, `client_account_id`, `animators_agency_business_id`) VALUES ('2008-10-23 10:37:22', 'Yur3a', '100', '1300', 'Pop', '1', '1', '1');
INSERT INTO `animators_orders`.`order` (`order_datetime`, `client`, `price`, `amount_of_animators`, `subject`, `event_id`, `client_account_id`, `animators_agency_business_id`) VALUES ('2008-10-23 10:37:23', 'Yur4a', '120', '1300', 'Rock', '2', '2', '2');
INSERT INTO `animators_orders`.`order` (`order_datetime`, `client`, `price`, `amount_of_animators`, `subject`, `event_id`, `client_account_id`, `animators_agency_business_id`) VALUES ('2008-10-23 10:37:24', 'Yur5a', '10', '1300', 'Podp', '3', '3', '3');
INSERT INTO `animators_orders`.`order` (`order_datetime`, `client`, `price`, `amount_of_animators`, `subject`, `event_id`, `client_account_id`, `animators_agency_business_id`) VALUES ('2008-10-23 10:37:25', 'Yur6a', '1020', '1300', 'Psop', '4', '4', '4');
INSERT INTO `animators_orders`.`order` (`order_datetime`, `client`, `price`, `amount_of_animators`, `subject`, `event_id`, `client_account_id`, `animators_agency_business_id`) VALUES ('2008-10-23 10:37:26', 'Yur7a', '1010', '1300', 'Pops', '5', '5', '5');
INSERT INTO `animators_orders`.`order` (`order_datetime`, `client`, `price`, `amount_of_animators`, `subject`, `event_id`, `client_account_id`, `animators_agency_business_id`) VALUES ('2008-10-23 10:37:27', 'Yur38a', '1100', '1300', 'Podp', '6', '6', '6');

INSERT INTO `animators_orders`.`bill` (`client`, `bill_datetime`, `animators_number`, `perfomance_duration`, `price`, `organizer`, `order_id`) VALUES ('Yura', '2008-10-23 10:37:22', '100', '100', '1000', 'Yura', '1');
INSERT INTO `animators_orders`.`bill` (`client`, `bill_datetime`, `animators_number`, `perfomance_duration`, `price`, `organizer`, `order_id`) VALUES ('Oleg', '2008-10-23 10:37:23', '100', '100', '1000', 'Yura', '2');
INSERT INTO `animators_orders`.`bill` (`client`, `bill_datetime`, `animators_number`, `perfomance_duration`, `price`, `organizer`, `order_id`) VALUES ('Ivan', '2008-10-23 10:37:24', '100', '100', '1000', 'Yura', '3');
INSERT INTO `animators_orders`.`bill` (`client`, `bill_datetime`, `animators_number`, `perfomance_duration`, `price`, `organizer`, `order_id`) VALUES ('Stepan', '2008-10-23 10:37:25', '100', '100', '1000', 'Yura', '4');
INSERT INTO `animators_orders`.`bill` (`client`, `bill_datetime`, `animators_number`, `perfomance_duration`, `price`, `organizer`, `order_id`) VALUES ('George', '2008-10-23 10:37:26', '100', '100', '1000', 'Yura', '5');
INSERT INTO `animators_orders`.`bill` (`client`, `bill_datetime`, `animators_number`, `perfomance_duration`, `price`, `organizer`, `order_id`) VALUES ('Punec', '2008-10-23 10:37:27', '100', '100', '1000', 'Yura', '6');

INSERT INTO `animators_orders`.`feedback` (`client`, `date`, `text`, `rate`, `event_id`, `client_account_id`) VALUES ('Yura', '2008-10-23 10:37:22', 'VERY GOOD EVENT I AM VERY HEPPY!!!!', '100', '1', '1');
INSERT INTO `animators_orders`.`feedback` (`client`, `date`, `text`, `rate`, `event_id`, `client_account_id`) VALUES ('Oleg', '2008-10-23 10:37:23', 'VERY GOOD EVENT I AM VERY HEPPY!!!!', '100', '2', '2');
INSERT INTO `animators_orders`.`feedback` (`client`, `date`, `text`, `rate`, `event_id`, `client_account_id`) VALUES ('Ivan', '2008-10-23 10:37:24', 'VERY GOOD EVENT I AM VERY HEPPY!!!!', '100', '3', '3');
INSERT INTO `animators_orders`.`feedback` (`client`, `date`, `text`, `rate`, `event_id`, `client_account_id`) VALUES ('Stepan', '2008-10-23 10:37:25', 'VERY GOOD EVENT I AM VERY HEPPY!!!!', '100', '4', '4');
INSERT INTO `animators_orders`.`feedback` (`client`, `date`, `text`, `rate`, `event_id`, `client_account_id`) VALUES ('George', '2008-10-23 10:37:26', 'VERY GOOD EVENT I AM VERY HEPPY!!!!', '100', '5', '5');
INSERT INTO `animators_orders`.`feedback` (`client`, `date`, `text`, `rate`, `event_id`, `client_account_id`) VALUES ('Punec', '2008-10-23 10:37:27', 'VERY GOOD EVENT I AM VERY HEPPY!!!!', '100', '6', '6');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
