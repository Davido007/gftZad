package com.gft.repositories;

/**
 * Created by dplichta on 2015-08-05.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gft.com.gft.converters.AccountEntityConverter;
import com.gft.com.gft.db.DatabaseAccess;
import com.gft.com.gft.dto.AccountServiceDTO;
import com.gft.entities.AccountEntity;
import com.gft.entities.UserEntity;

public class AccountRepository {

    public List<AccountServiceDTO> getAccountsByUserId(int userId) {
        Connection connection = DatabaseAccess.getConnection();
        List<AccountServiceDTO> accounts = new ArrayList<AccountServiceDTO>();

        ResultSet sqlResult = null;
        try {
            String query = "SELECT ID, Number, Balance, UserID FROM account WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            sqlResult = statement.executeQuery();

            while (sqlResult.next()) {
                AccountEntityConverter accountEntityConverter = new AccountEntityConverter();
                AccountEntity account = new AccountEntity();
                account.setNumber(sqlResult.getString("Number"));
                account.setBalance(sqlResult.getDouble("Balance"));
                account.setID(sqlResult.getInt("ID"));
                account.setUserId(sqlResult.getInt("UserID"));
                accounts.add(accountEntityConverter.convert(account));
            }

            sqlResult.close();
            statement.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        DatabaseAccess.closeConenction(connection);
        return accounts;
    }
}
