DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `insertCategory`(IN souvenir_categoryIN varchar(50))
BEGIN
INSERT INTO SOUVENIR_CATEGORIES(souvenir_category) values(souvenir_categoryIN);
END$$
DELIMITER ;
