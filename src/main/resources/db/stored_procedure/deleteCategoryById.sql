DELIMITER $$
CREATE PROCEDURE deleteCategoryById (IN souvenir_category_idIN int(11))
BEGIN
	DELETE FROM SOUVENIR_CATEGORIES WHERE souvenir_category_id = souvenir_category_idIN;
END$$
DELIMITER ;