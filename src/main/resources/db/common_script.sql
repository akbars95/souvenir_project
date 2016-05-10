
		/*drop and create database*/
DROP DATABASE IF EXISTS souvenir;
DROP USER IF EXISTS 'souvenir'@'localhost';

CREATE DATABASE IF NOT EXISTS souvenir CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'souvenir'@'localhost' IDENTIFIED BY 'souvenir12345';
GRANT ALL PRIVILEGES ON souvenir. * TO 'souvenir'@'localhost';


		/*tables*/
use souvenir;

CREATE TABLE `SOUVENIR_CATEGORIES` (
  `souvenir_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_category` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`souvenir_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `SOUVENIRS` (
  `souvenir_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_name` varchar(50) NOT NULL,
  `souvenir_description` varchar(255) DEFAULT NULL,
  `souvenir_show` tinyint(1) NOT NULL DEFAULT '1',
  `souvenir_main_photo_id` int(11) NULL,
  `souvenir_category_id` int(11) DEFAULT NULL,
  `souvenir_price` decimal(8,2) DEFAULT NULL,
  `souvenir_count_of_days_for_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`souvenir_id`),
  KEY `souvenir_category_id_souvenir_id_idx` (`souvenir_category_id`),
  CONSTRAINT `souvenir_category_id_souvenir_id` FOREIGN KEY (`souvenir_category_id`) REFERENCES `SOUVENIR_CATEGORIES` (`souvenir_category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `SOUVENIR_PHOTOS` (
  `souvenir_photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `souvenir_photo_path` varchar(255) NOT NULL,
  `souvenir_photo_souvenir_id` int(11) NOT NULL,
  PRIMARY KEY (`souvenir_photo_id`),
  UNIQUE KEY `souvenir_photo_path_UNIQUE` (`souvenir_photo_path`),
  KEY `souvenir_photo_id_souvenir_id_idx` (`souvenir_photo_souvenir_id`),
  CONSTRAINT `souvenir_photo_id_souvenir_id` FOREIGN KEY (`souvenir_photo_souvenir_id`) REFERENCES `souvenirs` (`souvenir_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `SOUVENIRS_AUDIT` (
  `souvenir_id` int(11) NOT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `last_update_datetime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `CAPTCHA` (
  `captcha_id` int(11) NOT NULL AUTO_INCREMENT,
  `captcha_value` varchar(10) CHARACTER SET utf8 NOT NULL,
  `captcha_url_file` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`captcha_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `MESSAGE` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `message_email` varchar(50) CHARACTER SET utf8 NOT NULL,
  `message_text_m` text CHARACTER SET utf8 NOT NULL,
  `message_captcha_id` int(11) NOT NULL,
  PRIMARY KEY (`message_id`),
  UNIQUE KEY `message_id_UNIQUE` (`message_id`),
  KEY `message_ci_captcha_id_idx` (`message_captcha_id`),
  CONSTRAINT `message_ci_captcha_id` FOREIGN KEY (`message_captcha_id`) REFERENCES `CAPTCHA` (`captcha_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;




		/*views*/
CREATE ALGORITHM=UNDEFINED DEFINER=`souvenir`@`localhost` SQL SECURITY DEFINER VIEW `FULL_SELECT_SOUVENIRS` AS
SELECT `s`.`souvenir_id` AS `souvenir_id`,`s`.`souvenir_name` AS `souvenir_name`,`s`.`souvenir_description` AS `souvenir_description`,
`s`.`souvenir_show` AS `souvenir_show`,`s`.`souvenir_main_photo_id` AS `souvenir_main_photo_id`,
`s`.`souvenir_category_id` AS `souvenir_category_id`,`s`.`souvenir_price` AS `souvenir_price`,
`s`.`souvenir_count_of_days_for_order` AS `souvenir_count_of_days_for_order`,`sc`.`souvenir_category` AS `souvenir_category`
FROM (`SOUVENIRS` `s` JOIN `SOUVENIR_CATEGORIES` `sc` on((`s`.`souvenir_category_id` = `sc`.`souvenir_category_id`)));


		/*triggers*/
USE `souvenir`;

DELIMITER $$

DROP TRIGGER IF EXISTS souvenir.SOUVENIRS_AFTER_INSERT$$
USE `souvenir`$$
CREATE DEFINER = CURRENT_USER TRIGGER `souvenir`.`SOUVENIRS_AFTER_INSERT` AFTER INSERT ON `SOUVENIRS` FOR EACH ROW
BEGIN
SET @lastID = 0;

CALL `souvenir`.`getLastAddedSouvenirId`(@lastID);

INSERT INTO SOUVENIRS_AUDIT(souvenir_id, created_datetime, last_update_datetime)
VALUES(NEW.souvenir_id , current_timestamp(), now());/*@lastID instead of NEW.souvenir_id */
END$$
DELIMITER ;

USE `souvenir`;

DELIMITER $$

DROP TRIGGER IF EXISTS souvenir.SOUVENIRS_AFTER_UPDATE$$
USE `souvenir`$$
CREATE DEFINER = CURRENT_USER TRIGGER `souvenir`.`SOUVENIRS_AFTER_UPDATE` AFTER UPDATE ON `SOUVENIRS` FOR EACH ROW
BEGIN
	UPDATE SOUVENIRS_AUDIT SET last_update_datetime = now() WHERE souvenir_id = OLD.souvenir_id;
END$$
DELIMITER ;


		/*stored_procedures*/
DROP PROCEDURE IF EXISTS souvenir.checkCaptcha;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `checkCaptcha`(IN captcha_idIN INT(11), IN captcha_valueIN VARCHAR(10))
BEGIN
	SELECT * FROM CAPTCHA c WHERE c.captcha_id = captcha_idIN AND c.captcha_value = captcha_valueIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.deleteCaptcha;
DELIMITER $$
CREATE PROCEDURE deleteCaptcha (IN captcha_idIN int(11))
BEGIN
	DELETE FROM CAPTCHA WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.deleteCategoryById;
DELIMITER $$
CREATE PROCEDURE deleteCategoryById (IN souvenir_category_idIN int(11))
BEGIN
	DELETE FROM SOUVENIR_CATEGORIES WHERE souvenir_category_id = souvenir_category_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.deleteSouvenir;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteSouvenir`(IN souvenir_idIN int(11))
BEGIN
	DELETE FROM souvenirs WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.deleteSouvenirPhotos;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteSouvenirPhotos`(IN souvenir_photo_souvenir_idIN int(11), 
																	IN souvenir_photo_idIN int(11))
BEGIN
	DELETE FROM souvenir_photos 
	WHERE souvenir_photo_souvenir_id = souvenir_photo_souvenir_idIN OR souvenir_photo_id = souvenir_photo_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getAllCaptcha;
DELIMITER $$
CREATE PROCEDURE getAllCaptcha ()
BEGIN
	SELECT * FROM CAPTCHA;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getAllCategories;
DELIMITER $$
CREATE PROCEDURE `getAllCategories`()
BEGIN
	SELECT * FROM SOUVENIR_CATEGORIES;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getAllSouvenirs;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getAllSouvenirs`()
BEGIN
	SELECT * FROM SOUVENIRS;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getCaptchaById;
DELIMITER $$
CREATE PROCEDURE getCaptchaById (IN captcha_idIN int(11))
BEGIN
	SELECT * FROM CAPTCHA WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getCategoryById;
DELIMITER $$
CREATE PROCEDURE `getCategoryById` (IN souvenir_category_idIN INT(11))
BEGIN
	SELECT * FROM SOUVENIR_CATEGORIES sc
	WHERE sc.souvenir_category_id = souvenir_category_idIN;
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getCategoryByNameLike;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getCategoryByNameLike`(IN souvenir_categoryIN VARCHAR(50))
BEGIN
	SELECT *
	FROM SOUVENIR_CATEGORIES sc
	WHERE sc.souvenir_category LIKE souvenir_categoryIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getLastAddedCategoryIdgetLastAddedCategoryId;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedCategoryIdgetLastAddedCategoryId`()
BEGIN
	SELECT MAX(souvenir_category_id)
  FROM SOUVENIR_CATEGORIES;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getLastAddedSouvenir;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE souvenir.`getLastAddedSouvenir`()
BEGIN
	SELECT s.*
  FROM souvenirs s
  ORDER BY s.souvenir_id DESC
  limit 1;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getLastAddedSouvenirId;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `getLastAddedSouvenirId`(INOUT lastID INT)
BEGIN
	SELECT MAX(souvenir_id) INTO lastID
  FROM SOUVENIRS;
END$$
DELIMITER ;

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

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotoById`(IN souvenir_photo_idIN INT(11))
BEGIN
	SELECT *
    FROM souvenir_photos
    WHERE souvenir_photo_id = souvenir_photo_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getSouvenirPhotosAll;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotosAll`()
BEGIN
	select *
    from souvenir_photos sp;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getSouvenirPhotosByPath;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotosByPath`(IN souvenir_photo_pathIN varchar(255))
BEGIN
	select *
    from souvenir_photos sp
    where sp.souvenir_photo_path = souvenir_photo_pathIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.getSouvenirPhotosBySouvenirId;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSouvenirPhotosBySouvenirId`(IN souvenir_photo_souvenir_idIN int(11))
BEGIN
    SELECT *
    FROM souvenir_photos
    WHERE souvenir_photo_souvenir_id = souvenir_photo_souvenir_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.hideShowSouvenir;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `hideShowSouvenir`(IN souvenir_idIN int(11))
BEGIN
	UPDATE souvenir.souvenirs SET souvenir_show = !souvenir_show WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.insertCaptcha;
DELIMITER $$
CREATE PROCEDURE insertCaptcha (IN captcha_valueIN varchar(10), IN captcha_url_fileIN varchar(255))
BEGIN
	INSERT INTO CAPTCHA(captcha_value, captcha_url_file) VALUES(captcha_valueIN, captcha_url_fileIN);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.insertCategory;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `insertCategory`(IN souvenir_categoryIN varchar(50))
BEGIN
  INSERT INTO SOUVENIR_CATEGORIES(souvenir_category) VALUES(souvenir_categoryIN);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.insertMessage;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `insertMessage`(IN message_nameIN VARCHAR(50), IN message_emailIN VARCHAR(50), IN message_text_mIN TEXT, IN message_captcha_idIN INT(11))
BEGIN
	INSERT INTO MESSAGE(message_name, message_email, message_text_m, message_captcha_id) 
    VALUES(message_nameIN, message_emailIN, message_text_mIN, message_captcha_idIN);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOrUpdateSouvenirMainPhotoId`(IN souvenir_main_photo_idIN INT(11), IN souvenir_idIN INT(11))
BEGIN
	UPDATE souvenirs SET souvenir_main_photo_id = souvenir_main_photo_idIN WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.insertSouvenirPhoto;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSouvenirPhoto`(IN souvenir_photo_pathIN VARCHAR(255), IN souvenir_photo_souvenir_idIN INT(11))
BEGIN
	INSERT INTO souvenir_photos(souvenir_photo_path, souvenir_photo_souvenir_id)
    VALUES (souvenir_photo_pathIN, souvenir_photo_souvenir_idIN);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.insertSouvenirs;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `insertSouvenirs`(IN souvenir_nameIN VARCHAR(50),
 									IN souvenir_descriptionIN VARCHAR(255), IN souvenir_showIN TINYINT(1), IN souvenir_main_photo_idIN int(11),
									IN souvenir_category_idIN INT(11), IN souvenir_priceIN DECIMAL(8,2), IN souvenir_count_of_days_for_orderIN INT(11))
BEGIN
  INSERT INTO SOUVENIRS(souvenir_name, souvenir_description, souvenir_show, souvenir_main_photo_id,
                        souvenir_category_id, souvenir_price, souvenir_count_of_days_for_order)
  VALUES(souvenir_nameIN, souvenir_descriptionIN, souvenir_showIN, souvenir_main_photo_idIN,
          souvenir_category_idIN, souvenir_priceIN, souvenir_count_of_days_for_orderIN);
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.selectAllSouvenirs;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectAllSouvenirs`()
BEGIN
	SELECT * FROM FULL_SELECT_SOUVENIRS;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.selectFullSouvenirWithCategoryAndAudit;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectFullSouvenirWithCategoryAndAudit`()
BEGIN

SELECT s.*, sa.created_datetime, sa.last_update_datetime, sc.souvenir_category
FROM SOUVENIRS s INNER JOIN SOUVENIRS_AUDIT sa ON s.souvenir_id = sa.souvenir_id
INNER JOIN SOUVENIR_CATEGORIES sc ON s.souvenir_category_id =  sc.souvenir_category_id;

END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.selectSouvenir;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `selectSouvenir`(IN souvenir_idIN int(11))
BEGIN
	SELECT * FROM FULL_SELECT_SOUVENIRS WHERE souvenir_id = souvenir_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.updateCaptcha;
DELIMITER $$
CREATE PROCEDURE updateCaptcha (IN captcha_idIN int(11), IN captcha_valueIN varchar(10), IN captcha_url_fileIN varchar(255))
BEGIN
	UPDATE CAPTCHA SET captcha_value = captcha_valueIN, captcha_url_file = captcha_url_fileIN WHERE captcha_id = captcha_idIN;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS souvenir.updateCategory;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` PROCEDURE `updateCategory`(IN souvenir_categoryIN varchar(50), IN souvenir_category_idIN int(11))
BEGIN
  UPDATE SOUVENIR_CATEGORIES SET souvenir_category = souvenir_categoryIN
  WHERE souvenir_category_id = souvenir_category_idIN;
END$$
DELIMITER ;

/*insert captcha*/
CALL `souvenir`.`checkCaptcha`(3, '1e345t$');

CALL `souvenir`.`insertCaptcha`('192frt$', '/resources/images/captcha/i1.png');
CALL `souvenir`.`insertCaptcha`('1e345t$', '/resources/images/captcha/i2.png');
CALL `souvenir`.`insertCaptcha`('ifhn846', '/resources/images/captcha/i3.png');
CALL `souvenir`.`insertCaptcha`('85235jj', '/resources/images/captcha/i4.png');
CALL `souvenir`.`insertCaptcha`('kjfiptd', '/resources/images/captcha/i5.png');
CALL `souvenir`.`insertCaptcha`('of4965j', '/resources/images/captcha/i6.png');
CALL `souvenir`.`insertCaptcha`('FJ40J4I', '/resources/images/captcha/i7.png');
CALL `souvenir`.`insertCaptcha`('jkJK98i', '/resources/images/captcha/i8.png');
CALL `souvenir`.`insertCaptcha`('orkj403', '/resources/images/captcha/i9.png');
CALL `souvenir`.`insertCaptcha`('93535Ip', '/resources/images/captcha/i10.png');
CALL `souvenir`.`insertCaptcha`('12345', '/resources/images/captcha/i11.png');
CALL `souvenir`.`insertCaptcha`('83f46', '/resources/images/captcha/i12.png');
CALL `souvenir`.`insertCaptcha`('82f4T', '/resources/images/captcha/i13.png');
CALL `souvenir`.`insertCaptcha`('0.5834', '/resources/images/captcha/i14.png');
CALL `souvenir`.`insertCaptcha`('52659', '/resources/images/captcha/i15.png');
CALL `souvenir`.`insertCaptcha`('ifhvno', '/resources/images/captcha/i16.png');
CALL `souvenir`.`insertCaptcha`('ifhO', '/resources/images/captcha/i17.png');
CALL `souvenir`.`insertCaptcha`('po,djr3', '/resources/images/captcha/i18.png');
CALL `souvenir`.`insertCaptcha`('0..692P', '/resources/images/captcha/i19.png');


/*insert souvenir category*/
CALL `souvenir`.`insertCategory`('Бижу из бисера');/*1*/
CALL `souvenir`.`insertCategory`('Бижу из проволки');/*2*/
CALL `souvenir`.`insertCategory`('Букуты из конфет');/*3*/
CALL `souvenir`.`insertCategory`('Канзаши');/*4*/
CALL `souvenir`.`insertCategory`('Свадебные бокалы');/*5*/
CALL `souvenir`.`insertCategory`('Без категории');/*6*/
CALL `souvenir`.`insertCategory`('Серьги');/*7*/

CALL `souvenir`.`insertCategory`('Category 6');
CALL `souvenir`.`updateCategory`('Category 999', 8);
CALL `souvenir`.`deleteCategoryById`(8);

/*
insert souvenir
souvenir_nameIN, souvenir_descriptionIN, souvenir_showIN, souvenir_main_photo_idIN, souvenir_category_idIN,
souvenir_priceIN, souvenir_count_of_days_for_orderIN
*/
/*1*/call insertSouvenirs('Бежевые свадебные бокалы', 'Бежевые свадебные бокалы', 1, null, 5, 193, 2);
/*2*/call insertSouvenirs('Бижу - Линия', 'Это Бижу Линия. Белая, желтая. Шарики', 1, null, 1, 120.96, 9);
/*3*/call insertSouvenirs('Бижу - Заколка', 'Заколка', 0, null, 1, 360.6, 3);
/*4*/call insertSouvenirs('Серьги', 'Серьги', 1, null, 7, 250, 4);
/*5*/call insertSouvenirs('Сувенир - бабочка', 'Сувенир - бабочка', 1, null, 1, 300, 7);
/*6*/call insertSouvenirs('Сувенир - меч', 'Сувенир - меч', 1, null, 2, 130, 4);
/*7*/call insertSouvenirs('Цветок - звезда', 'Цветок - звезда', 1, null, 6, 130, 4);


CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpg', 1);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Браслет - Линия/photo_1_06042016_121008471.JPG', 2);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Заколка/photo_1_06042016_121424815.JPG', 3);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Серьги/photo_1_06042016_122934986.JPG', 4);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Сувенир - бабочка/photo_1_06042016_121838571.JPG', 5);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Сувенир - меч/photo_1_12042016_094828387.png', 6);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Цветок - звезда/photo_1_17042016_131528387.jpg', 7);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Цветок - звезда/photo_2_17042016_131529387.jpg', 7);
CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Цветок - звезда/photo_3_17042016_131531387.jpg', 7);

call insertOrUpdateSouvenirMainPhotoId(1, 1);
call insertOrUpdateSouvenirMainPhotoId(2, 2);
call insertOrUpdateSouvenirMainPhotoId(3, 3);
call insertOrUpdateSouvenirMainPhotoId(4, 4);
call insertOrUpdateSouvenirMainPhotoId(5, 5);
call insertOrUpdateSouvenirMainPhotoId(6, 6);
call insertOrUpdateSouvenirMainPhotoId(7, 7);

call insertSouvenirs('Souvenir #3', 'This is souvenir #3 is description', 1, null, 1, 100.5, 8);
call insertSouvenirs('Souvenir #4', 'This is souvenir #4 is description', 0, null, 2, 500.10, 9);
call insertSouvenirs('Souvenir #5', 'This is souvenir #5 is description', 1, null, 5, 1931, 8);
call insertSouvenirs('Korona #1', 'This is korona is description', 1, null, 1, 20, 2);
call insertSouvenirs('Seriga#2', 'This is souvenir #2 is description', 0, null, 5, 360.6, 6);
call insertSouvenirs('Cepi#3', 'This is souvenir #3 is description', 1, null, 1, 100.5, 12);
call insertSouvenirs('Souvenir #20', 'This is souvenir #4 is description', 0, null, 2, 500.10, 14);
call insertSouvenirs('Bezdelushka', 'This is souvenir #5 is description', 1, null, 5, 1931, 5);
call insertSouvenirs('Zolotaya Korona #1', 'This is korona is description', 1, null, 1, 20, 2);
call insertSouvenirs('Serebryannaya Seriga#2', 'This is souvenir #2 is description', 0, null, 5, 360.6, 6);
call insertSouvenirs('Tolstaya Cepi#3', 'This is souvenir #3 is description', 1, null, 1, 100.5, 12);
call insertSouvenirs('Bronzovyi Souvenir #19', 'This is souvenir #4 is description', 0, null, 2, 500.10, 14);
call insertSouvenirs('Bezdelushka iz alyuminiya', 'This is souvenir #5 is description', 1, null, 5, 1931, 5);


		/*functions*/
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` FUNCTION `getMaxIdCaptcha`() RETURNS int(11)
BEGIN
	DECLARE maxIdCaptcha int;
	SELECT Max(c.captcha_id) into maxIdCaptcha from CAPTCHA c;
	RETURN maxIdCaptcha;
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdated;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` FUNCTION `souvenirIsUpdated`(souvenir_idIN int(11)) RETURNS varchar(5) CHARSET utf8
BEGIN

DECLARE isUpdated VARCHAR(5);
  DECLARE created_datetimeL datetime;
  DECLARE last_update_datetimeL datetime;

  SELECT created_datetime, last_update_datetime INTO created_datetimeL, last_update_datetimeL
  FROM SOUVENIRS_AUDIT sa
  where sa.souvenir_id = souvenir_idIN;

  IF created_datetimeL = last_update_datetimeL
  THEN SET isUpdated = 'false';
  ELSE SET isUpdated = 'true';
  END IF;

	RETURN isUpdated;

END$$
DELIMITER ;


DROP FUNCTION IF EXISTS souvenir.souvenirIsUpdatedV2;
DELIMITER $$
CREATE DEFINER=`souvenir`@`localhost` FUNCTION souvenir.`souvenirIsUpdatedV2`(souvenir_idIN int(11)) RETURNS VARCHAR(5) CHARSET utf8
BEGIN
  DECLARE isUpdated VARCHAR(5);
  DECLARE created_datetimeL datetime;
  
  SELECT created_datetime INTO created_datetimeL
  FROM SOUVENIRS_AUDIT sa
  WHERE sa.created_datetime = sa.last_update_datetime AND sa.souvenir_id = souvenir_idIN;
  
  IF created_datetimeL is null
  THEN SET isUpdated = 'true';
  ELSE SET isUpdated = 'false';
  END IF;
  
	RETURN isUpdated;
END$$
DELIMITER ;

/*delete from souvenirs_audit;

insert into souvenirs_audit values(1, now(), now());
insert into souvenirs_audit values(2, now(), now() + 1);

select souvenirIsUpdated(1);
select souvenirIsUpdatedV2(1);*/

