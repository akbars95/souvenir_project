/*
CALL `souvenir`.`insertCategory`('Category 1');
CALL `souvenir`.`insertCategory`('Category 2');
CALL `souvenir`.`insertCategory`('Category 3');
CALL `souvenir`.`insertCategory`('Category 4');
CALL `souvenir`.`insertCategory`('Category 5');

CALL `souvenir`.`insertCategory`('Category 6');
CALL `souvenir`.`updateCategory`('Category 999', 6);
CALL `souvenir`.`deleteCategoryById`(6);
*/
CALL `souvenir`.`getAllCategories`();
CALL `souvenir`.`getCategoryById`(3);

CALL `souvenir`.`getCategoryByNameLike`('%tego%');
CALL `souvenir`.`getCategoryByNameLike`('_a%');
CALL `souvenir`.`getCategoryByNameLike`('% 2');
CALL `souvenir`.`getCategoryByNameLike`('%gf% or \'a\' = \'a\'');

CALL `souvenir`.`getLastAddedCategoryId`();



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


