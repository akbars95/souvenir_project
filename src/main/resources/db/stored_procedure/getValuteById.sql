DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getValuteById`(IN valute_idIN INT(11))
BEGIN
	SELECT *
    FROM valute v
    WHERE v.valute_id = valute_idIN;
END$$
DELIMITER ;
