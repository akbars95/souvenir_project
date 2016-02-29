DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getCategoryByNameLike`(IN souvenir_categoryIN VARCHAR(50))
BEGIN
select *
from SOUVENIR_CATEGORIES sc
where sc.souvenir_category like souvenir_categoryIN;
END$$
DELIMITER ;
