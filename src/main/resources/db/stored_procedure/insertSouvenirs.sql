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
