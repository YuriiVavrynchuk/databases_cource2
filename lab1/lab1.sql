-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema animators_orders
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema animators_orders
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `animators_orders` DEFAULT CHARACTER SET utf8 ;
USE `animators_orders` ;

-- -----------------------------------------------------
-- Table `animators_orders`.`animator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `animators_orders`.`animator` (
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
CREATE TABLE IF NOT EXISTS `animators_orders`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`animators_agency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `animators_orders`.`animators_agency` (
  `business_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `workers_number` INT NOT NULL,
  `license` VARCHAR(45) NOT NULL,
  `bank_account` VARCHAR(45) NOT NULL,
  `registration_country` INT NOT NULL,
  PRIMARY KEY (`business_id`),
  INDEX `fk_animators_agency_country1_idx` (`registration_country` ASC) VISIBLE,
  CONSTRAINT `fk_animators_agency_country1`
    FOREIGN KEY (`registration_country`)
    REFERENCES `animators_orders`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `animators_orders`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `guests_number` INT NULL,
  `address` VARCHAR(45) NOT NULL,
  `date_start` DATETIME NOT NULL,
  `date_end` DATETIME NOT NULL,
  `time_start` TIME NOT NULL,
  `time_end` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animators_orders`.`client_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `animators_orders`.`client_account` (
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
CREATE TABLE IF NOT EXISTS `animators_orders`.`order` (
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
CREATE TABLE IF NOT EXISTS `animators_orders`.`bill` (
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
CREATE TABLE IF NOT EXISTS `animators_orders`.`feedback` (
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
CREATE TABLE IF NOT EXISTS `animators_orders`.`animators_agency_has_animator` (
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
CREATE TABLE IF NOT EXISTS `animators_orders`.`animator_has_event` (
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
