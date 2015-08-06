/**
 * Created by dplichta on 2015-08-04.
 */

import com.gft.dto.AccountDTO;
import com.gft.dto.TransactionDTO;
import com.gft.dto.UserDTO;
import com.gft.entities.AccountEntity;
import com.gft.entities.UserEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"/home", "*.abc", "/login"},
        initParams = {@WebInitParam(
                name = "ProductName",
                value = "Welcome Application"
        )}
)
public class HelloServlet extends HttpServlet {
    String appName = "MyApp";

    public HelloServlet() {
    }

    /*    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            Business business;
            business = new Business();
            //resp.getWriter().write(business.hello());
            resp.getWriter().write(business.foo());
        }*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*UserService userService = new UserService();
        List<UserDTO> users = userService.getUsers();
        List<AccountDTO> accounts = userService.getUserAccounts(users.get(0).getID());*/

        /*request.setAttribute("users", users);
        request.setAttribute("accounts", accounts);
        request.setAttribute("transactions", userService.getAccountTransactions(accounts.get(0).getID()));*/
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/user.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fullName = request.getParameter("name");
        String[] fullNameArray = request.getParameter("name").split("\\.");
        String name = "";
        String surname = "";
        UserService userService = new UserService();
        UserDTO user = null;
        List<AccountDTO> accounts = null;
        Map<AccountDTO, List<TransactionDTO>> allTransactions = null;
        if (fullNameArray.length >= 2) {
            name = fullNameArray[0];
            surname = fullNameArray[1];
            user = userService.getUserByFullName(name, surname);
        }

        if (user != null) {
            accounts = userService.getUserAccounts(user.getID());
            allTransactions = new HashMap<AccountDTO, List<TransactionDTO>>();
            for (AccountDTO account : accounts) {
                allTransactions.put(account, userService.getAccountTransactions(account.getID()));
            }
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("accounts", accounts);
            request.getSession().setAttribute("transactions", allTransactions);
            response.sendRedirect("/home");
        } else {
           /* request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/index.jsp").forward(request, response);*/
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("surname", surname);
            response.sendRedirect("/signup");
        }

    }
}
