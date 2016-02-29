CALL `souvenir`.`insertCategory`('Category 1');
CALL `souvenir`.`insertCategory`('Category 2');
CALL `souvenir`.`insertCategory`('Category 3');
CALL `souvenir`.`insertCategory`('Category 4');
CALL `souvenir`.`insertCategory`('Category 5');

CALL `souvenir`.`insertCategory`('Category 6');
CALL `souvenir`.`updateCategory`('Category 999', 6);
CALL `souvenir`.`deleteCategoryById`(6);

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


call insertSouvenirs('Souvenir #1', 'This is souvenir #1 is description', 1, 'souvenir path', 1, 120.96, 9);
call insertSouvenirs('Souvenir #2', 'This is souvenir #2 is description', 0, 'souvenir path', 5, 360.6, 3);
call insertSouvenirs('Souvenir #3', 'This is souvenir #3 is description', 1, 'souvenir path', 1, 100.5, 8);
call insertSouvenirs('Souvenir #4', 'This is souvenir #4 is description', 0, 'souvenir path', 2, 500.10, 9);
call insertSouvenirs('Souvenir #5', 'This is souvenir #5 is description', 1, 'souvenir path', 5, 1931, 8);


call insertSouvenirs('Korona #1', 'This is korona is description', 1, 'souvenir path for korona', 1, 20, 2);
call insertSouvenirs('Seriga#2', 'This is souvenir #2 is description', 0, 'souvenir path', 5, 360.6, 6);
call insertSouvenirs('Cepi#3', 'This is souvenir #3 is description', 1, 'souvenir path', 1, 100.5, 12);
call insertSouvenirs('Souvenir #20', 'This is souvenir #4 is description', 0, 'souvenir path', 2, 500.10, 14);
call insertSouvenirs('Bezdelushka', 'This is souvenir #5 is description', 1, 'souvenir path', 5, 1931, 5);

insertSouvenirs('Zolotaya Korona #1', 'This is korona is description', 1, 'souvenir path for korona', 1, 20, 2);
call insertSouvenirs('Serebryannaya Seriga#2', 'This is souvenir #2 is description', 0, 'souvenir path', 5, 360.6, 6);
call insertSouvenirs('Tolstaya Cepi#3', 'This is souvenir #3 is description', 1, 'souvenir path', 1, 100.5, 12);
call insertSouvenirs('Bronzovyi Souvenir #19', 'This is souvenir #4 is description', 0, 'souvenir path', 2, 500.10, 14);
call insertSouvenirs('Bezdelushka iz alyuminiya', 'This is souvenir #5 is description', 1, 'souvenir path', 5, 1931, 5);