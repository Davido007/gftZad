package com.gft.repositories;

/**
 * Created by dplichta on 2015-08-05.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gft.com.gft.converters.UserEntityConverter;
import com.gft.com.gft.db.DatabaseAccess;
import com.gft.com.gft.dto.UserServiceDTO;
import com.gft.entities.UserEntity;

public class UserRepository {

    public List<UserServiceDTO> getAllUsers() {
        Connection connection = DatabaseAccess.getConnection();
        List<UserServiceDTO> users = new ArrayList<UserServiceDTO>();

        Statement sqlStatement = null;
        ResultSet sqlResult = null;
        try {
            sqlStatement = connection.createStatement();
            String query = "SELECT ID, FirstName, Surname FROM user";

            sqlResult = sqlStatement.executeQuery(query);

            while (sqlResult.next()) {
                UserEntityConverter userEntityConverter = new UserEntityConverter();
                UserEntity user = new UserEntity();
                user.setFirstName(sqlResult.getString("FirstName"));
                user.setSurname(sqlResult.getString("Surname"));
                user.setID(sqlResult.getInt("ID"));
                users.add(userEntityConverter.convert(user));
            }

            sqlResult.close();
            sqlStatement.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        DatabaseAccess.closeConenction(connection);

        return users;
    }

    public UserServiceDTO getUserByFullName(String name, String surname) {
        Connection connection = DatabaseAccess.getConnection();
        UserServiceDTO userServiceDTO = null;

        ResultSet sqlResult = null;
        try {
            String query = "SELECT ID, FirstName, Surname FROM user WHERE FirstName = ? AND Surname = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);

            sqlResult = statement.executeQuery();

           /* UserEntityConverter userEntityConverter = new UserEntityConverter();
            UserEntity user = new UserEntity();
            if(sqlResult != null) {
                user.setFirstName(sqlResult.getString("FirstName"));
                user.setSurname(sqlResult.getString("Surname"));
                user.setID(sqlResult.getInt("ID"));
            }
            userServiceDTO = userEntityConverter.convert(user);*/

            while (sqlResult.next()) {
                UserEntityConverter userEntityConverter = new UserEntityConverter();
                UserEntity user = new UserEntity();
                user.setFirstName(sqlResult.getString("FirstName"));
                user.setSurname(sqlResult.getString("Surname"));
                user.setID(sqlResult.getInt("ID"));
                userServiceDTO = userEntityConverter.convert(user);
            }

            sqlResult.close();
            statement.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        DatabaseAccess.closeConenction(connection);
        return userServiceDTO;
    }

    public void addUser(String name, String surname) {
        Connection connection = DatabaseAccess.getConnection();
        try {
            String query = "INSERT INTO user (FirstName, Surname) VALUES (?,?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        DatabaseAccess.closeConenction(connection);
    }

}
