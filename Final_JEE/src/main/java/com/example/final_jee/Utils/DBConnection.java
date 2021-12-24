package com.example.final_jee.Utils;

import javax.ejb.Singleton;
import java.sql.*;


    @Singleton
    public class DBConnection {
        private static final String JDBC_DRIVER = "org.postgresql.Driver";
        private static final String DB_URL = "jdbc:postgresql://localhost:5432/Supply_chain";
        private static final String USER = "postgres";
        private static final String PASS = "Www.dan.com7";
        private Connection connection = null;
        private Statement statement = null;
        private PreparedStatement preparedStatement = null;

        public DBConnection() throws SQLException {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("PostgreSQL JDBC Driver is not found.");
                e.printStackTrace();
                return;
            }
            System.out.println("Connection to DataBase...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Success!");
            statement = connection.createStatement();
            //PreparedStatement preparedStatement = connection.prepareStatement();
            //CallableStatement callableStatement = connection.prepareCall();
            statement.executeUpdate(DBCreate.createDataBaseSql());

            connection.setAutoCommit(false);
            Statement finalStatement = statement;

            DBCreate.LocalData().forEach(sql -> {
                try {
                    finalStatement.executeUpdate(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
            connection.commit();
        }        }
