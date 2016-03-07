package com.mtsmda.souvenir.repository.impl.java_standard;

import javax.sql.DataSource;

import com.mtsmda.souvenir.helper.SouvenirExceptionHandler;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Souvenir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.repository.SouvenirPhotoRepository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.mtsmda.souvenir.model.sp.SouvenirPhotoSP.*;

@Repository("SouvenirPhotoRepositoryImplSPJavaStandard")
public class SouvenirPhotoRepositoryImplSPJavaStandard implements SouvenirPhotoRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

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
            try {
                dataSource.getConnection().rollback();
            } catch (Exception e1) {
                SouvenirExceptionHandler.handle("insertSouvenirPhoto", e1);
            }
            SouvenirExceptionHandler.handle("insertSouvenirPhoto", e);
        }
        return false;
    }

    @Override
    public boolean updateSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getSouvenirPhoto(SouvenirPhoto souvenirPhoto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getAllSouvenirPhotos() {
        // TODO Auto-generated method stub
        return false;
    }


}