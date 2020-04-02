-- -----------------------------------------------------
-- Schema banking
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `banking` ;

-- -----------------------------------------------------
-- Schema banking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banking` DEFAULT CHARACTER SET utf8 ;
USE `banking` ;

-- -----------------------------------------------------
-- Table `banking`.`bank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banking`.`bank` ;

CREATE TABLE IF NOT EXISTS `banking`.`bank` (
  `cvr` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cvr`));


-- -----------------------------------------------------
-- Table `banking`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banking`.`customer` ;

CREATE TABLE IF NOT EXISTS `banking`.`customer` (
  `cpr` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `cvr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cpr`),
  INDEX `cvr_idx` (`cvr` ASC),
  CONSTRAINT `cvr`
    FOREIGN KEY (`cvr`)
    REFERENCES `banking`.`bank` (`cvr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `banking`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banking`.`account` ;

CREATE TABLE IF NOT EXISTS `banking`.`account` (
  `number` VARCHAR(255) NOT NULL,
  `balance` INT NULL,
  `cpr` INT NOT NULL,
  PRIMARY KEY (`number`),
  INDEX `cpr_idx` (`cpr` ASC),
  CONSTRAINT `cpr`
    FOREIGN KEY (`cpr`)
    REFERENCES `banking`.`customer` (`cpr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `banking`.`movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banking`.`movement` ;

CREATE TABLE IF NOT EXISTS `banking`.`movement` (
  `idmovement` INT NOT NULL AUTO_INCREMENT,
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
    REFERENCES `banking`.`account` (`number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `destination_account`
    FOREIGN KEY (`destination_account`)
    REFERENCES `banking`.`account` (`number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);