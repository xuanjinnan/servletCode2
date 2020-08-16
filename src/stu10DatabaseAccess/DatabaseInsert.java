package stu10DatabaseAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DatabaseInsert")
public class DatabaseInsert extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
    static final String USER = "root";
    static final String PASS = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Connection conn = null;
        PreparedStatement prestmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prestmt = conn.prepareStatement("insert into websites (name, url, alexa, country) values (?,?,?,?)");
            prestmt.setString(1,req.getParameter("name"));
            prestmt.setString(2,req.getParameter("url"));
            prestmt.setString(3,req.getParameter("alexa"));
            prestmt.setString(4,req.getParameter("country"));
            prestmt.executeUpdate();
            prestmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(prestmt != null){
                try {
                    prestmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    resp.sendRedirect("DatabaseAccess");

}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
