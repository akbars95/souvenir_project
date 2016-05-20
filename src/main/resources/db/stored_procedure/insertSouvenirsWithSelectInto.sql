DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSouvenirsWithSelectInto`(IN souvenir_nameIN VARCHAR(50),
 									IN souvenir_descriptionIN VARCHAR(255), IN souvenir_showIN TINYINT(1), IN souvenir_main_photo_idIN int(11),
									IN souvenir_categoryIN VARCHAR(50), IN souvenir_priceIN DECIMAL(8,2), IN souvenir_count_of_days_for_orderIN INT(11))
BEGIN
  INSERT INTO SOUVENIRS(souvenir_name, souvenir_description, souvenir_show, souvenir_main_photo_id,
                        souvenir_category_id, souvenir_price, souvenir_count_of_days_for_order)
  VALUES(souvenir_nameIN, souvenir_descriptionIN, souvenir_showIN, souvenir_main_photo_idIN,
          (select souvenir_category_id
          from souvenir_categories
          where souvenir_category = souvenir_categoryIN), souvenir_priceIN, souvenir_count_of_days_for_orderIN);
END$$
DELIMITER ;
