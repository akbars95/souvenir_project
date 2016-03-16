package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest;

import static com.mtsmda.souvenir.model.sp.SouvenirCategorySP.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.mtsmda.souvenir.helper.SouvenirExceptionHandler;
import com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper.MapperI;
import com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper.SouvenirCategoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.repository.SouvenirCategoryRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("souvenirCategoryRepositoryImplSPJavaStandard")
@Transactional()
public class SouvenirCategoryRepositoryImplSPJavaStandard implements SouvenirCategoryRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean insertSouvenirCategory(SouvenirCategory souvenirCategory) {
        try {
            if (souvenirCategory == null && StringUtils.isNotBlank(souvenirCategory.getSouvenirCategory())) {
                throw new SouvenirRuntimeException("insertSouvenirCategory - SouvenirCategory object is NULL");
            }
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_CATEGORY_IN_SP_PARAM_NAME, souvenirCategory.getSouvenirCategory());
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    INSERT_SOUVENIR_CATEGORY_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertSouvenirCategory", e);
        }
        return false;
    }

    @Override
    public boolean updateSouvenirCategory(SouvenirCategory souvenirCategory) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteSouvenirCategory(SouvenirCategory souvenirCategory) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public SouvenirCategory getSouvenirCategory(Integer souvenirCategoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SouvenirCategory> getAllSouvenirCategories() {
        List<SouvenirCategory> categories = null;
        try {
            MapperI<SouvenirCategory> souvenirCategoryMapper = new SouvenirCategoryMapper();
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource, GET_ALL_SOUVENIR_CATEGORIES_SP_NAME,
                    null, false);
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                categories = new ArrayList<>();
                while (rs.next()) {
                    SouvenirCategory souvenirCategory = souvenirCategoryMapper.mapRow(rs);
                    categories.add(souvenirCategory);
                }
            }
        } catch (SQLException e) {
            throw new SouvenirRuntimeException("getCaptchaById - " + e.getMessage());
        }
        return categories;
    }


}