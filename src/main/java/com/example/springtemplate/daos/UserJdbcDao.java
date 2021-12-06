package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;

import java.sql.*;
import java.util.*;

public class UserJdbcDao {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String HOST = "localhost:3306";
    static final String SCHEMA = "p1_cars";
    static final String CONFIG = "serverTimezone=UTC";
    static final String URL =
            "jdbc:mysql://"+HOST+"/"+SCHEMA+"?"+CONFIG;
    static final String USERNAME = "cs3200";
    static final String PASSWORD = "cs3200";
    
    static Connection connection = null;
    static PreparedStatement statement = null;
    String CREATE_USER = "INSERT INTO users VALUES (null, ?, ?, ?, ?, ?, ?)";
    String FIND_ALL_USERS = "SELECT * FROM users";
    String FIND_USER_BY_ID = "SELECT * FROM users WHERE id=?";
    String DELETE_USER = "DELETE FROM users WHERE id=?";
    String UPDATE_USER_PASSWORD = "UPDATE users SET password=? WHERE id=?";
    String UPDATE_USER = "UPDATE users SET first_name=?, last_name=?, username=?, password=?, email=?, dob=? WHERE id=?";
    
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
    
    public User findUserById(Integer id) throws SQLException, ClassNotFoundException {
        User user = null;
        connection = getConnection();

        // do your work here
        statement = connection.prepareStatement(FIND_USER_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            user = new User(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("dob")
            );
        }

        closeConnection(connection);
        return user;
    }
    
    public Integer deleteUser(Integer userId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();

        // do your work here
        statement = connection.prepareStatement(DELETE_USER);
        statement.setInt(1, userId);
        rowsDeleted = statement.executeUpdate();

        closeConnection(connection);
        return rowsDeleted;
    }
    
    public Integer updateUser(Integer userId, User newUser) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        // do your work here
        statement = connection.prepareStatement(UPDATE_USER);
        statement.setString(1, newUser.getFirstName());
        statement.setString(2, newUser.getLastName());
        statement.setString(3, newUser.getUsername());
        statement.setString(4, newUser.getPassword());
        statement.setString(5, newUser.getEmail());
        statement.setString(6, newUser.getDob());
        statement.setInt(7, userId);
        rowsUpdated = statement.executeUpdate();

        closeConnection(connection);
        return rowsUpdated;
    }
    
    public List<User> findAllUsers() throws ClassNotFoundException, SQLException {
        List<User> users = new ArrayList<User>();
        connection = getConnection();

        // do your work here
        statement = connection.prepareStatement(FIND_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("dob")
            );
            users.add(user);
        }

        closeConnection(connection);
        return users;
    }
    public Integer createUser(User user)
            throws ClassNotFoundException, SQLException {
        Integer rowsUpdated = 0;
        connection = getConnection();

        // do your work here
        statement = connection.prepareStatement(CREATE_USER);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getDob());
        rowsUpdated = statement.executeUpdate();


        closeConnection(connection);
        return rowsUpdated;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserJdbcDao dao = new UserJdbcDao();

        // do your work here
        User jack =
            new User("Jack", "Albero", "ja", "pw", "ja@gmail.com", "2000-12-09");

//        dao.createUser(jack);

//        List<User> users = dao.findAllUsers();
//        for (User user: users) {
//            System.out.println(user.getUsername());
//        }

//        User user = dao.findUserById(4);
//        System.out.println(user.getUsername());

//        List<User> users = dao.findAllUsers();
//        for(User user: users) {
//            System.out.println(user.getUsername());
//        }
//
//        dao.deleteUser(4);
//
//        users = dao.findAllUsers();
//        for(User user: users) {
//            System.out.println(user.getUsername());
//        }

        dao.updateUser(2, jack);
        User tom = dao.findUserById(2);
        System.out.println(tom.getUsername());

    }
}
