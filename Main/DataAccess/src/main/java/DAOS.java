import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by dplichta on 2015-08-04.
 */
public class DAOS {
    public String test(){
        Context test = null;
        try {
            test = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        DataSource ds = null;
        try {
            ds = (DataSource)test.lookup("java:comp/env/jdbc/TestDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement sqlStatement = null;
        try {
            conn = ds.getConnection();
            //conn = DriverManager.getConnection("jdbc/TestDB");
            sqlStatement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(conn);
            e.printStackTrace();
        }

// Generate the SQL query.
        String query = "select id, foo, bar from testdata";

// Get the query results and display them.
        String foo = "";
        ResultSet sqlResult = null;
        try {
            sqlResult = sqlStatement.executeQuery(query);
            while(sqlResult.next()) {
               /* uId = sqlResult.getString("id");
                fName = sqlResult.getString("foo");*/
                foo = sqlResult.getString("foo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

// Close the connection.
        try {
            sqlResult.close();
            sqlStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foo;
    }
    public String hello(){
        return "Weeeeaaaeeeeeee";
    }
}
