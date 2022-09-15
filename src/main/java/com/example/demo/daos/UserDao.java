package com.example.demo.daos;

import com.example.demo.DBConnection;
import com.example.demo.controllers.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String ADD_USER = "insert into users(username, e_mail, first_name, last_name, password, profession)" +
            " value (?,?,?,?,?,?)";
    private static final String SELECT_USER_BY_USERNAME = "select * from users u where username = ?";
    private static final String SELECT_USER_BY_MAIL = "select * from users u where e_mail = ?";

    private static final String UPDATE_USER_DATA = "update users " +
            "set username = ?, e_mail = ?, first_name = ?, last_name = ?, password = ?, profession = ? " +
            "where id = ?";

    Connection connection;
    public UserDao(){
        connection = DBConnection.getConnection();

    }

    public void addUser(User user) throws SQLException {

        System.out.println(user.toString());
        if(connection == null) System.out.println("connection null ia debilo");
        else System.out.println("qaia");
        PreparedStatement stm = connection.prepareStatement(ADD_USER);

        stm.setString(1, user.getUsername());
        stm.setString(2, user.getMail());
        stm.setString(3, user.getFirstName());
        stm.setString(4, user.getLastName());
        stm.setString(5, user.getPassword());
        stm.setString(6, user.getProfession());

        stm.executeUpdate();

    }

    public User getUserDataByUsernameOrMail(String unameOrMail) throws SQLException {
        PreparedStatement stm;

        if(unameOrMail.contains("@")){
            stm = connection.prepareStatement(SELECT_USER_BY_MAIL);
        }else{
            stm  = connection.prepareStatement(SELECT_USER_BY_USERNAME);
        }

        stm.setString(1, unameOrMail);

        ResultSet rs = stm.executeQuery();

        if(!rs.next()){
            return null;
        }

        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("password"),
                rs.getString("e_mail"),
                rs.getString("profession")
        );
    }

    public User getUserDataByUsernameAndPassword(String unameOrMail, String password) throws SQLException {
        User user = getUserDataByUsernameOrMail(unameOrMail);
        return (user == null || user.getPassword().equals(password)) ? null : user;
    }

    public void updateUser(User user) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(UPDATE_USER_DATA);

        stm.setString(1, user.getUsername());
        stm.setString(2,user.getMail());
        stm.setString(3,user.getFirstName());
        stm.setString(4, user.getLastName());
        stm.setString(5, user.getPassword());
        stm.setString(6, user.getProfession());
        stm.setLong(7, user.getId());

        stm.executeUpdate();
    }
}
