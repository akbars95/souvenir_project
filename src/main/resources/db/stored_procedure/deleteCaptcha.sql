DELIMITER $$
CREATE PROCEDURE deleteCaptcha (IN captcha_idIN int(11))
BEGIN
	DELETE FROM CAPTCHA WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;
