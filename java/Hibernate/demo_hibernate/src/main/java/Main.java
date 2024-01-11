import heritage.joined_table.CreditCardPayment;
import heritage.joined_table.PayPalPayment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            // Exemple joined table :

            CreditCardPayment creditCardPayment = new CreditCardPayment();
            creditCardPayment.setCardNumber("123456");
            creditCardPayment.setAmount(5000.0);
            creditCardPayment.setPaymentDate(new Date());
            creditCardPayment.setExpirationDate("12/2025");


            PayPalPayment payPalPayment = new PayPalPayment();
            payPalPayment.setAccountNumber("45879");
            payPalPayment.setPaymentDate(new Date());
            payPalPayment.setAmount(9854.5);

            session.save(creditCardPayment);
            session.save(payPalPayment);


            System.out.println("creditCardPayment " + creditCardPayment);
            System.out.println("payPalPayment " + payPalPayment);
            tx.commit();

        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }


    }
}
