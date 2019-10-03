package org.remo.daos;

import org.remo.JPAUtil;
import org.remo.dtos.CustomerDTO;
import org.remo.models.Customer;
import org.remo.models.Register;
import org.remo.models.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterDBDAO implements RegisterDAO {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
    private EntityManager em;

    public RegisterDBDAO () {
        em = emf.createEntityManager();
    }

    @Override
    public void registerIn(Customer customer, Vehicle vehicle) {

        em.getTransaction().begin();

        Register reg = new Register();
        reg.setAmount(null);
        reg.setCheckInDateTime(LocalDateTime.now());
        reg.setCustomer(customer);
        reg.setVehicle(vehicle);
        reg.setCheckOutDateTime(null);

        em.persist(reg);//potremmo anche non mettere persist
        em.getTransaction().commit();
    }

    @Override
    public void registerOut(Vehicle vehicle) {

        em.getTransaction().begin();
        Register reg = getRegisterVehicle(vehicle);
        if(reg != null) {
            reg.setCheckOutDateTime(LocalDateTime.now());
            reg.setAmount(new BigDecimal(10));
        }
        em.persist(reg);//potremmo anche non mettere persist
        em.getTransaction().commit();
    }
    //Query jpql
    public Register getRegisterVehicle(Vehicle vehicle) {
        TypedQuery<Register> query = em.createQuery("Select r from Register r where r.vehicle=:vehicle and r.checkOutDateTime is null", Register.class);//in questa query interrogo gli oggetti java (non interrogo tabelle)
        query.setParameter("vehicle", vehicle);
        return query.getSingleResult();

    }
}
