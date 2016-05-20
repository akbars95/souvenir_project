DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOrUpdateSouvenirMainPhotoIdWithSelectInto`(IN souvenir_photo_pathIN VARCHAR(255), 
											IN souvenir_nameIN VARCHAR(50))
BEGIN
	UPDATE souvenirs SET souvenir_main_photo_id = (
		select sp.souvenir_photo_id
        from souvenir_photos sp
        where sp.souvenir_photo_path = souvenir_photo_pathIN
    )
    WHERE souvenir_id = (
        select souvenir_id from (select s.souvenir_id
                                from souvenirs s
                                where s.souvenir_name = souvenir_nameIN
                                ) as innerSouvenirs
    );
END$$
DELIMITER ;
