DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertValute`(IN valute_nameIN VARCHAR(50), IN valute_codeIN INT(11), IN valute_char_codeIN VARCHAR(10),
								IN valute_nominalIN INT(11), IN valute_symbolIN VARCHAR(10))
BEGIN
	INSERT INTO valute (valute_name, valute_code, valute_char_code, valute_nominal, valute_symbol)
    VALUES(valute_nameIN, valute_codeIN, valute_char_codeIN, valute_nominalIN, valute_symbolIN);
END$$
DELIMITER ;
