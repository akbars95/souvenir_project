package com.mtsmda.souvenir.repository.impl;

import static com.mtsmda.souvenir.model.sp.CaptchaSP.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.SocketUtils;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.MapHelper;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.model.sp.CaptchaSP;
import com.mtsmda.souvenir.repository.CaptchaRepository;
import com.mtsmda.souvenir.sp.SouvenirStoredProcedure;

@Repository("captchaRepository")
public class CaptchaRepositoryImplSP implements CaptchaRepository {

	@Autowired
	@Qualifier(value = "mySqlDataSource")
	private DataSource dataSource;

	private SouvenirStoredProcedure souvenirStoredProcedure;

	@Override
	public boolean insertCaptcha(Captcha captcha) {
		return true;
	}

	@Override
	public boolean updateCaptcha(Captcha captcha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCaptcha(Captcha captcha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Captcha getCaptchaById(Integer idCaptcha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Captcha> getAllCaptcha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Captcha getRandomCaptcha(Captcha captchaUser) {
		Captcha captcha = new Captcha();
		try {
			List<SqlParameter> sqlParameters = Arrays.asList(CAPTCHA_ID_IN_SP_SQL_PARAM);
			souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, GET_RANDOM_CAPTCHA_SP_NAME,
					sqlParameters);

			List<String> keysList = new ArrayList<>();
			ListHelper.getList(keysList, new String[] { CAPTCHA_ID_IN_SP_PARAM_NAME });
			HashMap<String, Object> stringObjectHashMap = new HashMap<>();
			MapHelper.getMap(stringObjectHashMap, keysList, captchaUser.getCaptchaId());
			Map map = souvenirStoredProcedure.executeSP(stringObjectHashMap);
			Object object = map.get("#result-set-1");
			if (object instanceof List) {
				List<Object> list = (List<Object>) object;
				System.out.println(list.get(0).getClass().getCanonicalName());
				for (Object objectMap : list) {
					Map mapCaptcha = (Map) objectMap;
					for (Object key : mapCaptcha.keySet()) {
						System.out.println(key + "\t\t - " + mapCaptcha.get(key));
						if (key.toString().equals(CaptchaSP.CAPTCHA_ID)) {
							captcha.setCaptchaId(Integer.valueOf(mapCaptcha.get(key).toString()));
						}
						if (key.toString().equals(CaptchaSP.CAPTCHA_URL_FILE)) {
							captcha.setCaptchaUrlFile(mapCaptcha.get(key).toString());
						}
					}
				}
			}
			dataSource.getConnection().commit();
		} catch (Exception e) {
			try {
				dataSource.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SouvenirRuntimeException("Exception when get Random captcha - " + e.getMessage());
		}
		return captcha;
	}

	@Override
	public Integer getMaxIdCaptcha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCaptcha(Captcha captcha) {
		// TODO Auto-generated method stub
		return false;
	}

}