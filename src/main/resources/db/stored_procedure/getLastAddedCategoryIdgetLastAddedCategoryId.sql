DROP PROCEDURE IF EXISTS souvenir.getLastAddedCategoryIdgetLastAddedCategoryId;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedCategoryIdgetLastAddedCategoryId`()
BEGIN
	SELECT MAX(souvenir_category_id)
  FROM SOUVENIR_CATEGORIES;
END$$
DELIMITER ;
