package dao.imp;

import bean.Payment;
import dao.PaymentDao;
import util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class paymentDaoImp implements PaymentDao {
    @Override
    public boolean login(String name, String pwd) {
        return false;
    }

    @Override
    public boolean register(Payment payment) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into payment(Payment_Id,User_ID,Course_ID,Payment_Date,Payment_Amount,Payment_Type,Payment_Remarks) "+
                "values('"+payment.getPayment_id()+"" +
                "','"+payment.getUser_id()+"" +
                "','"+payment.getCourse_id()+"" +
                "','"+payment.getDate()+"" +
                "','"+payment.getAmount()+""+
                "','"+payment.getType()+""+
                "','"+payment.getRemarks()+""+
                "')");
        if(i>0){
            flag = true;
        }
        else{
            System.out.println("insert error");
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Payment> getUserAll() {
        List<Payment> list = new ArrayList<Payment>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from payment");
            while(rs.next()){
                Payment payment=new Payment();
                payment.setPayment_id(rs.getString("Payment_Id"));
                payment.setUser_id(rs.getString("User_ID"));
                payment.setCourse_id(rs.getString("Course_ID"));
                payment.setDate(rs.getString("Payment_Date"));
                payment.setAmount(rs.getString("Payment_Amount"));
                payment.setType(rs.getString("Payment_Type"));
                payment.setRemarks(rs.getString("Payment_Remarks"));
                list.add(payment);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from payment where Payment_Id="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String pm_id, String user_id, String course_id, Date date, String amount, String type, String remarks) {
        return false;
    }
}
