package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.repositoryTest.rowMapper;

import static com.mtsmda.souvenir.model.sp.SouvenirSP.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.model.SouvenirPhoto;

public class SouvenirMapper implements MapperI<Souvenir> {

	public Souvenir mapRow(ResultSet rs) {
		Souvenir souvenir = new Souvenir();
		try {
			souvenir.setSouvenirId(rs.getInt(SOUVENIR_ID));
		} catch (SQLException e) {
			souvenir.setSouvenirId(null);
		}
		try {
			souvenir.setSouvenirName(rs.getString(SOUVENIR_NAME));
		} catch (SQLException e) {
			souvenir.setSouvenirName(null);
		}
		try {
			souvenir.setSouvenirDescription(rs.getString(SOUVENIR_DESCRIPTION));
		} catch (SQLException e) {
			souvenir.setSouvenirDescription(null);
		}
		try {
			souvenir.setSouvenirShow(rs.getBoolean(SOUVENIR_SHOW));
		} catch (SQLException e) {
			souvenir.setSouvenirShow(null);
		}
		try {
			souvenir.setSouvenirMainPhotoId(new SouvenirPhoto(rs.getInt(SOUVENIR_MAIN_PHOTO_ID)));
		} catch (SQLException e) {
			souvenir.setSouvenirMainPhotoId(null);
		}
		try {
			SouvenirCategory souvenirCategory = new SouvenirCategory();
			souvenirCategory.setSouvenirCategoryId(rs.getInt(SOUVENIR_CATEGORY_ID));
			souvenir.setSouvenirCategory(souvenirCategory);
		} catch (SQLException e) {
			souvenir.setSouvenirCategory(null);
		}
		try {
			souvenir.setSouvenirPrice(rs.getDouble(SOUVENIR_PRICE));
		} catch (SQLException e) {
			souvenir.setSouvenirPrice(null);
		}
		try {
			souvenir.setSouvenirCountOfDaysForOrder(rs.getInt(SOUVENIR_COUNT_OF_DAYS_FOR_ORDER));
		} catch (SQLException e) {
			souvenir.setSouvenirCountOfDaysForOrder(null);
		}

		return souvenir;
	}

}