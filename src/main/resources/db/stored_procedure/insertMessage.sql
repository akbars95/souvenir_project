DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertMessage`(IN message_nameIN VARCHAR(50), IN message_emailIN VARCHAR(50), IN message_text_mIN TEXT, IN message_captcha_idIN INT(11))
BEGIN
	INSERT INTO MESSAGE(message_name, message_email, message_text_m, message_captcha_id) 
    VALUES(message_nameIN, message_emailIN, message_text_mIN, message_captcha_idIN);
END$$
DELIMITER ;
