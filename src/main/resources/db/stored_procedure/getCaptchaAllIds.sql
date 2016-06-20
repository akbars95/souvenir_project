DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCaptchaAllIds`()
BEGIN
	select c.captcha_id
	from captcha c
	order by c.captcha_id ASC;
END$$
DELIMITER ;
