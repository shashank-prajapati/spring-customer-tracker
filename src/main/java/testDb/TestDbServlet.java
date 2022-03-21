package testDb;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimeZone=UTC";

        String driver = "com.mysql.cj.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();

            out.println("Connecting to db "+ jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            out.println("Connection Successful");

            myConn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
