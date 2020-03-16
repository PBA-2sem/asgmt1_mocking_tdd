-- -----------------------------------------------------
-- TEST DATABASE INIT
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bankingTest`;

-- -----------------------------------------------------
-- Schema bankingTest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bankingTest` DEFAULT CHARACTER SET utf8 ;
USE `bankingTest` ;

-- -----------------------------------------------------
-- Table `bankingTest`.`bank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`bank`;
CREATE TABLE `bankingTest`.`bank` LIKE `banking`.`bank`;

-- -----------------------------------------------------
-- Table `bankingTest`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`customer`;

CREATE TABLE `bankingTest`.`customer` LIKE `banking`.`customer`;

-- -----------------------------------------------------
-- Table `bankingTest`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`account` ;
CREATE TABLE `bankingTest`.`account` LIKE `banking`.`account`;


-- -----------------------------------------------------
-- Table `bankingTest`.`movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`movement` ;

CREATE TABLE `bankingTest`.`movement` LIKE `banking`.`movement`;