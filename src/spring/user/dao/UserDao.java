package spring.user.dao;

import spring.user.domain.User;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();

        PreparedStatement pstmt = connection.prepareStatement("insert into users(id,name,password) values(?,?,?)");
        pstmt.setString(1,user.getId());
        pstmt.setString(2,user.getName());
        pstmt.setString(3,user.getPassword());

        pstmt.executeUpdate();

        pstmt.close();
        connection.close();

    }
    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();

        PreparedStatement pstmt = connection.prepareStatement("select * from users where id = ?");
        pstmt.setString(1,id);

        ResultSet rs = pstmt.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        pstmt.close();
        connection.close();

        return user;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://172.30.1.45:5432/postgres";
        String username = "postgres";
        String password = "postgres";

        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
