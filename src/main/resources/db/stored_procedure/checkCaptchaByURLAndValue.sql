DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkCaptchaByURLAndValue`(IN captcha_valueIN VARCHAR(10), IN captcha_url_fileIN VARCHAR(255))
BEGIN
	SELECT * FROM CAPTCHA c WHERE c.captcha_url_file like captcha_url_fileIN AND c.captcha_value = captcha_valueIN;
END$$
DELIMITER ;
