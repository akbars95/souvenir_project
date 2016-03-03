DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getCategoryByNameLike`(IN souvenir_categoryIN VARCHAR(50))
BEGIN
	SELECT *
	FROM SOUVENIR_CATEGORIES sc
	WHERE sc.souvenir_category like souvenir_categoryIN;
END$$
DELIMITER ;
