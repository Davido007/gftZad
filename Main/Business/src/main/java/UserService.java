/**
 * Created by dplichta on 2015-08-05.
 */
import com.gft.com.gft.dto.AccountServiceDTO;
import com.gft.com.gft.dto.TransactionServiceDTO;
import com.gft.com.gft.dto.UserServiceDTO;
import com.gft.converters.AccountServiceConverter;
import com.gft.converters.TransactionServiceConverter;
import com.gft.converters.UserServiceConverter;
import com.gft.dto.AccountDTO;
import com.gft.dto.TransactionDTO;
import com.gft.dto.UserDTO;
import com.gft.repositories.AccountRepository;
import com.gft.repositories.TransactionRepository;
import com.gft.repositories.UserRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;


import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserRepository userRepo = null;
    AccountRepository accountRepo = null;
    TransactionRepository transactionRepo = null;

    public UserService() {
        userRepo = new UserRepository();
        accountRepo = new AccountRepository();
        transactionRepo = new TransactionRepository();
    }

    public List<UserDTO> getUsers() {
        UserServiceConverter userServiceConverter = new UserServiceConverter();
        return (List)userServiceConverter.convertCollection(userRepo.getAllUsers());
    }

    public List<AccountDTO> getUserAccounts(int userId) {
        AccountServiceConverter accountServiceConverter = new AccountServiceConverter();
        return (List)accountServiceConverter.convertCollection(accountRepo.getAccountsByUserId(userId));
    }

    public List<TransactionDTO> getAccountTransactions(int accountId) {
        TransactionServiceConverter transactionServiceConverter = new TransactionServiceConverter();
        return (List)transactionServiceConverter.convertCollection(transactionRepo.getTransactionsByAccountId(accountId));
    }

}

