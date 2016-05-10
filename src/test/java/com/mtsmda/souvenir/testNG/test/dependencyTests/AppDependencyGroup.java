package com.mtsmda.souvenir.testNG.test.dependencyTests;

import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/4/2016.
 */
public class AppDependencyGroup {

    private static final String DB_PIECE = "DB_PIECE";
    private static final String DB_OP = "DB_OP";
    private static final String CLOSE_DB_OP = "CLOSE_DB_OP";

    @Test(groups = DB_PIECE)
    public void getSettingsDB(){
        System.out.println("getSettingsDB - 1");
    }

    @Test(groups = DB_PIECE)
    public void getSetUpDB(){
        System.out.println("getSetUpDB - 2");
    }

    @Test(groups = DB_PIECE)
    public void getConnectionDB(){
        System.out.println("getConnectionDB - 3");
    }


    @Test(groups = DB_OP, dependsOnGroups = DB_PIECE)
    public void insertOP(){
        System.out.println("insertOP - 4");
    }

    @Test(groups = DB_OP, priority = 2)
    public void getLastInsertedOP(){
        System.out.println("get last inserted - 5");
    }


    @Test(groups = DB_OP, priority = 3)
    public void updateOP(){
        System.out.println("updateOP - 6");
    }

    @Test(groups = DB_OP, priority = 4)
    public void getAllOP(){
        System.out.println("getAllOP - 7");
    }

    @Test(groups = DB_OP, priority = 5)
    public void deleteOP(){
        System.out.println("deleteOP - 8");
    }

    @Test(groups = CLOSE_DB_OP)
    public void closeDBOP(){
        System.out.println("closeDBOP - 9");
    }

    @Test(dependsOnGroups = {DB_PIECE, DB_OP, CLOSE_DB_OP})
    public void runAll(){
        System.out.println("runAll");
    }
}