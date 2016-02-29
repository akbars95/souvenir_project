DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectFullSouvenirWithCategoryAndAudit`()
BEGIN

select s.*, sa.created_datetime, sa.last_update_datetime, sc.souvenir_category
from souvenirs s inner join souvenirs_audit sa on s.souvenir_id = sa.souvenir_id
inner join souvenir_categories sc on s.souvenir_category_id =  sc.souvenir_category_id;

END$$
DELIMITER ;
