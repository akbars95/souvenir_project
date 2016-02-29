USE `souvenir`;

DELIMITER $$

DROP TRIGGER IF EXISTS souvenir.SOUVENIRS_AFTER_INSERT$$
USE `souvenir`$$
CREATE DEFINER = CURRENT_USER TRIGGER `souvenir`.`SOUVENIRS_AFTER_INSERT` AFTER INSERT ON `SOUVENIRS` FOR EACH ROW
BEGIN
SET @lastID = 0;

CALL `souvenir`.`getLastAddedSouvenirId`(@lastID);

insert into SOUVENIRS_AUDIT(souvenir_id, created_datetime, last_update_datetime) values(NEW.souvenir_id , current_timestamp(), now());/*@lastID instead of NEW.souvenir_id */
END$$
DELIMITER ;