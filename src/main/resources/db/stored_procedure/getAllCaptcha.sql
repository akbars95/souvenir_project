DELIMITER $$
CREATE PROCEDURE getAllCaptcha ()
BEGIN
	SELECT * FROM CAPTCHA;
END$$
DELIMITER ;