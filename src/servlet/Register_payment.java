package servlet;

import bean.Payment;
import bean.Users;
import dao.PaymentDao;
import dao.UsersDao;
import dao.imp.UsersDaoImp;
import dao.imp.paymentDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class Register_payment extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String payment_id= request.getParameter("payment_id");
        String user_id= request.getParameter("user_id");
        String course_id= request.getParameter("course_id");
        String date = request.getParameter("date");
        String amounte = request.getParameter("amounte");
        String type=request.getParameter("type");
        String remaeks = request.getParameter("remaeks");

        Payment payment = new Payment();
        payment.setUser_id(user_id);
        payment.setCourse_id(course_id);
        payment.setPayment_id(payment_id);
        payment.setType(type);
        payment.setDate(date);
        payment.setAmount(amounte);
        payment.setRemarks(remaeks);


        PaymentDao ud = new paymentDaoImp();

        if(ud.register(payment)){
            request.getRequestDispatcher("/User.jsp").forward(request, response);
        }else{

            response.sendRedirect("Failed.jsp");
        }
    }
}
