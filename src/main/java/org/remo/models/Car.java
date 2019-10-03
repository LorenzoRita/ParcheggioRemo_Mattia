package org.remo.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "C")
@Table(name = "cars")
public class Car extends Vehicle {


    public Car() {
    }

    public Car(String licesePlate, String model) {
        super(licesePlate, model);
    }

    public String getType() {
        return "Automobile";
    }
}
