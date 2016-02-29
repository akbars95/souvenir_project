package com.mtsmda.souvenir.helper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

public class SouvenirStandardSPHelper {

	public static CallableStatement execute(DataSource dataSource, String storedProcedureName,
			Map<String, Object> mapParam, boolean isFunction) throws SQLException {
		Connection connection = dataSource.getConnection();
		StringBuilder query = new StringBuilder("{");
		if (isFunction) {
			query.append("? = ");
		}

		query.append("call ").append(storedProcedureName).append("(");
		if (mapParam != null) {
			for (int i = 0; i < mapParam.size(); i++) {
				query.append("?");
				if (i != mapParam.size() - 1) {
					query.append(",");
				}
			}
		}
		query.append(")}");

		CallableStatement callableStatement = connection.prepareCall(query.toString());
		if (isFunction) {

		}
		if (mapParam != null) {
			for (String key : mapParam.keySet()) {
				Object value = mapParam.get(key);
				getRightType(callableStatement, key, value);
			}
		}
		return callableStatement;
	}

	private static void getRightType(CallableStatement callableStatement, String key, Object value)
			throws SQLException {
		if (value instanceof String) {
			callableStatement.setString(key, value.toString());
		} else if (value instanceof Integer) {
			Integer ii = Integer.parseInt(value.toString());
			callableStatement.setInt(key, ii);
		} else if (value instanceof Long) {
			callableStatement.setLong(key, Long.parseLong(value.toString()));
		} else if (value instanceof Boolean) {
			callableStatement.setBoolean(key, Boolean.parseBoolean(value.toString()));
		} else if (value instanceof Date) {
			callableStatement.setDate(key, ((java.sql.Date) value));
		} else if (value instanceof Float) {
			callableStatement.setFloat(key, Float.parseFloat(value.toString()));
		} else if (value instanceof Double) {
			callableStatement.setDouble(key, Double.parseDouble(value.toString()));
		}
	}

}