package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard;

import com.mtsmda.souvenir.model.Valute;
import com.mtsmda.souvenir.spring.stereotype.repository.ValuteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by dminzat on 5/24/2016.
 */
@Repository("valuteRepository")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class ValuteRepositoryImplSPJavaStandard implements ValuteRepository{

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Override
    @Transactional
    public boolean insertValute(Valute valute) {
        /*if (valute == null) {
            throw new SouvenirRuntimeException("insertCaptcha - captcha object is NULL");
        }
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(CAPTCHA_VALUE_IN_SP_PARAM_NAME, captcha.getCaptchaValue());
        mapParam.put(CAPTCHA_URL_FILE_IN_SP_PARAM_NAME, captcha.getCaptchaUrlFile());

        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     INSERT_CAPTCHA_SP_NAME, mapParam, false);) {
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertCaptcha", e);
        }*/
        return false;
    }

    @Override
    public boolean updateValute(Valute valute) {
        return false;
    }

    @Override
    public boolean deleteValute(Valute valute) {
        return false;
    }

    @Override
    public boolean getValuteById(Integer valuteId) {
        return false;
    }

    @Override
    public boolean getValutes() {
        return false;
    }
}
