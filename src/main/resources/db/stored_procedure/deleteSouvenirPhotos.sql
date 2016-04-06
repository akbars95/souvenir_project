DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteSouvenirPhotos`(IN souvenir_photo_souvenir_idIN int(11), 
																	IN souvenir_photo_idIN int(11))
BEGIN
	DELETE FROM souvenir_photos 
    WHERE souvenir_photo_souvenir_id = souvenir_photo_souvenir_idIN or souvenir_photo_id = souvenir_photo_idIN;
END$$
DELIMITER ;
