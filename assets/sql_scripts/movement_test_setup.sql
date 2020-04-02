-- -----------------------------------------------------
-- Table `bankingTest`.`movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankingTest`.`movement` ;

CREATE TABLE `bankingTest`.`movement` LIKE `bankingTest`.`movementTest`;

INSERT INTO `bankingTest`.`movement` SELECT * FROM `bankingTest`.`movementTest`