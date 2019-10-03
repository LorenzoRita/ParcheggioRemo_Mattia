package org.remo.models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "R")
@Table(name ="roulottes")
public class Roulotte extends Vehicle {
    public Roulotte() {}

    public Roulotte(String licesePlate, String model) {
        super(licesePlate, model);
    }

    public String getType() {
        return "Roulotte";
    }
}
