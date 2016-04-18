CREATE ALGORITHM=UNDEFINED DEFINER=`souvenir`@`localhost` SQL SECURITY DEFINER VIEW `FULL_SELECT_SOUVENIRS` AS
SELECT `s`.`souvenir_id` AS `souvenir_id`,`s`.`souvenir_name` AS `souvenir_name`,`s`.`souvenir_description` AS `souvenir_description`,
`s`.`souvenir_show` AS `souvenir_show`,`s`.`souvenir_main_photo_id` AS `souvenir_main_photo_id`,
`s`.`souvenir_category_id` AS `souvenir_category_id`,`s`.`souvenir_price` AS `souvenir_price`,
`s`.`souvenir_count_of_days_for_order` AS `souvenir_count_of_days_for_order`,`sc`.`souvenir_category` AS `souvenir_category`
FROM (`SOUVENIRS` `s` JOIN `SOUVENIR_CATEGORIES` `sc` on((`s`.`souvenir_category_id` = `sc`.`souvenir_category_id`)));