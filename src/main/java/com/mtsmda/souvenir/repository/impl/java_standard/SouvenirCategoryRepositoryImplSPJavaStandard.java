package com.mtsmda.souvenir.repository.impl.java_standard;

import static com.mtsmda.souvenir.model.sp.SouvenirCategorySP.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.MapperI;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.SouvenirCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.repository.SouvenirCategoryRepository;
import com.mtsmda.souvenir.repository.impl.java_standard.rowMapper.CaptchaMapper;

@Repository("souvenirCategoryRepositoryImplSPJavaStandard")
public class SouvenirCategoryRepositoryImplSPJavaStandard implements SouvenirCategoryRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Override
    public boolean insertSouvenirCategory(SouvenirCategory souvenirCategory) {
        // TODO Auto-generated method stub
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