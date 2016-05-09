DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOrUpdateSouvenirMainPhotoId`(IN souvenir_main_photo_idIN INT(11), IN souvenir_idIN INT(11))
BEGIN
	UPDATE souvenirs SET souvenir_main_photo_id = souvenir_main_photo_idIN WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;
