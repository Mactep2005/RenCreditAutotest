package ru.appline.rencredit;

import java.sql.*;

public class SQLDatabaseConnection {
    String connectionUrl;
    String port;
    String database;
    String user;
    String password;
    boolean connected;
    Connection connection;

    public SQLDatabaseConnection(String connectionUrl, String port, String database, String user, String password) {
        this.connectionUrl = connectionUrl;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public boolean connect() throws SQLException {
        connected = false;
        String connectionStr = "jdbc:sqlserver://" + connectionUrl + ":" + port + ";"
                + "database=" + database + ";"
                + "user=" + user + ";"
                + "password=" + password + ";"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
        try {
            connection = DriverManager.getConnection(connectionStr);
            connected = true;
            }
            catch (Exception e)
            {
            e.printStackTrace();
            }
        return connected;
    }

    public boolean execute(String expr) throws SQLException {
        boolean success = false;
        try
        {
            Statement stmt;
            stmt = connection.createStatement();
            stmt.executeUpdate(expr);
            success = true;
        }
        catch (Exception e)
            {
            e.printStackTrace();
            }
        return success;
    }
    public boolean quit() throws SQLException {
        boolean connected = true;
        try
        {
            connection.commit();
            connection.close();
            connected = false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connected;
    }
}

