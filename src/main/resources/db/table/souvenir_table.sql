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

CREATE TABLE `VALUTE` (
  `valute_id` int(11) NOT NULL AUTO_INCREMENT,
  `valute_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `valute_code` int(11) DEFAULT NULL,
  `valute_char_code` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `valute_nominal` int(11) DEFAULT NULL,
  PRIMARY KEY (`valute_id`),
  UNIQUE KEY `valute_id_UNIQUE` (`valute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
