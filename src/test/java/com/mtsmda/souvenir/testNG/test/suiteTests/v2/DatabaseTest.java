package com.mtsmda.souvenir.testNG.test.suiteTests.v2;

import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/4/2016.
 */
public class DatabaseTest {

    private static final String DB = "db";
    private static final String DB_NO_SQL = "db_no_sql";
    private static final String BROKEN_TESTS = "broken_tests";

    @Test(groups = DB)
    public void testConnectionOracle(){
        System.out.println("testConnectionOracle");
    }

    @Test(groups = DB)
    public void testConnectionMSSQL(){
        System.out.println("testConnectionMSSQL");
    }

    @Test(groups = DB_NO_SQL)
    public void testConnectionMongoDB(){
        System.out.println("testConnectionMongoDB");
    }

    @Test(groups = {DB, BROKEN_TESTS})
    public void testConnectionMySQL(){
        System.out.println("testConnectionMySQL");
    }

}