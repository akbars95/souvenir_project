package com.mtsmda.souvenir.repository.impl;

import com.mtsmda.souvenir.repository.SouvenirRepository;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.sp.SouvenirStoredProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static com.mtsmda.souvenir.model.sp.SouvenirSP.*;

/**
 * Created by MTSMDA on 19.11.2015.
 */
@Repository("souvenirRepository")
public class SouvenirRepositoryImplSP implements SouvenirRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    private SouvenirStoredProcedure souvenirStoredProcedure;

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
        List<SqlParameter> sqlParam = new ArrayList<>();
        sqlParam.add(SOUVENIR_ID_IN_SP_SQL_PARAM);
        this.souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, SELECT_SOUVENIR_SP_NAME, sqlParam);

        //this.souvenirStoredProcedure.executeSP();

        return souvenir;
    }

    @Override
    public List<Souvenir> getAllSouvenir() {
        return null;
    }

    @Override
    public List<Souvenir> getAllSouvenirWithCategoryAndAudit() {
        return null;
    }

    @Override
    public boolean hideSouvenir(Souvenir souvenir) {
        return false;
    }
}