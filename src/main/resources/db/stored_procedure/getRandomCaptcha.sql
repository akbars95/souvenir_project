DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRandomCaptcha`(IN captcha_idIN INT(11))
BEGIN
	DECLARE maxIdCaptcha int;
    DECLARE captcha_idNew int;
    
	select round(rand() * getMaxIdCaptcha()) into maxIdCaptcha;
    
    WHILE maxIdCaptcha = captcha_idIN DO
		select round(rand() * getMaxIdCaptcha()) into maxIdCaptcha;
	END WHILE;
    
    while captcha_idNew is null do
		select c.captcha_id into captcha_idNew from CAPTCHA c where captcha_id = maxIdCaptcha;
    end while;
    
    select c.captcha_id, c.captcha_url_file from CAPTCHA c where captcha_id = maxIdCaptcha;
END$$
DELIMITER ;
