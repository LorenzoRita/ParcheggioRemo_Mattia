package org.remo;



import org.remo.dtos.CustomerDTO;
import org.remo.dtos.VehicleDTO;
import org.remo.exceptions.CantWayInException;
import org.remo.exceptions.TooManyVeichlesInException;
import org.remo.models.Car;
import org.remo.models.Roulotte;
import org.remo.models.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

public class GoParking {

    public static void main(String[] args) {

        Map<Class<? extends Vehicle>, Integer> maxAvailableSeats = new HashMap<>();
        maxAvailableSeats.put(Car.class, 55);
        maxAvailableSeats.put(Roulotte.class, 10);

        // collego il parcheggio all'area del parcheggio
        ParkingAble parking = new Parking(new ParkingMap(maxAvailableSeats));

        trials(parking);

        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }


    /**
     * Esegue i test
     *
     * @param parking
     */
    public static void trials(ParkingAble parking)  {

        VehicleDTO macchina1 = new VehicleDTO(null, "AB123CD", "fiesta","C",false );
/*        Vehicle macchina1 = new Car("LT 5888493", "fiesta");
        Vehicle macchina2 = new Car("RM 88E6833", "ferrari");
        Vehicle macchina3 = new Car("VE 1988493", "Mazda");
        Vehicle macchina4 = new Car("SA F488493", "maggiolino");

        Vehicle roulotte1 = new Roulotte("MO CE99443", "Roulotte Lux");
        Vehicle roulotte2 = new Roulotte("XE AHH8493", "Roulotte Poor");*/

        CustomerDTO customer1 = new CustomerDTO(null,"Paolo","Rossi","qwertyuiopasdfgh","paolorossi@bo.it",false);

        try {

            /* entra la prima macchina */
            parking.checkIn(macchina1,customer1);


            /* entra la seconda macchina *//*
            parking.checkIn(macchina2);

            *//* entra la Terza macchina *//*
            parking.checkIn(macchina3);

            *//* entra la Quarta macchina *//*
            parking.checkIn(macchina4);
            parking.checkIn(macchina4);

            *//* entra la prima roulotte *//*
            parking.checkIn(roulotte1);
            *//* entra la seconda roulotte *//*
            parking.checkIn(roulotte2);*/

        } catch (CantWayInException | TooManyVeichlesInException e) {
            System.out.println("(ERRORE) " + e.getMessage());
        }

        /*try {

            *//* esce la seconda macchina *//*
            parking.checkOut(macchina2);

            *//* esce di nuovo la seconda macchina *//*
            parking.checkOut(macchina2);

        } catch (CantWayOutException e) {
            System.out.println("(ERRORE) " + e.getMessage());
        }*/
    }

}
