package com.mtsmda.souvenir.sp;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by MTSMDA on 18.11.2015.
 */
public class SouvenirStoredProcedure extends StoredProcedure {

    public SouvenirStoredProcedure(DataSource dataSource, String storedProcedureName, List<SqlParameter> sqlParameterList) {
        super(dataSource, storedProcedureName);
        if (sqlParameterList != null) {
            for (SqlParameter sqlParameter : sqlParameterList) {
                declareParameter(sqlParameter);
            }
        }
        compile();
    }


    public Map executeSP(Map<String, Object> inParameters) {
        /*Map<String, Integer> inParameters = new HashMap<String, Integer>(2);
        inParameters.put("start_age", start);
        inParameters.put("end_age", end);
*/
        Map returnData = execute(inParameters);
        return returnData;
    }

    public Map executeSP() {
        /*Map<String, Integer> inParameters = new HashMap<String, Integer>(2);
        inParameters.put("start_age", start);
        inParameters.put("end_age", end);
*/
        Map returnData = execute();
        return returnData;
    }

}