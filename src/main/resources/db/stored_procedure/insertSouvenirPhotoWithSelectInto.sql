DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSouvenirPhotoWithSelectInto`(IN souvenir_photo_pathIN VARCHAR(255), 
														IN souvenir_nameIN VARCHAR(50))
BEGIN
	INSERT INTO souvenir_photos(souvenir_photo_path, souvenir_photo_souvenir_id)
    SELECT souvenir_photo_pathIN, souvenir_id FROM souvenirs
	WHERE souvenir_name = souvenir_nameIN;
END$$
DELIMITER ;
