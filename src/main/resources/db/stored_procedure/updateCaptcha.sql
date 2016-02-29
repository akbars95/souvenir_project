DELIMITER $$
CREATE PROCEDURE updateCaptcha (IN captcha_idIN int(11), IN captcha_valueIN varchar(10), IN captcha_url_fileIN varchar(255))
BEGIN
	UPDATE CAPTCHA SET captcha_value = captcha_valueIN, captcha_url_file = captcha_url_fileIN WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;
