-- -----------------------------------------------------
-- Table `bankingTest`.`account`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `bankingTest`.`account`;

CREATE TABLE `bankingTest`.`account` LIKE `bankingTest`.`accountTest`;

INSERT INTO `bankingTest`.`account` SELECT * FROM `bankingTest`.`accountTest`;