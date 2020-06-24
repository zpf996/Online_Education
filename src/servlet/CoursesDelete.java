package servlet;

import dao.CoursesDao;
import dao.imp.CoursesDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CoursesDelete extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        CoursesDao ud = new CoursesDaoImp();

        if(ud.delete(id)){
            //request.setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("/Admin.jsp").forward(request, response);
        }else{
            response.sendRedirect("failed.jsp");
        }
    }
}
