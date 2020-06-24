package servlet;

import dao.CoursesDao;
import dao.imp.CoursesDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class CoursesUpdate extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name=request.getParameter("name");
        String category=request.getParameter("category");
        String table_of_content=request.getParameter("table_of_content");
        String course_fees=request.getParameter("course_fees");
        BigDecimal fee=new BigDecimal(course_fees);

        CoursesDao ud = new CoursesDaoImp();

        if(ud.update(id,name,category,table_of_content,fee)){
            //request.setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("/Admin.jsp").forward(request, response);
        }else{
            response.sendRedirect("failed.jsp");
        }
    }
}
