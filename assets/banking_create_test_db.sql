-- -----------------------------------------------------
-- Schema bankingTest
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bankingTest` ;

-- -----------------------------------------------------
-- Schema bankingTest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bankingTest` DEFAULT CHARACTER SET utf8 ;
USE `bankingTest` ;

-- -----------------------------------------------------
-- Table `bankingTest`.`bankTest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`bankTest` ;

CREATE TABLE IF NOT EXISTS `bankingTest`.`bankTest` (
  `cvr` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cvr`));


-- -----------------------------------------------------
-- Table `bankingTest`.`customerTest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`customerTest` ;

CREATE TABLE IF NOT EXISTS `bankingTest`.`customerTest` (
  `cpr` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `cvr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cpr`),
  INDEX `cvr_idx` (`cvr` ASC),
  CONSTRAINT `cvr`
    FOREIGN KEY (`cvr`)
    REFERENCES `bankingTest`.`bankTest` (`cvr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `bankingTest`.`accountTest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`accountTest` ;

CREATE TABLE IF NOT EXISTS `bankingTest`.`accountTest` (
  `number` VARCHAR(255) NOT NULL,
  `balance` INT NULL,
  `cpr` INT NOT NULL,
  PRIMARY KEY (`number`),
  INDEX `cpr_idx` (`cpr` ASC),
  CONSTRAINT `cpr`
    FOREIGN KEY (`cpr`)
    REFERENCES `bankingTest`.`customerTest` (`cpr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `bankingTest`.`movementTest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`movementTest` ;

CREATE TABLE IF NOT EXISTS `bankingTest`.`movementTest` (
  `idmovement` INT NOT NULL,
  `timestamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` INT NOT NULL,
  `source_account` VARCHAR(255) NULL,
  `destination_account` VARCHAR(255) NULL,
  `type` ENUM("withdrawal", "deposit") NOT NULL,
  PRIMARY KEY (`idmovement`),
  INDEX `source_idx` (`source_account` ASC),
  INDEX `destination_account_idx` (`destination_account` ASC),
  CONSTRAINT `source_account`
    FOREIGN KEY (`source_account`)
    REFERENCES `bankingTest`.`accountTest` (`number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `destination_account`
    FOREIGN KEY (`destination_account`)
    REFERENCES `bankingTest`.`accountTest` (`number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);