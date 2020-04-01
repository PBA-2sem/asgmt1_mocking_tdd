-- -----------------------------------------------------
-- TEST DATABASE INIT
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bankingTest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bankingTest` DEFAULT CHARACTER SET utf8 ;
USE `bankingTest` ;

-- -----------------------------------------------------
-- Table `bankingTest`.`bank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`bank`;
CREATE TABLE `bankingTest`.`bank` LIKE `bankingTest`.`bankTest`;

-- -----------------------------------------------------
-- Table `bankingTest`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`customer`;

CREATE TABLE `bankingTest`.`customer` LIKE `bankingTest`.`customerTest`;
-- -----------------------------------------------------
-- Table `bankingTest`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`account` ;
CREATE TABLE `bankingTest`.`account` LIKE `bankingTest`.`accountTest`;


-- -----------------------------------------------------
-- Table `bankingTest`.`movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`movement` ;

CREATE TABLE `bankingTest`.`movement` LIKE `bankingTest`.`movementTest`;