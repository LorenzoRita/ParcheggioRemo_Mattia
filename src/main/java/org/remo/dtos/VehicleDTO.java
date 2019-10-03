package org.remo.dtos;


import org.remo.models.Vehicle;

public class VehicleDTO {

    private Long id;
    private String licesePlate;
    private String model;
    private String vehicleType;
    private boolean isObsolete;

    public VehicleDTO() {}


    public VehicleDTO(Long id, String licesePlate, String model, String vehicleType, boolean isObsolete) {
        this.id = id;
        this.licesePlate = licesePlate;
        this.model = model;
        this.vehicleType = vehicleType;
        this.isObsolete = isObsolete;
    }

    public String getLicesePlate() {
        return licesePlate;
    }

    public void setLicesePlate(String licesePlate) {
        this.licesePlate = licesePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isObsolete() {
        return isObsolete;
    }

    public void setObsolete(boolean obsolete) {
        isObsolete = obsolete;
    }

    public Long getId() {
        return id;
    }
}
