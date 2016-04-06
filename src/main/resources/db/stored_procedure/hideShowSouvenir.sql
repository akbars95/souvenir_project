DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hideShowSouvenir`(IN souvenir_idIN int(11))
BEGIN
	UPDATE souvenir.souvenirs SET souvenir_show = !souvenir_show WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;
