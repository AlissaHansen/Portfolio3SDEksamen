package com.company;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {
    Connection conn = null;
    String url;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    StudentModel(String url) {
        this.url = url;
    }

    public void connect() throws SQLException {
        this.conn = DriverManager.getConnection(this.url);
    }

    public void close() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
        }

    }

    public void CreateStatement() throws SQLException {
        this.stmt = this.conn.createStatement();
    }

    public ArrayList<Integer> SQLQueryStudentNumbers() {
        ArrayList<Integer> StudentNumbers = new ArrayList();
        String sql = "Select StudentNo From Students";

        try {
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs != null && this.rs.next()) {
                int StudentNo = this.rs.getInt(1);
                StudentNumbers.add(StudentNo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        this.rs = null;
        return StudentNumbers;
    }
}
