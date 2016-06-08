drop table if exists `user_roles`;
drop table if exists `users`;
drop table if exists `user_attempts`;
drop table if exists `persistent_logins`;

drop table if exists `group_authorities`;
drop table if exists `group_members`;
drop table if exists `groups`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `passwordC` varchar(60) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  `accountNonLocked` tinyint(1) NOT NULL DEFAULT '1',
  `credentialsNonExpired` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `username` varchar(50) NOT NULL,
  `attempts` int(11) NOT NULL,
  `lastModified` datetime,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `persistent_logins` (
  `username` varchar(50) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` datetime NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `group_authorities` (
  `group_id` int(11) NOT NULL,
  `authority` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  KEY `group_id_fk_idx` (`group_id`),
  CONSTRAINT `group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `group_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id_fk_idx` (`group_id`),
  CONSTRAINT `group_members_group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

insert into group_members(username, group_id) values('ivanAdmin1', 1);
insert into group_members(username, group_id) values('ivanAdmin1', 2);
insert into group_members(username, group_id) values('petr5', 2);
insert into group_members(username, group_id) values('kuzima7', 2);

insert into group_authorities(group_id, authority) values(2, 'ROLE_USER');
insert into group_authorities(group_id, authority) values(1, 'ROLE_USER');
insert into group_authorities(group_id, authority) values(1, 'ROLE_ADMIN');