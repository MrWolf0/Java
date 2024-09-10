package hibernate;

import DataModel.UserModel;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        UserModel user1 = new UserModel ("nasser","basha","Mrwolf","nassermessi33@gmail.com");
        UserModel user2 = new UserModel ("leo","messi","messi10","messi2024@gmail.com");
        //Persist the user Objects
        Transaction transaction = null;
       try
       {
           Session session = HibernateUtil.getSessionFactory ().openSession ();
           transaction = session.beginTransaction ();
           session.persist (user1);
           session.persist (user2);
           transaction.commit ();
       }
       catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           e.printStackTrace();
       }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List< UserModel > users = session.createQuery("from UserModel ", UserModel.class).list();
            users.forEach(u -> System.out.println(u.getFname()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}