package projects.singleton.models.vehicles;

import java.util.UUID;

public abstract class CargoVehicle {

    private final String id = UUID.randomUUID().toString();
    private String name;
    private CargoType cargoType;
    private double weight;

    public CargoVehicle(String name, CargoType cargoType, double weight) {
        this.name = name;
        this.cargoType = cargoType;
        this.weight = weight;
    }

    public abstract String getInfo();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
