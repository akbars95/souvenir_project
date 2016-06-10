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
  `souvenir_main_photo_id` int(11) DEFAULT NULL,
  `souvenir_category_id` int(11) DEFAULT NULL,
  `souvenir_price` decimal(8,2) DEFAULT NULL,
  `souvenir_count_of_days_for_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`souvenir_id`),
  UNIQUE KEY `souvenir_name_UNIQUE` (`souvenir_name`),
  KEY `souvenir_category_id_souvenir_id_idx` (`souvenir_category_id`),
  CONSTRAINT `souvenir_category_id_souvenir_id` FOREIGN KEY (`souvenir_category_id`) REFERENCES `souvenir_categories` (`souvenir_category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



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
  PRIMARY KEY (`captcha_id`),
  UNIQUE KEY `captcha_value_UNIQUE` (`captcha_value`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

CREATE TABLE `VALUTE` (
  `valute_id` int(11) NOT NULL AUTO_INCREMENT,
  `valute_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `valute_code` int(11) DEFAULT NULL,
  `valute_char_code` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `valute_nominal` int(11) DEFAULT NULL,
  `valute_symbol` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`valute_id`),
  UNIQUE KEY `valute_id_UNIQUE` (`valute_id`),
  UNIQUE KEY `valute_name_UNIQUE` (`valute_name`),
  UNIQUE KEY `valute_code_UNIQUE` (`valute_code`),
  UNIQUE KEY `valute_char_code_UNIQUE` (`valute_char_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `EXCHANGE_RATE` (
  `exchange_rate_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `exchange_rate_date` date DEFAULT NULL,
  `valute_name_id` int(11) DEFAULT NULL,
  `exchange_rate` decimal(9,4) DEFAULT NULL,
  PRIMARY KEY (`exchange_rate_id`),
  UNIQUE KEY `exchange_rate_id_UNIQUE` (`exchange_rate_id`),
  UNIQUE KEY `exchange_rate_date_UNIQUE` (`exchange_rate_date`),
  KEY `exchange_rate_valute_valute_id_idx` (`valute_name_id`),
  CONSTRAINT `exchange_rate_valute_valute_id` FOREIGN KEY (`valute_name_id`) REFERENCES `valute` (`valute_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


/***/
CREATE TABLE `country` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(50) NOT NULL,
  PRIMARY KEY (`countryId`),
  UNIQUE KEY `countryId_UNIQUE` (`countryId`),
  UNIQUE KEY `countryName_UNIQUE` (`countryName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(50) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`cityId`),
  UNIQUE KEY `cityId_UNIQUE` (`cityId`),
  UNIQUE KEY `cityName_UNIQUE` (`cityName`),
  KEY `city_country_id_fk_idx` (`country_id`),
  CONSTRAINT `city_country_id_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`countryId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `villageName` varchar(50) DEFAULT NULL,
  `streetName` varchar(50) DEFAULT NULL,
  `houseNumber` varchar(50) DEFAULT NULL,
  `flatNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`addressId`),
  UNIQUE KEY `addressId_UNIQUE` (`addressId`),
  KEY `address_city_id_fk_idx` (`city_id`),
  CONSTRAINT `address_city_id_fk` FOREIGN KEY (`city_id`) REFERENCES `city` (`cityId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `phone_address_type` (
  `phoneAddressTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `phoneAddressType` varchar(50) NOT NULL,
  PRIMARY KEY (`phoneAddressTypeId`),
  UNIQUE KEY `phoneAddressTypeId_UNIQUE` (`phoneAddressTypeId`),
  UNIQUE KEY `phoneAddressType_UNIQUE` (`phoneAddressType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `phone` (
  `phoneId` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(50) NOT NULL,
  `phoneAddressTypeId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`phoneId`,`userId`),
  UNIQUE KEY `phoneId_UNIQUE` (`phoneId`),
  UNIQUE KEY `phoneNumber_UNIQUE` (`phoneNumber`),
  KEY `phone_phoneAddressTypeId_fk_idx` (`phoneAddressTypeId`),
  KEY `phone_userId_fk_idx` (`userId`),
  CONSTRAINT `phone_phoneAddressTypeId_fk` FOREIGN KEY (`phoneAddressTypeId`) REFERENCES `phone_address_type` (`phoneAddressTypeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `phone_userId_fk` FOREIGN KEY (`userId`) REFERENCES `users` (`username_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
