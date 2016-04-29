DROP PROCEDURE IF EXISTS souvenir.getSouvenirPhotosByPath;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotosByPath`(IN souvenir_photo_pathIN varchar(255))
BEGIN
	select *
    from souvenir_photos sp
    where sp.souvenir_photo_path = souvenir_photo_pathIN;
END$$
DELIMITER ;
