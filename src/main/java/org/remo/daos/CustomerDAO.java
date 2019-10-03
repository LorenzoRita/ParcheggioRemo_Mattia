package org.remo.daos;

import org.remo.dtos.CustomerDTO;
import org.remo.models.Customer;

import java.util.List;

public interface CustomerDAO {

    Customer save(CustomerDTO customerDto);
    List<CustomerDTO> getCustomerBySSN(String ssn);
    List<CustomerDTO> getCustomerByEmail(String email);
    void remove(CustomerDTO customerDto);

}
