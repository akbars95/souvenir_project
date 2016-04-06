package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest;

import javax.sql.DataSource;

import com.mtsmda.souvenir.helper.SouvenirExceptionHandler;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper.MapperI;
import com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper.SouvenirPhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.repository.SouvenirPhotoRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mtsmda.souvenir.model.sp.SouvenirPhotoSP.*;

@Repository("SouvenirPhotoRepositoryImplSPJavaStandard")
@Transactional(readOnly = true)
public class SouvenirPhotoRepositoryImplSPJavaStandard implements SouvenirPhotoRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public boolean insertSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        try {
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_PATH_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenirPhotoPath());
            mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenir().getSouvenirId());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    INSERT_SOUVENIR_PHOTO_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertSouvenirPhoto", e);
        }
        return false;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public boolean updateSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        try {
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_PATH_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenirPhotoPath());
            mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenir().getSouvenirId());

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    UPDATE_SOUVENIR_PHOTO_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertSouvenirPhoto", e);
        }
        return false;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        try {
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_ID_IN_SP_PARAM_NAME, (souvenirPhoto.getSouvenirPhotoId() == null) ? -1 : souvenirPhoto.getSouvenirPhotoId());
            if (souvenirPhoto.getSouvenir() != null && souvenirPhoto.getSouvenir().getSouvenirId() != null) {
                mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirPhoto.getSouvenir().getSouvenirId());
            } else {
                mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, -1);
            }

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    DELETE_SOUVENIR_PHOTO_SP_NAME, mapParam, false);
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("deleteSouvenirPhoto", e);
        }
        return false;
    }

    @Override
    public SouvenirPhoto getSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SouvenirPhoto> getAllSouvenirPhotos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<SouvenirPhoto> getSouvenirPhotosBySouvenirId(Integer souvenirId) {
        List<SouvenirPhoto> souvenirPhotos = new ArrayList<>();
        try {
            Map<String, Object> mapParam = new LinkedHashMap<>();
            mapParam.put(SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME, souvenirId);

            CallableStatement callableStatement = SouvenirStandardSPHelper.execute(this.dataSource,
                    GET_SOUVENIR_PHOTOS_BY_SOUVENIR_ID_SP_NAME, mapParam, false);
            ResultSet resultSet = callableStatement.executeQuery();
            MapperI<SouvenirPhoto> souvenirPhotoMapperI = new SouvenirPhotoMapper();
            while (resultSet.next()) {
                souvenirPhotos.add(souvenirPhotoMapperI.mapRow(resultSet));
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("getSouvenirPhotosBySouvenirId", e);
        }
        return souvenirPhotos;
    }


}