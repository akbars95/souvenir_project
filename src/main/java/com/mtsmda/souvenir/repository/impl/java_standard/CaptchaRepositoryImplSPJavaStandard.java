package com.mtsmda.souvenir.repository.impl.java_standard;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.MapHelper;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.repository.CaptchaRepository;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.CaptchaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.souvenir.model.sp.CaptchaSP.*;

/**
 * Created by MTSMDA on 08.02.2016.
 */
@Repository("captchaRepositoryImplSPJavaStandard")
public class CaptchaRepositoryImplSPJavaStandard implements CaptchaRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Override
    public boolean insertCaptcha(Captcha captcha) {
        try {
            if (captcha == null) {
                throw new SouvenirRuntimeException("insertCaptcha - captcha object is NULL");
            }
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(CAPTCHA_VALUE_IN_SP_PARAM_NAME, captcha.getCaptchaValue());
            mapParam.put(CAPTCHA_URL_FILE_IN_SP_PARAM_NAME, captcha.getCaptchaUrlFile());
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    INSERT_CAPTCHA_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                this.dataSource.getConnection().commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                this.dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                throw new SouvenirRuntimeException("Error rollback operation! " + e1.getMessage());
            }
            throw new SouvenirRuntimeException("Error " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateCaptcha(Captcha captcha) {
        try {
            if (captcha == null) {
                throw new SouvenirRuntimeException("updateCaptcha - captcha object is NULL");
            }
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, captcha.getCaptchaId());
            mapParam.put(CAPTCHA_VALUE_IN_SP_PARAM_NAME, captcha.getCaptchaValue());
            mapParam.put(CAPTCHA_URL_FILE_IN_SP_PARAM_NAME, captcha.getCaptchaUrlFile());
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    UPDATE_CAPTCHA_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                this.dataSource.getConnection().commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                this.dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                throw new SouvenirRuntimeException("Error rollback operation! " + e1.getMessage());
            }
            throw new SouvenirRuntimeException("Error " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteCaptcha(Captcha captcha) {
        try {
            if (captcha == null) {
                throw new SouvenirRuntimeException("deleteCaptcha - captcha object is NULL");
            }
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, captcha.getCaptchaId());
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    DELETE_CAPTCHA_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                this.dataSource.getConnection().commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                this.dataSource.getConnection().rollback();
            } catch (SQLException e1) {
                throw new SouvenirRuntimeException("Error rollback operation! " + e1.getMessage());
            }
            throw new SouvenirRuntimeException("Error " + e.getMessage());
        }
        return false;
    }

    @Override
    public Captcha getCaptchaById(Integer idCaptcha) {
        Captcha captcha = null;
        try {
            CaptchaMapper captchaMapper = new CaptchaMapper();
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, idCaptcha);

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    GET_CAPTCHA_BY_ID_SP_NAME, mapParam, false);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                captcha = captchaMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getCaptchaById - " + e.getMessage());
        }
        return captcha;
    }

    @Override
    public List<Captcha> getAllCaptcha() {
        List<Captcha> captchas = null;
        try {
            CaptchaMapper captchaMapper = new CaptchaMapper();
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    GET_ALL_CAPTCHA_SP_NAME, null, false);
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                captchas = new ArrayList<>();
                while (rs.next()) {
                    captchas.add(captchaMapper.mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getAllCaptcha - " + e.getMessage());
        }
        return captchas;
    }

    @Override
    public Captcha getRandomCaptcha(Captcha captchaUser) {
        Captcha captcha = null;
        try {
            CaptchaMapper captchaMapper = new CaptchaMapper();
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, captchaUser.getCaptchaId());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    GET_RANDOM_CAPTCHA_SP_NAME, mapParam, false);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                captcha = captchaMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getRandomCaptcha - " + e.getMessage());
        }
        return captcha;
    }

    @Override
    public Integer getMaxIdCaptcha() {
        Integer maxId = null;
        try {
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    GET_MAX_ID_CAPTCHA_FN_NAME, null, true);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            maxId = callableStatement.getInt(1);
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getMaxIdCaptcha - " + e.getMessage());
        }
        return maxId;
    }

    @Override
    public boolean checkCaptcha(Captcha captcha) {
        try {
            CaptchaMapper captchaMapper = new CaptchaMapper();
            List<String> keysList = new ArrayList<>();
            ListHelper.getList(keysList, CAPTCHA_ID_IN_SP_PARAM_NAME, CAPTCHA_VALUE_IN_SP_PARAM_NAME);
            HashMap<String, Object> mapParam = new HashMap<>();
            MapHelper.getMap(mapParam, keysList, captcha.getCaptchaId(), captcha.getCaptchaValue());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    CHECK_CAPTCHA_SP_NAME, mapParam, false);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Captcha mapRow = captchaMapper.mapRow(rs);
                if (mapRow != null && mapRow.getCaptchaId() != null) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getRandomCaptcha - " + e.getMessage());
        }
        return false;
    }
}