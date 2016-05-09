DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotoById`(IN souvenir_photo_idIN INT(11))
BEGIN
	SELECT *
    FROM souvenir_photos
    WHERE souvenir_photo_id = souvenir_photo_idIN;
END$$
DELIMITER ;
