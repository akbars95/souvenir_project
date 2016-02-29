package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mtsmda.souvenir.model.Captcha;

import static com.mtsmda.souvenir.model.sp.CaptchaSP.*;

public class CaptchaMapper implements RowMapper<Captcha>, MapperI<Captcha> {

	@Override
	public Captcha mapRow(ResultSet rs, int rowNum) throws SQLException {
		Captcha captcha = new Captcha();
		captcha.setCaptchaId(rs.getInt(CAPTCHA_ID));
		captcha.setCaptchaUrlFile(rs.getString(CAPTCHA_URL_FILE));
		captcha.setCaptchaValue((rs.getString(CAPTCHA_VALUE) == null) ? null : rs.getString(CAPTCHA_VALUE));
		return captcha;
	}

	@Override
	public Captcha mapRow(ResultSet rs) {
		Captcha captcha = new Captcha();

		try {
			captcha.setCaptchaId(rs.getInt(CAPTCHA_ID));
		} catch (SQLException e) {
			captcha.setCaptchaId(null);
		}
		try {
			captcha.setCaptchaUrlFile(rs.getString(CAPTCHA_URL_FILE));
		} catch (SQLException e) {
			captcha.setCaptchaId(null);
		}
		try {
			captcha.setCaptchaValue(rs.getString(CAPTCHA_VALUE));
		} catch (SQLException e) {
			captcha.setCaptchaValue(null);
		}

		return captcha;
	}

}