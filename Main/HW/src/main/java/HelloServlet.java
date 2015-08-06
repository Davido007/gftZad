/**
 * Created by dplichta on 2015-08-04.
 */

import com.gft.dto.AccountDTO;
import com.gft.dto.UserDTO;
import com.gft.entities.AccountEntity;
import com.gft.entities.UserEntity;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"","/home", "*.abc"},
        initParams = {        @WebInitParam(
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
        UserService userService = new UserService();
        List<UserDTO> users = userService.getUsers();
        List<AccountDTO> accounts = userService.getUserAccounts(users.get(0).getID());

        request.setAttribute("users", users);
        request.setAttribute("accounts", accounts);
        request.setAttribute("transactions", userService.getAccountTransactions(accounts.get(0).getID()));
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/user.jsp");

        if (dispatcher != null){
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        if(name != null && name != "") {
            resp.getWriter().printf("Helloo %s", new Object[]{name});
        } else {
            resp.sendRedirect("index.jsp");
        }

    }
}
