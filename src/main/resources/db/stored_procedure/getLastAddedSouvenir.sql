DELIMITER $$
DROP PROCEDURE IF EXISTS souvenir.getLastAddedSouvenir;
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE souvenir.`getLastAddedSouvenir`()
BEGIN
	select s.*
  from souvenirs s
  order by s.souvenir_id desc
  limit 1;
END$$
DELIMITER ;