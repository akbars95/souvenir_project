DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdated;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `souvenirIsUpdated`(souvenir_idIN int(11)) RETURNS varchar(5) CHARSET utf8
BEGIN

DECLARE isUpdated VARCHAR(5);
  DECLARE created_datetimeL datetime;
  DECLARE last_update_datetimeL datetime;

  select created_datetime, last_update_datetime into created_datetimeL, last_update_datetimeL
  FROM SOUVENIRS_AUDIT sa
  where sa.souvenir_id = souvenir_idIN;

  IF created_datetimeL = last_update_datetimeL
  THEN SET isUpdated = 'false';
  ELSE SET isUpdated = 'true';
  END IF;

	RETURN isUpdated;

END$$
DELIMITER ;

