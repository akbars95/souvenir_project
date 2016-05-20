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
SET @souvenirCategoryBijuIzBisera = 'Бижу из бисера',
    @souvenirCategoryBijuIzProvolki = 'Бижу из проволки',
    @souvenirCategoryBuketyIzKonfet = 'Букуты из конфет',
    @souvenirCategoryKanzashi = 'Канзаши',
    @souvenirCategorySvadebnyeBokaly = 'Свадебные бокалы',
    @souvenirCategoryNoCategory = 'Без категории',
    @souvenirCategorySerigi = 'Серьги';

CALL `souvenir`.`insertCategory`(@souvenirCategoryBijuIzBisera);/*1*/
CALL `souvenir`.`insertCategory`(@souvenirCategoryBijuIzProvolki);/*2*/
CALL `souvenir`.`insertCategory`(@souvenirCategoryBuketyIzKonfet);/*3*/
CALL `souvenir`.`insertCategory`(@souvenirCategoryKanzashi);/*4*/
CALL `souvenir`.`insertCategory`(@souvenirCategorySvadebnyeBokaly);/*5*/
CALL `souvenir`.`insertCategory`(@souvenirCategoryNoCategory);/*6*/
CALL `souvenir`.`insertCategory`(@souvenirCategorySerigi);/*7*/

CALL `souvenir`.`insertCategory`('Category 6');
CALL `souvenir`.`updateCategory`('Category 999', 8);
CALL `souvenir`.`deleteCategoryById`(8);

/*
insert souvenir
souvenir_nameIN, souvenir_descriptionIN, souvenir_showIN, souvenir_main_photo_idIN, souvenir_category_idIN,
souvenir_priceIN, souvenir_count_of_days_for_orderIN
*/
SET @souvenirBejevyeSvadednyeBokaly = 'Бежевые свадебные бокалы',
    @souvenirBijuLiniya = 'Бижу - Линия',
    @souvenirBijuZakolka = 'Бижу - Заколка',
    @souvenirSerigi = 'Серьги',
    @souvenirBabocka = 'Сувенир - бабочка',
    @souvenirMec = 'Сувенир - меч',
    @souvenirCvetokZvezda = 'Цветок - звезда';
/*1*/call insertSouvenirsWithSelectInto(@souvenirBejevyeSvadednyeBokaly, 'Бежевые свадебные бокалы', 1, null, @souvenirCategorySvadebnyeBokaly, 193, 2);
/*2*/call insertSouvenirsWithSelectInto(@souvenirBijuLiniya, 'Это Бижу Линия. Белая, желтая. Шарики', 1, null, @souvenirCategoryBijuIzBisera, 120.96, 9);
/*3*/call insertSouvenirsWithSelectInto(@souvenirBijuZakolka, 'Заколка', 0, null, @souvenirCategoryBijuIzBisera, 360.6, 3);
/*4*/call insertSouvenirsWithSelectInto(@souvenirSerigi, 'Серьги', 1, null, @souvenirCategorySerigi, 250, 4);
/*5*/call insertSouvenirsWithSelectInto(@souvenirBabocka, 'Сувенир - бабочка', 1, null, @souvenirCategoryBijuIzBisera, 300, 7);
/*6*/call insertSouvenirsWithSelectInto(@souvenirMec, 'Сувенир - меч', 1, null, @souvenirCategoryBijuIzProvolki, 130, 4);
/*7*/call insertSouvenirsWithSelectInto(@souvenirCvetokZvezda, 'Цветок - звезда', 1, null, @souvenirCategoryNoCategory, 130, 4);

SET @souvenirBejevyeSvadednyeBokalyPhoto = '/images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpg',
    @souvenirBijuLiniyaPhoto = '/images/souvenirs/Браслет - Линия/photo_1_06042016_121008471.JPG',
    @souvenirBijuZakolkaPhoto = '/images/souvenirs/Заколка/photo_1_06042016_121424815.JPG',
    @souvenirSerigiPhoto = '/images/souvenirs/Серьги/photo_1_06042016_122934986.JPG',
    @souvenirBabockaPhoto = '/images/souvenirs/Сувенир - бабочка/photo_1_06042016_121838571.JPG',
    @souvenirMecPhoto = '/images/souvenirs/Сувенир - меч/photo_1_12042016_094828387.png',
    @souvenirCvetokZvezdaPhoto1 = '/images/souvenirs/Цветок - звезда/photo_1_17042016_131528387.jpg',
    @souvenirCvetokZvezdaPhoto2 = '/images/souvenirs/Цветок - звезда/photo_2_17042016_131529387.jpg',
    @souvenirCvetokZvezdaPhoto3 = '/images/souvenirs/Цветок - звезда/photo_3_17042016_131531387.jpg';

CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirBejevyeSvadednyeBokalyPhoto, @souvenirBejevyeSvadednyeBokaly);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirBijuLiniyaPhoto, @souvenirBijuLiniya);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirBijuZakolkaPhoto, @souvenirBijuZakolka);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirSerigiPhoto, @souvenirSerigi);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirBabockaPhoto, @souvenirBabocka);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirMecPhoto, @souvenirMec);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirCvetokZvezdaPhoto1, @souvenirCvetokZvezda);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirCvetokZvezdaPhoto2, @souvenirCvetokZvezda);
CALL `souvenir`.`insertSouvenirPhotoWithSelectInto`(@souvenirCvetokZvezdaPhoto3, @souvenirCvetokZvezda);

CALL `souvenir`.`insertOrUpdateSouvenirMainPhotoIdWithSelectInto`(@souvenirBejevyeSvadednyeBokalyPhoto, @souvenirBejevyeSvadednyeBokaly);
CALL `souvenir`.`insertOrUpdateSouvenirMainPhotoIdWithSelectInto`(@souvenirBijuLiniyaPhoto, @souvenirBijuLiniya);
CALL `souvenir`.`insertOrUpdateSouvenirMainPhotoIdWithSelectInto`(@souvenirBijuZakolkaPhoto, @souvenirBijuZakolka);
CALL `souvenir`.`insertOrUpdateSouvenirMainPhotoIdWithSelectInto`(@souvenirSerigiPhoto, @souvenirSerigi);
CALL `souvenir`.`insertOrUpdateSouvenirMainPhotoIdWithSelectInto`(@souvenirBabockaPhoto, @souvenirBabocka);
CALL `souvenir`.`insertOrUpdateSouvenirMainPhotoIdWithSelectInto`(@souvenirMecPhoto, @souvenirMec);

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


/*insert valutes*/
CALL `souvenir`.`insertValute`('Euro', 978, 'EUR', 1, '€');
CALL `souvenir`.`insertValute`('Dollar S.U.A.', 840, 'USD', 1, '$');
CALL `souvenir`.`insertValute`('Rubl rus', 643, 'RUB', 1, '₽');
CALL `souvenir`.`insertValute`('Mold lei', 498, 'MDL', 1, 'MDL');




/*
old version
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpg', 1);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Браслет - Линия/photo_1_06042016_121008471.JPG', 2);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Заколка/photo_1_06042016_121424815.JPG', 3);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Серьги/photo_1_06042016_122934986.JPG', 4);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Сувенир - бабочка/photo_1_06042016_121838571.JPG', 5);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Сувенир - меч/photo_1_12042016_094828387.png', 6);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Цветок - звезда/photo_1_17042016_131528387.jpg', 7);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Цветок - звезда/photo_2_17042016_131529387.jpg', 7);
    CALL `souvenir`.`insertSouvenirPhoto`('/images/souvenirs/Цветок - звезда/photo_3_17042016_131531387.jpg', 7);
*/


/* old
call insertOrUpdateSouvenirMainPhotoId(1, 1);
call insertOrUpdateSouvenirMainPhotoId(2, 2);
call insertOrUpdateSouvenirMainPhotoId(3, 3);
call insertOrUpdateSouvenirMainPhotoId(4, 4);
call insertOrUpdateSouvenirMainPhotoId(5, 5);
call insertOrUpdateSouvenirMainPhotoId(6, 6);
call insertOrUpdateSouvenirMainPhotoId(7, 7);
*/

/*
CALL `souvenir`.`insertCategory`('Бижу из бисера');/*1*/
CALL `souvenir`.`insertCategory`('Бижу из проволки');/*2*/
CALL `souvenir`.`insertCategory`('Букуты из конфет');/*3*/
CALL `souvenir`.`insertCategory`('Канзаши');/*4*/
CALL `souvenir`.`insertCategory`('Свадебные бокалы');/*5*/
CALL `souvenir`.`insertCategory`('Без категории');/*6*/
CALL `souvenir`.`insertCategory`('Серьги');/*7*/
*/

/*
old
call insertSouvenirs(@souvenirBejevyeSvadednyeBokaly, 'Бежевые свадебные бокалы', 1, null, 5, 193, 2);
call insertSouvenirs(@souvenirBijuLiniya, 'Это Бижу Линия. Белая, желтая. Шарики', 1, null, 1, 120.96, 9);
call insertSouvenirs(@souvenirBijuZakolka, 'Заколка', 0, null, 1, 360.6, 3);
call insertSouvenirs(@souvenirSerigi, 'Серьги', 1, null, 7, 250, 4);
call insertSouvenirs(@souvenirBabocka, 'Сувенир - бабочка', 1, null, 1, 300, 7);
call insertSouvenirs(@souvenirMec, 'Сувенир - меч', 1, null, 2, 130, 4);
call insertSouvenirs(@souvenirCvetokZvezda, 'Цветок - звезда', 1, null, 6, 130, 4);
*/