import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dplichta on 2015-08-06.
 */
@WebServlet(
        urlPatterns = {"/signup"},
        initParams = {@WebInitParam(
                name = "SignUpServlet",
                value = "SignUp form"
        )}
)
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        UserService userService = new UserService();
        userService.addUser(name, surname);
        userService.addAccount(userService.generateAccountNumber(),0.0,userService.getUserByFullName(name,surname).getID());
        response.sendRedirect("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signUp.jsp").forward(request, response);
    }
}
