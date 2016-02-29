package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;

import static com.mtsmda.souvenir.model.sp.SouvenirSP.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirCategory;

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
			souvenir.setSouvenirPath(rs.getString(SOUVENIR_PATH));
		} catch (SQLException e) {
			souvenir.setSouvenirPath(null);
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