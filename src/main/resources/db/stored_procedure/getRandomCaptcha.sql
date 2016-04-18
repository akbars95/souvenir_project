DROP PROCEDURE IF EXISTS souvenir.getRandomCaptcha;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getRandomCaptcha`(IN captcha_idIN INT(11))
BEGIN
	DECLARE maxIdCaptcha INT;
  DECLARE captcha_idNew INT;
    
	SELECT round(rand() * getMaxIdCaptcha()) INTO maxIdCaptcha;
    
  WHILE maxIdCaptcha = captcha_idIN DO
    SELECT round(rand() * getMaxIdCaptcha()) INTO maxIdCaptcha;
	END WHILE;
    
  WHILE captcha_idNew IS NULL DO
    SELECT c.captcha_id into captcha_idNew FROM CAPTCHA c WHERE captcha_id = maxIdCaptcha;
  END WHILE;
    
    SELECT c.captcha_id, c.captcha_url_file FROM CAPTCHA c WHERE captcha_id = maxIdCaptcha;
END$$
DELIMITER ;
