package servlet;

import bean.Users;
import dao.UsersDao;
import dao.imp.UsersDaoImp;
import util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Login extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        UsersDao ud=new UsersDaoImp();
        Users users=new Users();
        List<Users> userAll = ud.getUserAll();

        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from users where User_ID='"+name+"' and Password='"+password+"'");

            while(rs.next()){
                if(rs.getString("User_ID").equals(name) && rs.getString("Password").equals(password)) {
                    if (rs.getString("User_Type").equals("admin")) {

                        request.getRequestDispatcher("Admin.jsp").forward(request,response);
                    }
                    else{
                        HttpSession session = request.getSession();
                        session.setAttribute("name", name);
                        //request.setAttribute("name", userAll);
                        //response.sendRedirect("User.jsp");
                        request.getRequestDispatcher("/User.jsp").forward(request,response);
                    }
                }
                else{
                    response.sendRedirect("failed.jsp");
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //request.setAttribute("userAll", userAll);

    }
}
