DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateValute`(IN valute_idIN INT(11), IN valute_nameIN VARCHAR(45), IN valute_codeIN int(11),
							IN valute_char_codeIN varchar(45), IN valute_nominalIN INT(11), IN valute_symbolIN varchar(10))
BEGIN
	UPDATE valute SET valute_name = valute_nameIN, valute_code = valute_codeIN, valute_char_code = valute_char_codeIN,
    valute_nominal = valute_nominalIN, valute_symbol = valute_symbolIN
    WHERE valute_id = valute_idIN;
END$$
DELIMITER ;
