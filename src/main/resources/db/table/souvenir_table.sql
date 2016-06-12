use souvenir;

/*drop table if exists `user_roles`;*/
drop table if exists `SOUVENIR_CATEGORIES`;
drop table if exists `SOUVENIRS`;
drop table if exists `SOUVENIR_PHOTOS`;
drop table if exists `SOUVENIRS_AUDIT`;
drop table if exists `MESSAGE`;
drop table if exists `CAPTCHA`;
drop table if exists `EXCHANGE_RATE`;
drop table if exists `VALUTE`;
drop table if exists `address`;
drop table if exists `city`;
drop table if exists `country`;
drop table if exists `phone`;
drop table if exists `phone_address_type`;

/**security*/
drop table if exists `user_attempts`;
drop table if exists `persistent_logins`;

drop table if exists `group_authorities`;
drop table if exists `group_members`;
drop table if exists `groups`;
drop table if exists `users`;
drop table if exists `roles`;

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `users` (
  `username_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `passwordC` varchar(60) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonLocked` tinyint(1) NOT NULL DEFAULT '1',
  `credentialsNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `username_id_UNIQUE` (`username_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/*
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `username_role_UNIQUE` (`username`, `role`),
  CONSTRAINT `username_fk` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

CREATE TABLE `user_attempts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username_id` int(11) NOT NULL,
  `attempts` int(11) NOT NULL,
  `lastModified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_attempts_username_id_fk_idx` (`username_id`),
  CONSTRAINT `user_attempts_username_id_fk` FOREIGN KEY (`username_id`) REFERENCES `users` (`username_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `persistent_logins` (
  `username_id` int(11) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` datetime NOT NULL,
  PRIMARY KEY (`series`),
  KEY `persistent_logins_username_id_fk_idx` (`username_id`),
  CONSTRAINT `persistent_logins_username_id_fk` FOREIGN KEY (`username_id`) REFERENCES `users` (`username_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `group_authorities` (
  `group_id` int(11) NOT NULL,
  `authority_role_id` int(11) NOT NULL,
  KEY `group_id_fk_idx` (`group_id`),
  KEY `authority_role_id_fk_idx` (`authority_role_id`),
  CONSTRAINT `authority_role_id_fk` FOREIGN KEY (`authority_role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `group_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id_fk_idx` (`group_id`),
  KEY `username_id_fk_idx` (`username_id`),
  CONSTRAINT `group_members_group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `group_members_username_id_fk` FOREIGN KEY (`username_id`) REFERENCES `users` (`username_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


insert into users (username, passwordC, enabled) values('ivanAdmin1', '$2a$10$Eu79Yr7VrMbieqwUECG./.xyCeWbyxKRnk5uNcw36AtJLdFc/ZqBG', true);
insert into users (username, passwordC, enabled) values('petr5', '$2a$10$8RJBJGsLK8.o6eZhN4dt1eUN1Y1Aln5vRh5ig5EKKyAGqysfnfSfm', true);
insert into users (username, passwordC, enabled) values('kuzima7', '$2a$10$4Oe.89FQcV6kTu4M1k9Py.55P5V8LpFeHbhoh8VVQN5GCGxBbbd0O', true);

/*
insert into user_roles (username, role) values('ivanAdmin1', 'ROLE_ADMIN');
insert into user_roles (username, role) values('ivanAdmin1', 'ROLE_USER');
insert into user_roles (username, role) values('petr5', 'ROLE_USER');
insert into user_roles (username, role) values('kuzima7', 'ROLE_USER');
*/
insert into groups(group_name) values('admin');
insert into groups(group_name) values('user');

insert into roles(role_name) values('ROLE_USER');
insert into roles(role_name) values('ROLE_ADMIN');

insert into group_members(username_id, group_id) values(1, 1);
insert into group_members(username_id, group_id) values(1, 2);
insert into group_members(username_id, group_id) values(2, 2);
insert into group_members(username_id, group_id) values(3, 2);

insert into group_authorities(group_id, authority_role_id) values(2, 1);
insert into group_authorities(group_id, authority_role_id) values(1, 1);
insert into group_authorities(group_id, authority_role_id) values(1, 2);

/**user tables*/

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
