DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectFullSouvenirWithCategoryAndAudit`()
BEGIN

select s.*, sa.created_datetime, sa.last_update_datetime, sc.souvenir_category
from SOUVENIRS s inner join SOUVENIRS_AUDIT sa on s.souvenir_id = sa.souvenir_id
inner join SOUVENIR_CATEGORIES sc on s.souvenir_category_id =  sc.souvenir_category_id;

END$$
DELIMITER ;
