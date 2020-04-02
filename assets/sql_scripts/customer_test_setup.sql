-- -----------------------------------------------------
-- Table `bankingTest`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`customer`;

CREATE TABLE `bankingTest`.`customer` LIKE `bankingTest`.`customerTest`;

INSERT INTO `bankingTest`.`customer` SELECT * FROM `bankingTest`.`customerTest`;