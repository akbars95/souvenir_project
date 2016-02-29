DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectSouvenir`(IN souvenir_idIN int(11))
BEGIN
	SELECT * FROM FULL_SELECT_SOUVENIRS WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;
