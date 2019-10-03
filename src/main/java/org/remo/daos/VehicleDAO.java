package org.remo.daos;

import org.remo.dtos.VehicleDTO;
import org.remo.models.Vehicle;

public interface VehicleDAO {
    Vehicle save(VehicleDTO vehicleDto);
    Vehicle getVehicleByDTO(VehicleDTO vehicleDTO);
}
