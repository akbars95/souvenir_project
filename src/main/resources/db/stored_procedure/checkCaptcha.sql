DROP PROCEDURE IF EXISTS souvenir.checkCaptcha;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `checkCaptcha`(IN captcha_idIN INT(11), IN captcha_valueIN VARCHAR(10))
BEGIN
	SELECT * FROM CAPTCHA c WHERE c.captcha_id = captcha_idIN AND c.captcha_value = captcha_valueIN;
END$$
DELIMITER ;
