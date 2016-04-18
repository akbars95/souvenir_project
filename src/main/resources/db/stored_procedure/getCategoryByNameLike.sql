DROP PROCEDURE IF EXISTS souvenir.getCategoryByNameLike;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getCategoryByNameLike`(IN souvenir_categoryIN VARCHAR(50))
BEGIN
	SELECT *
	FROM SOUVENIR_CATEGORIES sc
	WHERE sc.souvenir_category LIKE souvenir_categoryIN;
END$$
DELIMITER ;
