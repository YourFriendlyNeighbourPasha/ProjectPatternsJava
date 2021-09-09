package projects.singleton.models.vehicles;

public class CargoBoat extends CargoVehicle {

    public CargoBoat(String name, CargoType cargoType, double weight) {
        super(name, cargoType, weight);
    }

    @Override
    public String getInfo() {
        String info = " - Boat ID: " + this.getId() + ";\n"
                + " - Boat Name: " + this.getName() + ";\n"
                + " - Cargo Type: " + this.getCargoType() + ";\n"
                + " - Weight: " + this.getWeight() + ";\n";

        return info;
    }
}
