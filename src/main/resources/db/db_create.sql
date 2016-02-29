DROP DATABASE IF EXISTS souvenir;
DROP USER IF EXISTS 'souvenir'@'localhost';

CREATE DATABASE IF NOT EXISTS souvenir CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'souvenir'@'localhost' IDENTIFIED BY 'souvenir12345';
GRANT ALL PRIVILEGES ON souvenir. * TO 'souvenir'@'localhost';