DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotosBySouvenirId`(IN souvenir_photo_souvenir_idIN int(11))
BEGIN
	SELECT *
    FROM souvenir_photos
    where souvenir_photo_souvenir_id = souvenir_photo_souvenir_idIN;
END$$
DELIMITER ;
