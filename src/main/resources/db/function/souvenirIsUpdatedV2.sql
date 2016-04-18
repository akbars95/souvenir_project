DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdatedV2;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` FUNCTION souvenir.`souvenirIsUpdatedV2`(souvenir_idIN int(11)) RETURNS VARCHAR(5) CHARSET utf8
BEGIN
  DECLARE isUpdated VARCHAR(5);
  DECLARE created_datetimeL datetime;
  
  SELECT created_datetime INTO created_datetimeL
  FROM SOUVENIRS_AUDIT sa
  WHERE sa.created_datetime = sa.last_update_datetime AND sa.souvenir_id = souvenir_idIN;
  
  IF created_datetimeL is null
  THEN SET isUpdated = 'true';
  ELSE SET isUpdated = 'false';
  END IF;
  
	RETURN isUpdated;
END$$
DELIMITER ;
