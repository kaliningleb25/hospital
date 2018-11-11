package com.polytech.bd.bd_client_for_hospital.db_config;

import org.springframework.context.annotation.Configuration;

import java.sql.*;

public class ConfigDB {
    private final Connection conn;
    private final Statement statement;

    public ConfigDB() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "kalinin13");
        statement = conn.createStatement();
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
}
