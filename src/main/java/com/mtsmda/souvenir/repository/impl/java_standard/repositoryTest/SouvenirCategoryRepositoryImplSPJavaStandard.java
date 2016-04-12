package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest;

import static com.mtsmda.souvenir.model.sp.SouvenirCategorySP.*;

import java.sql.CallableStatement;
import java.sql.Connection;
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
@Transactional(isolation = Isolation.READ_COMMITTED)
public class SouvenirCategoryRepositoryImplSPJavaStandard implements SouvenirCategoryRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Transactional
    @Override
    public boolean insertSouvenirCategory(SouvenirCategory souvenirCategory) {
        if (souvenirCategory == null && StringUtils.isNotBlank(souvenirCategory.getSouvenirCategory())) {
            throw new SouvenirRuntimeException("insertSouvenirCategory - SouvenirCategory object is NULL");
        }
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(SOUVENIR_CATEGORY_IN_SP_PARAM_NAME, souvenirCategory.getSouvenirCategory());
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     INSERT_SOUVENIR_CATEGORY_SP_NAME, mapParam, false);) {
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertSouvenirCategory", e);
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateSouvenirCategory(SouvenirCategory souvenirCategory) {
        if (souvenirCategory == null && StringUtils.isNotBlank(souvenirCategory.getSouvenirCategory())) {
            throw new SouvenirRuntimeException("updateSouvenirCategory - SouvenirCategory object is NULL");
        }
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME, souvenirCategory.getSouvenirCategoryId());
        mapParam.put(SOUVENIR_CATEGORY_IN_SP_PARAM_NAME, souvenirCategory.getSouvenirCategory());

        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     UPDATE_SOUVENIR_CATEGORY_SP_NAME, mapParam, false);) {
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("updateSouvenirCategory", e);
        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteSouvenirCategory(SouvenirCategory souvenirCategory) {
        if (souvenirCategory == null && souvenirCategory.getSouvenirCategoryId() != null) {
            throw new SouvenirRuntimeException("deleteSouvenirCategory - SouvenirCategory object is NULL");
        }
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME, souvenirCategory.getSouvenirCategoryId());

        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     DELETE_SOUVENIR_CATEGORY_SP_NAME, mapParam, false);) {
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("deleteSouvenirCategory", e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public SouvenirCategory getSouvenirCategory(Integer souvenirCategoryId) {
        SouvenirCategory souvenirCategory = null;
        MapperI<SouvenirCategory> souvenirCategoryMapper = new SouvenirCategoryMapper();
        Map<String, Object> mapParam = new LinkedHashMap<>();
        mapParam.put(SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME, souvenirCategoryId);
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection, GET_SOUVENIR_CATEGORY_SP_NAME,
                     mapParam, false);) {
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    souvenirCategory = souvenirCategoryMapper.mapRow(rs);
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getSouvenirCategory", e);
        }
        return souvenirCategory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SouvenirCategory> getAllSouvenirCategories() {
        List<SouvenirCategory> categories = null;
        MapperI<SouvenirCategory> souvenirCategoryMapper = new SouvenirCategoryMapper();
        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection, GET_ALL_SOUVENIR_CATEGORIES_SP_NAME,
                     null, false);) {
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                categories = new ArrayList<>();
                while (rs.next()) {
                    SouvenirCategory souvenirCategory = souvenirCategoryMapper.mapRow(rs);
                    categories.add(souvenirCategory);
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getAllSouvenirCategories", e);
        }
        return categories;
    }


}