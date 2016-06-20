package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.MapHelper;
import com.mtsmda.souvenir.helper.SouvenirExceptionHandler;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.spring.stereotype.object.request.CaptchaUpdateRO;
import com.mtsmda.souvenir.spring.stereotype.repository.CaptchaRepository;
import com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.rowMapper.CaptchaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
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
@Transactional(isolation = Isolation.READ_COMMITTED)
public class CaptchaRepositoryImplSPJavaStandard implements CaptchaRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Transactional
    @Override
    public boolean insertCaptcha(Captcha captcha) {
        if (captcha == null) {
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
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateCaptcha(Captcha captcha) {
        if (captcha == null) {
            throw new SouvenirRuntimeException("updateCaptcha - captcha object is NULL");
        }
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, captcha.getCaptchaId());
        mapParam.put(CAPTCHA_VALUE_IN_SP_PARAM_NAME, captcha.getCaptchaValue());
        mapParam.put(CAPTCHA_URL_FILE_IN_SP_PARAM_NAME, captcha.getCaptchaUrlFile());
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     UPDATE_CAPTCHA_SP_NAME, mapParam, false);) {
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("updateCaptcha", e);
        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteCaptcha(Captcha captcha) {
        if (captcha == null) {
            throw new SouvenirRuntimeException("deleteCaptcha - captcha object is NULL");
        }
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, captcha.getCaptchaId());
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     DELETE_CAPTCHA_SP_NAME, mapParam, false);) {
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("deleteCaptcha", e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public Captcha getCaptchaById(Integer idCaptcha) {
        Captcha captcha = null;
        CaptchaMapper captchaMapper = new CaptchaMapper();
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(CAPTCHA_ID_IN_SP_PARAM_NAME, idCaptcha);
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     GET_CAPTCHA_BY_ID_SP_NAME, mapParam, false);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                captcha = captchaMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getCaptchaById", e);
        }
        return captcha;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Captcha> getAllCaptcha() {
        List<Captcha> captchas = null;
        CaptchaMapper captchaMapper = new CaptchaMapper();
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     GET_ALL_CAPTCHA_SP_NAME, null, false);) {
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                captchas = new ArrayList<>();
                while (rs.next()) {
                    captchas.add(captchaMapper.mapRow(rs));
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getAllCaptcha", e);
        }
        return captchas;
    }

    @Transactional(readOnly = true)
    @Override
    public Captcha getRandomCaptcha(CaptchaUpdateRO captchaUpdateRO) {
        return getCaptchaById(getRandomCaptchaId(captchaUpdateRO.getCaptchaId()));
    }

    private Integer getRandomCaptchaId(Integer captchaId){
        List<Integer> captchaIds = new ArrayList<>();
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     GET_CAPTCHA_ALL_IDS_SP_NAME, null, false);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                captchaIds.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getRandomCaptcha", e);
        }
        boolean remove = captchaIds.remove(captchaId);
        if(remove){
            return captchaIds.get(new Long(Math.round(Math.random() * captchaIds.size())).intValue());
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Captcha getRandomCaptcha(Captcha captchaUser) {
        return getRandomCaptcha(new CaptchaUpdateRO(captchaUser.getCaptchaId()));
    }

    @Transactional(readOnly = true)
    @Override
    public Integer getMaxIdCaptcha() {
        Integer maxId = null;
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                GET_MAX_ID_CAPTCHA_FN_NAME, null, true);) {
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            maxId = callableStatement.getInt(1);
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getMaxIdCaptcha", e);
        }
        return maxId;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean checkCaptcha(Captcha captcha) {
        if (captcha == null) {
            throw new SouvenirRuntimeException("getRandomCaptcha - Null pointer Exception!");
        }
        CaptchaMapper captchaMapper = new CaptchaMapper();
        List<String> keysList = new ArrayList<>();
        ListHelper.getList(keysList, CAPTCHA_ID_IN_SP_PARAM_NAME, CAPTCHA_VALUE_IN_SP_PARAM_NAME);
        HashMap<String, Object> mapParam = new HashMap<>();
        MapHelper.getMap(mapParam, keysList, captcha.getCaptchaId(), captcha.getCaptchaValue());
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                CHECK_CAPTCHA_SP_NAME, mapParam, false);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Captcha mapRow = captchaMapper.mapRow(rs);
                if (mapRow != null && mapRow.getCaptchaId() != null) {
                    return true;
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("checkCaptcha", e);
        }
        return false;
    }
}