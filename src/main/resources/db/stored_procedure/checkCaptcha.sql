DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkCaptcha`(IN captcha_idIN INT(11), IN captcha_valueIN VARCHAR(10))
BEGIN
	SELECT * FROM CAPTCHA c where c.captcha_id = captcha_idIN AND c.captcha_value = captcha_valueIN;
END$$
DELIMITER ;
