package com.mtsmda.souvenir.repository.impl.java_standard;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirAudit;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.repository.SouvenirRepository;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.MapperI;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.SouvenirAuditMapper;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.SouvenirCategoryMapper;
//import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.SouvenirMapper;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.SouvenirMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.souvenir.model.sp.CaptchaSP.CAPTCHA_ID_IN_SP_PARAM_NAME;
import static com.mtsmda.souvenir.model.sp.SouvenirSP.*;

/**
 * Created by MTSMDA on 21.02.2016.
 */
@Repository("souvenirRepositoryImplSPJavaStandard")
public class SouvenirRepositoryImplSPJavaStandard implements SouvenirRepository{

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Override
    public boolean insertSouvenir(Souvenir souvenir) {
        return false;
    }

    @Override
    public boolean updateSouvenir(Souvenir souvenir) {
        return false;
    }

    @Override
    public boolean deleteSouvenir(Souvenir souvenir) {
        return false;
    }

    @Override
    public Souvenir getSouvenir(Integer souvenirId) {
        Souvenir souvenir = null;
        try {
            MapperI<Souvenir> souvenirMapper = new SouvenirMapper();

            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirId);

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource, SELECT_SOUVENIR_SP_NAME,
                    mapParam, false);
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    souvenir = souvenirMapper.mapRow(rs);
                }
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getAllSouvenir - " + e.getMessage());
        }
        return souvenir;
    }

    @Override
    public List<Souvenir> getAllSouvenir() {
        List<Souvenir> souvenirs = null;
        try {
            MapperI<Souvenir> souvenirMapper = new SouvenirMapper();
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource, GET_ALL_SOUVENIRS_SP_NAME,
                    null, false);
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                souvenirs = new ArrayList<>();
                while (rs.next()) {
                    souvenirs.add(souvenirMapper.mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getAllSouvenir - " + e.getMessage());
        }
        return souvenirs;
    }

    @Override
    public boolean hideSouvenir(Souvenir souvenir) {
        return false;
    }

	@Override
	public List<Souvenir> getAllSouvenirWithCategoryAndAudit() {
		List<Souvenir> souvenirs = null;
        try {
            MapperI<Souvenir> souvenirMapper = new SouvenirMapper();
            MapperI<SouvenirCategory> souvenirCategoryMapper = new SouvenirCategoryMapper();
            MapperI<SouvenirAudit> souvenirAuditMapper = new SouvenirAuditMapper();
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource, SELECT_FULL_SOUVENIR_WITH_CATEGORY_AND_AUDIT_SP_NAME,
                    null, false);
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                souvenirs = new ArrayList<>();
                while (rs.next()) {
                	Souvenir souvenir = souvenirMapper.mapRow(rs);
                	SouvenirCategory souvenirCategory = souvenirCategoryMapper.mapRow(rs);
                	souvenir.setSouvenirCategory(souvenirCategory);
                	SouvenirAudit souvenirAudit = souvenirAuditMapper.mapRow(rs);
                	souvenir.setSouvenirAudit(souvenirAudit);
                    souvenirs.add(souvenir);
                }
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getAllSouvenir - " + e.getMessage());
        }
        return souvenirs;
	}
}