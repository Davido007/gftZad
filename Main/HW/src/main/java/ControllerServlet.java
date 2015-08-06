/**
 * Created by dplichta on 2015-08-04.
 */


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "ControllerServlet",
        urlPatterns = {"*.do"}
)
public class ControllerServlet extends HttpServlet {
    public ControllerServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName("Kevin");
        user.setSurname("Kowalski");
        AccountData accData = new AccountData();
        accData.setAccNumber(1112221111L);
        accData.setBalance(-3213.0F);
        ArrayList transactions = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        sdf.format(new Date());
        Transaction tr1 = null;
        Transaction tr2 = null;

        try {
            tr1 = new Transaction(sdf.parse("18/07/1991"), -100.0F);
        } catch (ParseException var12) {
            var12.printStackTrace();
        }

        try {
            tr2 = new Transaction(sdf.parse("18/08/1991"), -300.0F);
        } catch (ParseException var11) {
            var11.printStackTrace();
        }

        transactions.add(tr1);
        transactions.add(tr2);
        user.setAccData(accData);
        user.setTransactions(transactions);
        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        request.setAttribute("user", user);
        requestDispatcher.forward(request, response);
    }
}

