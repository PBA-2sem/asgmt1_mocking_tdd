-- -----------------------------------------------------
-- Test table setup for bank
-- -----------------------------------------------------

DROP TABLE IF EXISTS `bankingTest`.`bank`;

CREATE TABLE `bankingTest`.`bank` LIKE `bankingTest`.`bankTest`;

INSERT INTO `bankingTest`.`bank` SELECT * FROM `bankingTest`.`bankTest`;
