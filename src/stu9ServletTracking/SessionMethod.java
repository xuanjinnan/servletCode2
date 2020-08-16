package stu9ServletTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SessionMethod")
public class SessionMethod extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("visitCount");
//        session.invalidate();
        session.setMaxInactiveInterval(9000);
    }

    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println("lmd表达式!");
        };
        new Thread(runnable).start();
    }
}
