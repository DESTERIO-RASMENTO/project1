package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entities.Customer;

/**
 * Created by VIRUS on 1/7/2019.
 */
public class CustomerServiceClass {
    public void CreateCustomer(String firstname, String surname,
                               String email, String password,String confirmedpassword){
        EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("PROJECT");
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        Customer customer= new Customer();
        customer.setFirstname(firstname);
        customer.setSurname(surname);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setConfirmedpassword(confirmedpassword);

        entitymanager.persist(customer);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }
}
