package projects.singleton.models.vehicles;

public class CargoTruck extends CargoVehicle {

    public CargoTruck(String name, CargoType cargoType, double weight) {
        super(name, cargoType, weight);
    }

    @Override
    public String getInfo() {
        String info = " - Truck ID: " + this.getId() + ";\n"
                + " - Truck Name: " + this.getName() + ";\n"
                + " - Cargo Type: " + this.getCargoType() + ";\n"
                + " - Weight: " + this.getWeight() + ";\n";

        return info;
    }
}
