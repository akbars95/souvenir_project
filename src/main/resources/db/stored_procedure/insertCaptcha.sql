DELIMITER $$
CREATE PROCEDURE insertCaptcha (IN captcha_valueIN varchar(10), IN captcha_url_fileIN varchar(255))
BEGIN
	INSERT INTO CAPTCHA(captcha_value, captcha_url_file) VALUES(captcha_valueIN, captcha_url_fileIN);
END$$
DELIMITER ;