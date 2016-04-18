DROP PROCEDURE IF EXISTS souvenir.selectFullSouvenirWithCategoryAndAudit;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectFullSouvenirWithCategoryAndAudit`()
BEGIN

SELECT s.*, sa.created_datetime, sa.last_update_datetime, sc.souvenir_category
FROM SOUVENIRS s INNER JOIN SOUVENIRS_AUDIT sa ON s.souvenir_id = sa.souvenir_id
INNER JOIN SOUVENIR_CATEGORIES sc ON s.souvenir_category_id =  sc.souvenir_category_id;

END$$
DELIMITER ;
