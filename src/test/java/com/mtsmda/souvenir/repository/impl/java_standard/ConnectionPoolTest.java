package com.mtsmda.souvenir.repository.impl.java_standard;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by dminzat on 4/11/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConnectionPoolTest extends ParentTest {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private org.apache.commons.dbcp.BasicDataSource basicDataSource;

    @Test
    public void test100init() {
        assertNotNull(dataSource);
        assertNotNull(basicDataSource);
    }

    @Test
    public void test101checkConnectionNotNull() throws SQLException {
        assertNotNull(dataSource.getConnection());
        assertNotNull(basicDataSource.getConnection());
    }

    @Test(timeout = 10_000)
    public void test102CountConnections() {
        for (int i = 0; i < 500_000; i++) {
            System.out.println(i);
            try (Connection connection = this.dataSource.getConnection();) {
                assertNotNull(connection);
                System.out.println(connection.isClosed());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }

    @Test
    public void test103ConnectionsProperties() {
        System.out.println(this.basicDataSource.getInitialSize());
        System.out.println(this.basicDataSource.getMaxIdle());
        System.out.println(this.basicDataSource.getMinIdle());
        System.out.println(this.basicDataSource.getMaxWait());
        System.out.println(this.basicDataSource.getMaxActive());
    }

    @Ignore
    @Test(/*expected = Exception.class, */timeout = 5_000)
    public void test104CountConnections() {
        for (int i = 0; i < 1500; i++) {
            System.out.println(i);
            try {
                Connection connection = this.dataSource.getConnection();
                assertNotNull(connection);
                System.out.println(connection.isClosed());
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
        }
        System.out.println("Done");
    }

}