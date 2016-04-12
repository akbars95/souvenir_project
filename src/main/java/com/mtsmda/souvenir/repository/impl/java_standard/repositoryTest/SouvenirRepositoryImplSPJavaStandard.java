package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.SouvenirExceptionHandler;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirAudit;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.repository.SouvenirPhotoRepository;
import com.mtsmda.souvenir.repository.SouvenirRepository;
import com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper.*;
//import SouvenirMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.souvenir.model.sp.SouvenirSP.*;
import static com.mtsmda.souvenir.model.sp.SouvenirSP.SOUVENIR_SHOW_IN_SP_PARAM_NAME;

/**
 * Created by MTSMDA on 21.02.2016.
 */
@Repository("souvenirRepositoryImplSPJavaStandard")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class SouvenirRepositoryImplSPJavaStandard implements SouvenirRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "SouvenirPhotoRepositoryImplSPJavaStandard")
    private SouvenirPhotoRepository souvenirPhotoRepository;

    @Transactional
    @Override
    public boolean insertSouvenir(Souvenir souvenir) {
        try (Connection connection = this.dataSource.getConnection();){
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_NAME_IN_SP_PARAM_NAME, souvenir.getSouvenirName());
            mapParam.put(SOUVENIR_DESCRIPTION_IN_SP_PARAM_NAME, souvenir.getSouvenirDescription());
            mapParam.put(SOUVENIR_SHOW_IN_SP_PARAM_NAME, souvenir.getSouvenirShow());
            mapParam.put(SOUVENIR_MAIN_PHOTO_ID_IN_SP_PARAM_NAME, (souvenir.getSouvenirMainPhotoId() != null && souvenir.getSouvenirMainPhotoId().getSouvenirPhotoId() != null) ? souvenir.getSouvenirMainPhotoId().getSouvenirPhotoId() : null);
            mapParam.put(SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME, souvenir.getSouvenirCategory().getSouvenirCategoryId());
            mapParam.put(SOUVENIR_PRICE_IN_SP_PARAM_NAME, souvenir.getSouvenirPrice());
            mapParam.put(SOUVENIR_COUNT_OF_DAYS_FOR_ORDER_IN_SP_PARAM_NAME, souvenir.getSouvenirCountOfDaysForOrder());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    INSERT_SOUVENIRS_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                Souvenir lastAddedSouvenir = getLastAddedSouvenir();
                if (lastAddedSouvenir != null && lastAddedSouvenir.getSouvenirId() != null) {
                    if (souvenir.getSouvenirPhotos() != null && !souvenir.getSouvenirPhotos().isEmpty()) {
                        for (SouvenirPhoto souvenirPhoto : souvenir.getSouvenirPhotos()) {
                            souvenirPhoto.setSouvenir(lastAddedSouvenir);
                            souvenirPhotoRepository.insertSouvenirPhoto(souvenirPhoto);
                        }
                    }
                    lastAddedSouvenir = getLastAddedSouvenir();
                    return true;
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertSouvenir", e);
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateSouvenir(Souvenir souvenir) {
        return false;
    }

    @Transactional
    @Override
    public boolean deleteSouvenir(Souvenir souvenir) {
        try (Connection connection = this.dataSource.getConnection();){
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_ID_IN_SP_PARAM_NAME, souvenir.getSouvenirId());

            List<SouvenirPhoto> souvenirPhotosBySouvenirId = souvenirPhotoRepository.getSouvenirPhotosBySouvenirId(souvenir.getSouvenirId());

            for (SouvenirPhoto souvenirPhoto : souvenirPhotosBySouvenirId) {
                boolean b = souvenirPhotoRepository.deleteSouvenirPhoto(souvenirPhoto);
                if (!b) {
                    throw new SouvenirRuntimeException("Error delete photos!");
                }
            }
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    DELETE_SOUVENIR_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertSouvenir", e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public Souvenir getSouvenir(Integer souvenirId) {
        Souvenir souvenir = null;
        try (Connection connection = this.dataSource.getConnection();){
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirId);

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    SELECT_SOUVENIR_SP_NAME, mapParam, false);
            ResultSet rs = callableStatement.executeQuery();

            if (rs != null) {
                MapperI<Souvenir> souvenirMapper = new SouvenirMapper();
                while (rs.next()) {
                    souvenir = souvenirMapper.mapRow(rs);
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getSouvenir", e);
        }
        return souvenir;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Souvenir> getAllSouvenir() {
        List<Souvenir> souvenirs = null;
        try (Connection connection = this.dataSource.getConnection();){
            MapperI<Souvenir> souvenirMapper = new SouvenirMapper();
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    GET_ALL_SOUVENIRS_SP_NAME, null, false);
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                souvenirs = new ArrayList<>();
                while (rs.next()) {
                    souvenirs.add(souvenirMapper.mapRow(rs));
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getAllSouvenir", e);
        }
        return souvenirs;
    }

    @Transactional
    @Override
    public boolean hideSouvenir(Souvenir souvenir) {
        try (Connection connection = this.dataSource.getConnection();){
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_ID_IN_SP_PARAM_NAME, souvenir.getSouvenirId());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    HIDE_SHOW_SOUVENIR_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("hideSouvenir", e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Souvenir> getAllSouvenirWithCategoryAndAudit(boolean withSouvenirPhotos) {
        List<Souvenir> souvenirs = null;
        try (Connection connection = this.dataSource.getConnection();){
            MapperI<Souvenir> souvenirMapper = new SouvenirMapper();
            MapperI<SouvenirCategory> souvenirCategoryMapper = new SouvenirCategoryMapper();
            MapperI<SouvenirAudit> souvenirAuditMapper = new SouvenirAuditMapper();
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    SELECT_FULL_SOUVENIR_WITH_CATEGORY_AND_AUDIT_SP_NAME, null, false);
            ResultSet rs = callableStatement.executeQuery();
            if (rs != null) {
                souvenirs = new ArrayList<>();
                System.out.println(rs.getFetchSize());
                while (rs.next()) {
                    Souvenir souvenir = souvenirMapper.mapRow(rs);
                    SouvenirCategory souvenirCategory = souvenirCategoryMapper.mapRow(rs);
                    souvenir.setSouvenirCategory(souvenirCategory);
                    SouvenirAudit souvenirAudit = souvenirAuditMapper.mapRow(rs);
                    souvenir.setSouvenirAudit(souvenirAudit);
                    if (souvenir.getSouvenirId() != null && withSouvenirPhotos) {
                        souvenir.setSouvenirPhotos(souvenirPhotoRepository.getSouvenirPhotosBySouvenirId(souvenir.getSouvenirId()));
                    }
                    souvenirs.add(souvenir);
                }
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getAllSouvenirWithCategoryAndAudit", e);
        }
        return souvenirs;
    }


    @Transactional(readOnly = true)
    @Override
    public Souvenir getLastAddedSouvenir() {
        Souvenir souvenir = null;
        try (Connection connection = this.dataSource.getConnection();){
            MapperI<Souvenir> souvenirMapper = new SouvenirMapper();
            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    GET_LAST_ADDED_SOUVENIR_SP_NAME, null, false);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    souvenir = souvenirMapper.mapRow(resultSet);
                }
            }
        } catch (Exception e) {
            SouvenirExceptionHandler.handle("getLastAddedSouvenir", e);
        }
        return souvenir;
    }
}