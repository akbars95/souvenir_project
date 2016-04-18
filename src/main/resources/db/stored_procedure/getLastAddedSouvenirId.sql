DROP PROCEDURE IF EXISTS souvenir.getLastAddedSouvenirId;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedSouvenirId`(INOUT lastID INT)
BEGIN
	SELECT MAX(souvenir_id) INTO lastID
  FROM SOUVENIRS;
END$$
DELIMITER ;
