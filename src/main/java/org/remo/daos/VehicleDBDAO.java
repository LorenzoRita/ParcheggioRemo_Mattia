package org.remo.daos;

import org.remo.JPAUtil;
import org.remo.dtos.VehicleDTO;
import org.remo.models.Car;
import org.remo.models.Roulotte;
import org.remo.models.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class VehicleDBDAO implements VehicleDAO {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
    private EntityManager em;

    public VehicleDBDAO () {
        em = emf.createEntityManager();
    }

    @Override
    public Vehicle save(VehicleDTO vehicleDto) {
        em.getTransaction().begin();
        Vehicle vehicle = null;
        if(vehicleDto.getVehicleType().equals("C")) {
            vehicle = new Car();
        }
        if(vehicleDto.getVehicleType().equals("R")) {
            vehicle = new Roulotte();
        }
        vehicle.setLicensePlate(vehicleDto.getLicesePlate());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setObsolete(false);

        em.persist(vehicle);

        em.getTransaction().commit();

        return vehicle;
    }

    @Override
    public Vehicle getVehicleByDTO(VehicleDTO vehicleDTO) {
        return em.find(Vehicle.class, vehicleDTO.getId());
    }

    //oppure si poteva scrivere così:
    /*@Override
    public Vehicle getVehicleByLicense(VehicleDTO vehicleDTO) {
        TypedQuery<Vehicle> query =
                em.createQuery("Select v from Vehicle v where v.licensePlate=:licensePlate", Vehicle.class);
        query.setParameter("licensePlate", vehicleDTO.getLicensePlate());
        return query.getSingleResult();
    }*/
}
