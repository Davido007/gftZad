package com.gft.repositories;

/**
 * Created by dplichta on 2015-08-05.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gft.com.gft.converters.TransactionEntityConverter;
import com.gft.com.gft.db.DatabaseAccess;
import com.gft.com.gft.dto.TransactionServiceDTO;
import com.gft.entities.AccountEntity;
import com.gft.entities.TransactionEntity;

public class TransactionRepository {
    public List<TransactionServiceDTO> getTransactionsByAccountId(int accountId) {
        Connection connection = DatabaseAccess.getConnection();
        List<TransactionServiceDTO> transasctions = new ArrayList<TransactionServiceDTO>();

        ResultSet sqlResult = null;
        try {
            String query = "SELECT ID, TransactionDate, Amount, AccountID FROM transaction WHERE AccountId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, accountId);

            sqlResult = statement.executeQuery();

            while (sqlResult.next()) {
                TransactionEntityConverter transactionEntityConverter = new TransactionEntityConverter();
                TransactionEntity transaction = new TransactionEntity();
                transaction.setDate(new Date(sqlResult.getDate("TransactionDate").getTime()));
                transaction.setAmount(sqlResult.getDouble("Amount"));
                transaction.setID(sqlResult.getInt("ID"));
                transaction.setAccountId(sqlResult.getInt("AccountID"));
                transasctions.add(transactionEntityConverter.convert(transaction));
            }

            sqlResult.close();
            statement.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        DatabaseAccess.closeConenction(connection);

        return transasctions;
    }
}
