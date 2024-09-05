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
    public void addSearchhistory(String user_id) {
        String query = "INSERT INTO searchhistory(user_id,search) values(?,?)";

        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, user_id);
            pstmt.executeQuery();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
