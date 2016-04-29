DROP PROCEDURE IF EXISTS souvenir.getSouvenirPhotosAll;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotosAll`()
BEGIN
	select *
    from souvenir_photos sp;
END$$
DELIMITER ;
