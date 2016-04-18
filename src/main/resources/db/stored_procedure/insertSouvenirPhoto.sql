DROP PROCEDURE IF EXISTS souvenir.insertSouvenirPhoto;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSouvenirPhoto`(IN souvenir_photo_pathIN VARCHAR(255), IN souvenir_photo_souvenir_idIN INT(11))
BEGIN
	INSERT INTO souvenir_photos(souvenir_photo_path, souvenir_photo_souvenir_id)
    VALUES (souvenir_photo_pathIN, souvenir_photo_souvenir_idIN);
END$$
DELIMITER ;
