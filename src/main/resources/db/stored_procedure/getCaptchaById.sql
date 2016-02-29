DELIMITER $$
CREATE PROCEDURE getCaptchaById (IN captcha_idIN int(11))
BEGIN
	SELECT * FROM CAPTCHA WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;