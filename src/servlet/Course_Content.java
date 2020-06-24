package servlet;

import dao.CoursesDao;
import dao.imp.CoursesDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Course_Content extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");


        HttpSession session = request.getSession();
        session.setAttribute("id", id);


            request.getRequestDispatcher("/Course_content.jsp").forward(request, response);

    }
}
