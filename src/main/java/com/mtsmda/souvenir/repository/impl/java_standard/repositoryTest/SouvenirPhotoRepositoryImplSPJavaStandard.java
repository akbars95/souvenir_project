package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest;

import javax.sql.DataSource;

import com.mtsmda.souvenir.helper.SouvenirExceptionHandler;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper.MapperI;
import com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper.SouvenirPhotoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.repository.SouvenirPhotoRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.souvenir.model.sp.SouvenirPhotoSP.*;

@Repository("SouvenirPhotoRepositoryImplSPJavaStandard")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class SouvenirPhotoRepositoryImplSPJavaStandard implements SouvenirPhotoRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Transactional
    @Override
    public boolean insertSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        try (Connection connection = this.dataSource.getConnection();){
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_PATH_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenirPhotoPath());
            mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenir().getSouvenirId());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    INSERT_SOUVENIR_PHOTO_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            SouvenirExceptionHandler.handle("insertSouvenirPhoto", e);
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        try (Connection connection = this.dataSource.getConnection();){
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_PATH_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenirPhotoPath());
            mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenir().getSouvenirId());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    UPDATE_SOUVENIR_PHOTO_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            SouvenirExceptionHandler.handle("insertSouvenirPhoto", e);
        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        try (Connection connection = this.dataSource.getConnection();){
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_ID_IN_SP_PARAM_NAME, (souvenirPhoto.getSouvenirPhotoId() == null) ? -1 : souvenirPhoto.getSouvenirPhotoId());
            if (souvenirPhoto.getSouvenir() != null && souvenirPhoto.getSouvenir().getSouvenirId() != null) {
                mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenir().getSouvenirId());
            } else {
                mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, -1);
            }

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    DELETE_SOUVENIR_PHOTO_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            SouvenirExceptionHandler.handle("deleteSouvenirPhoto", e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public SouvenirPhoto getSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        SouvenirPhoto souvenirPhotoResult = null;
        try (Connection connection = this.dataSource.getConnection();) {
            String spName = null;
            Map<String, Object> mapParam = new LinkedHashMap<>();
            if (souvenirPhoto != null) {
                if (StringUtils.isNotBlank(souvenirPhoto.getSouvenirPhotoPath())) {
                    spName = GET_SOUVENIR_PHOTOS_BY_PATH_SP_NAME;
                    mapParam.put(SOUVENIR_PHOTO_PATH_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenirPhotoPath());
                } else {
                    SouvenirExceptionHandler.handle("getSouvenirPhoto - " + SOUVENIR_PHOTO_PATH_IN_SP_PARAM_NAME + " is null", null);
                }
                if (souvenirPhoto.getSouvenir() != null && souvenirPhoto.getSouvenir().getSouvenirId() != null) {
                    spName = GET_SOUVENIR_PHOTOS_BY_SOUVENIR_ID_SP_NAME;
                    mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenir().getSouvenirId());
                } else {
                    SouvenirExceptionHandler.handle("getSouvenirPhoto - " + SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME + " is null", null);
                }
            }

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    spName, mapParam, false);
            ResultSet resultSet = callableStatement.executeQuery();
            MapperI<SouvenirPhoto> souvenirPhotoMapperI = new SouvenirPhotoMapper();
            while (resultSet.next()) {
                souvenirPhotoResult = souvenirPhotoMapperI.mapRow(resultSet);
            }
        } catch (Exception e) {
            SouvenirExceptionHandler.handle("getSouvenirPhoto", e);
        }
        return souvenirPhotoResult;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SouvenirPhoto> getAllSouvenirPhotos() {
        List<SouvenirPhoto> souvenirPhotos = new ArrayList<>();
        try (Connection connection = this.dataSource.getConnection();) {

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    GET_SOUVENIR_PHOTOS_ALL_SP_NAME, null, false);
            ResultSet resultSet = callableStatement.executeQuery();
            MapperI<SouvenirPhoto> souvenirPhotoMapperI = new SouvenirPhotoMapper();
            while (resultSet.next()) {
                souvenirPhotos.add(souvenirPhotoMapperI.mapRow(resultSet));
            }
        } catch (Exception e) {
            SouvenirExceptionHandler.handle("getAllSouvenirPhotos", e);
        }
        return souvenirPhotos;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SouvenirPhoto> getSouvenirPhotosBySouvenirId(Integer souvenirId) {
        List<SouvenirPhoto> souvenirPhotos = new ArrayList<>();
        try (Connection connection = this.dataSource.getConnection();) {
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirId);

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                    GET_SOUVENIR_PHOTOS_BY_SOUVENIR_ID_SP_NAME, mapParam, false);
            ResultSet resultSet = callableStatement.executeQuery();
            MapperI<SouvenirPhoto> souvenirPhotoMapperI = new SouvenirPhotoMapper();
            while (resultSet.next()) {
                souvenirPhotos.add(souvenirPhotoMapperI.mapRow(resultSet));
            }
        } catch (Exception e) {
            SouvenirExceptionHandler.handle("getSouvenirPhotosBySouvenirId", e);
        }
        return souvenirPhotos;
    }


}