package org.remo;


import org.remo.daos.*;
import org.remo.dtos.CustomerDTO;
import org.remo.dtos.VehicleDTO;
import org.remo.exceptions.CantWayInException;
import org.remo.exceptions.CantWayOutException;
import org.remo.exceptions.TooManyVeichlesInException;
import org.remo.models.Customer;
import org.remo.models.Vehicle;


public class Parking implements ParkingAble{

    private IParkingMap parkingMap;


    public Parking(ParkingMap parkingMap) {
        this.parkingMap = parkingMap;
    }


    /**
     * gestisce l'entrata di un automezzo al parcheggio
     *
     * @param vehicleDto
     * @throws CantWayInException
     */
    public void checkIn(VehicleDTO vehicleDto, CustomerDTO customerDTO) throws CantWayInException, TooManyVeichlesInException {
        CustomerDAO customerDao = new CustomerDBDAO();
        Customer customer = customerDao.save(customerDTO);

        VehicleDAO vehicleDao = new VehicleDBDAO();
        Vehicle vehicle = vehicleDao.save(vehicleDto);

        RegisterDAO registerDao = new RegisterDBDAO();


        parkingMap.wayIn(vehicle);

        registerDao.registerIn(customer,vehicle);

        System.out.println("Il veicolo di tipo " + vehicle.getType() + " con targa "+ vehicle.getLicensePlate() + " è entrato nel parcheggio");
    }


    /**
     * gestisce l'euscita di un automezzo al parcheggio
     *
     * @param vehicleDto
     * @throws CantWayOutException
     */
    @Override
    public void checkOut(VehicleDTO vehicleDto) throws CantWayOutException {
        RegisterDAO registerDao = new RegisterDBDAO();
        VehicleDAO vehicleDao = new VehicleDBDAO();
        Vehicle vehicle = vehicleDao.getVehicleByDTO(vehicleDto);
        registerDao.registerOut(vehicle);

        parkingMap.wayOut(vehicle);
        System.out.println("Il veicolo di tipo " + vehicle.getType() + " con targa "+ vehicle.getLicensePlate() + " è uscito dal parcheggio");
    }
}
