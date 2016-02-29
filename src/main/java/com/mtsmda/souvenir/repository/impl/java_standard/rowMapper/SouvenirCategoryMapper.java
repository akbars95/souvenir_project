package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;

import static com.mtsmda.souvenir.model.sp.SouvenirCategorySP.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mtsmda.souvenir.model.SouvenirCategory;

public class SouvenirCategoryMapper implements MapperI<SouvenirCategory> {

	@Override
	public SouvenirCategory mapRow(ResultSet rs) {
		SouvenirCategory souvenirCategory = new SouvenirCategory();
		try {
			souvenirCategory.setSouvenirCategoryId(rs.getInt(SOUVENIR_CATEGORY_ID));
		} catch (SQLException e) {
			souvenirCategory.setSouvenirCategoryId(null);
		}
		try {
			souvenirCategory.setSouvenirCategory(rs.getString(SOUVENIR_CATEGORY));
		} catch (SQLException e) {
			souvenirCategory.setSouvenirCategory(null);
		}
		return souvenirCategory;
	}

}