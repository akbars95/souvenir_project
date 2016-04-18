DROP PROCEDURE IF EXISTS souvenir.getCategoryById;
DELIMITER $$
CREATE PROCEDURE `getCategoryById` (IN souvenir_category_idIN INT(11))
BEGIN
	SELECT * FROM SOUVENIR_CATEGORIES sc
	WHERE sc.souvenir_category_id = souvenir_category_idIN;
END$$

DELIMITER ;