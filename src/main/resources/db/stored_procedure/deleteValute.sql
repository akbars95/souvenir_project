DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteValute`(IN valute_idIN INT(11))
BEGIN
	DELETE FROM valute WHERE valute_id = valute_idIN;
END$$
DELIMITER ;
