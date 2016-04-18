DROP PROCEDURE IF EXISTS souvenir.insertCategory;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `insertCategory`(IN souvenir_categoryIN varchar(50))
BEGIN
  INSERT INTO SOUVENIR_CATEGORIES(souvenir_category) VALUES(souvenir_categoryIN);
END$$
DELIMITER ;
