package org.remo.daos;

import org.remo.dtos.CustomerDTO;
import org.remo.models.Customer;
import org.remo.models.Register;
import org.remo.models.Vehicle;

public interface RegisterDAO {
    void registerIn(Customer customer, Vehicle vehicle);
    void registerOut(Vehicle vehicle);

    Register getRegisterVehicle(Vehicle vehicle);
}
