DROP PROCEDURE IF EXISTS souvenir.getLastAddedSouvenir;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE souvenir.`getLastAddedSouvenir`()
BEGIN
	SELECT s.*
  FROM souvenirs s
  ORDER BY s.souvenir_id DESC
  limit 1;
END$$
DELIMITER ;