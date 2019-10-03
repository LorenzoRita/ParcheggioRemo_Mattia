package org.remo.daos;

import org.remo.JPAUtil;
import org.remo.dtos.CustomerDTO;
import org.remo.models.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CustomerDBDAO implements CustomerDAO {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
    private EntityManager em;

    public CustomerDBDAO () {
        em = emf.createEntityManager();
    }

    @Override
    public Customer save(CustomerDTO customerDto) {
        em.getTransaction().begin();

        Customer customer = new Customer();
        customer.setFirstname(customerDto.getFirstName());
        customer.setLastname(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setSsn(customerDto.getSsn());
        customer.setObsolete(customerDto.isObsolete());

        em.persist(customer);

        em.getTransaction().commit();
        return customer;
    }

    @Override
    public List<CustomerDTO> getCustomerBySSN(String ssn) {
        return null;
    }

    @Override
    public List<CustomerDTO> getCustomerByEmail(String email) {
        return null;
    }

    @Override
    public void remove(CustomerDTO customerDto) {

    }
}
