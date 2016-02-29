DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedSouvenirId`(INOUT lastID INT)
BEGIN
	select MAX(souvenir_id) into lastID
    from SOUVENIRS;
END$$
DELIMITER ;
