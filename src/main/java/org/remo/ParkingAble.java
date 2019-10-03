package org.remo;


import org.remo.dtos.CustomerDTO;
import org.remo.dtos.VehicleDTO;
import org.remo.exceptions.CantWayInException;
import org.remo.exceptions.CantWayOutException;
import org.remo.exceptions.TooManyVeichlesInException;
import org.remo.models.Vehicle;

public interface ParkingAble {

    void checkIn(VehicleDTO vehicleDto, CustomerDTO customerDTO) throws CantWayInException, TooManyVeichlesInException;
    void checkOut(VehicleDTO vehicleDto) throws CantWayOutException;
}
