package servlet;

import bean.Users;
import dao.UsersDao;
import dao.imp.UsersDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register_user extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id= request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone=request.getParameter("phone");
        String email = request.getParameter("email");
        String type="user";
        Users user = new Users();
        user.setId(id);
        user.setPassword(password);
        user.setUser_type(type);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);

        UsersDao ud = new UsersDaoImp();

        if(ud.register(user)){
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }else{

            response.sendRedirect("Failed.jsp");
        }
    }

}
