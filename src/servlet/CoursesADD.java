package servlet;

import bean.Courses;
import dao.CoursesDao;
import dao.imp.CoursesDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class CoursesADD extends HttpServlet {
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
        Courses courses=new Courses();
        courses.setId(id);
        courses.setName(name);
        courses.setTable_of_content(table_of_content);
        courses.setCategory(category);
        courses.setFees(fee);
        CoursesDao ud = new CoursesDaoImp();

        if(ud.register(courses)){
            //request.setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("/Admin.jsp").forward(request, response);
        }else{
            response.sendRedirect("failed.jsp");
        }
    }
}
