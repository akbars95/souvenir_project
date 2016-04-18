DROP PROCEDURE IF EXISTS souvenir.deleteSouvenir;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteSouvenir`(IN souvenir_idIN int(11))
BEGIN
	DELETE FROM souvenirs WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;
