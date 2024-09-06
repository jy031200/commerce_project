package dao;

import dto.Searchhistory;

import java.sql.*;

public class SearchhistoryDAO implements SearchhistoryDAOlmpl {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/commerce";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "user";

    private Connection conn = null;
    private PreparedStatement pstmt = null;

    @Override
    public void addSearchHistory(String user_id, String search) {
        String query = "INSERT INTO SearchHistory (user_id, search) VALUES (?, ?)";

        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, user_id);
            pstmt.setString(2, search);
            pstmt.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();  // 트랜잭션 롤백
                    System.out.println("Transaction rolled back due to error.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }

    @Override
    public Searchhistory getSearchhistory(String user_id) {
        String query = "SELECT * FROM searchhistory WHERE user_id=?";
        Searchhistory searchhistory = null;

        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, user_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                searchhistory = new Searchhistory();

                searchhistory.setUser_id(rs.getString("user_id"));
                searchhistory.setSearch(rs.getString("search"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return searchhistory;
    }
}
