/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Payment;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author mrkjse
 */
public class PaymentController {
     EntityManagerFactory emfactory = null;
    
    @PersistenceUnit(unitName="HotelManagementSystemPUB")
    EntityManager entitymanager = null;
    
    public PaymentController(EntityManagerFactory emf)
    {
        if (!emf.isOpen())
        {
            // Should throw an error
            emfactory = null;
        }
        emfactory = emf;
        entitymanager = emfactory.createEntityManager( );
    }
    
    public void close()
    {
        entitymanager.close();
    }
    
    public List<Payment> getPayments()
    {   
        List<Payment> payments = null;
        
        try
        {
            entitymanager.getTransaction( ).begin( );

            payments = entitymanager.createNamedQuery("Payment.findAll").getResultList();

            if (payments.size() > 0)
            {
                
            }

            entitymanager.getTransaction( ).commit( );
        }
        catch (Exception e)
        {
            
        }
      
      return payments;
    }
    
    public List<Payment> getPaymentsByBookingId(int bookingId)
    {   
        List<Payment> payments = null;
        
        try
        {
            entitymanager.getTransaction( ).begin( );

            payments = entitymanager.createNamedQuery("Payment.findByBookingId").setParameter("bookingId", bookingId).getResultList();

            if (payments.size() > 0)
            {

            }

            entitymanager.getTransaction( ).commit( );
        }
        catch (Exception e)
        {
            
        }
      
      return payments;
    }
    
    
    public boolean createPayment(Payment payment)
    {
        try
        {
            entitymanager.getTransaction( ).begin( );
            entitymanager.persist( payment );
            entitymanager.getTransaction( ).commit( );
            
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public boolean deletePayment(Payment payment)
    {
        try
        {
            entitymanager.getTransaction( ).begin( );

            // Find the Payment first
            Payment dataPayment = entitymanager.find( Payment.class, payment.getPaymentPK() );

            if (dataPayment != null)
            {
                entitymanager.remove( payment );
            }
            
            entitymanager.getTransaction( ).commit( );
            
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public Payment updatePayment(Payment newPayment)
    {
        Payment paymentData = null;
        
        try
        {
            entitymanager.getTransaction( ).begin( );
            
            paymentData = entitymanager.find( Payment.class, newPayment.getPaymentPK() );

            if (paymentData != null)
            {
                paymentData.setPaymentAmount(newPayment.getPaymentAmount());
                paymentData.setPaymentDate(newPayment.getPaymentDate());
                paymentData.setPaymentMethodCode(newPayment.getPaymentMethodCode());
            }
            
            entitymanager.getTransaction( ).commit( );

        }
        catch (Exception e)
        {
        }
        
        return paymentData;
    }
    
    // findPaymentByBooking
    
    public static void main(String args[]) {
         
        
         EntityManagerFactory emfactoryb = Persistence.createEntityManagerFactory( "HotelManagementSystemPUB" );
         PaymentController x = new PaymentController(emfactoryb);
         
         List<Payment> newPayments = x.getPayments();
         
         x.close();
         
     }

}
