package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.repositoryTest.rowMapper;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirPhoto;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mtsmda.souvenir.model.sp.SouvenirPhotoSP.*;

/**
 * Created by dminzat on 4/6/2016.
 */
public class SouvenirPhotoMapper implements MapperI<SouvenirPhoto> {


    @Override
    public SouvenirPhoto mapRow(ResultSet rs) {
        SouvenirPhoto souvenirPhoto = new SouvenirPhoto();

        try {
            souvenirPhoto.setSouvenirPhotoId(rs.getInt(SOUVENIR_PHOTO_ID));
        } catch (SQLException e) {
            souvenirPhoto.setSouvenirPhotoId(null);
        }
        try {
            souvenirPhoto.setSouvenirPhotoPath(rs.getString(SOUVENIR_PHOTO_PATH));
        } catch (SQLException e) {
            souvenirPhoto.setSouvenirPhotoPath(null);
        }
        try {
            Souvenir souvenir = new Souvenir();
            souvenir.setSouvenirId(rs.getInt(SOUVENIR_PHOTO_SOUVENIR_ID));
            souvenirPhoto.setSouvenir(souvenir);
        } catch (SQLException e) {
            souvenirPhoto.setSouvenir(null);
        }

        return souvenirPhoto;
    }
}