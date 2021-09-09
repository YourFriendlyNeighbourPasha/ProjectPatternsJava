package projects.singleton.models.posts;

import projects.singleton.models.DailyStatistics;
import projects.singleton.models.vehicles.CargoVehicle;

import java.util.UUID;

public class DeliveryPost implements Post {

    private final String id = UUID.randomUUID().toString();
    private DailyStatistics statistics;

    public DeliveryPost(DailyStatistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public DailyStatistics getStatistics() {
        return statistics;
    }

    @Override
    public void processCargo(CargoVehicle vehicle) {
        statistics.incrementDeliveriesAmount();
        statistics.increaseWeightOfDeliveries(vehicle.getWeight());
        String logInfo = "========================== INFO BLOCK ==========================\n"
                + "The cargo has been delivered successfully to #" + this.id + ".\n"
                + "Vehicle Info: \n"
                + vehicle.getInfo()
                + "Information has been noted to statistics.\n"
                + "================================================================\n";
        System.out.println(logInfo);
    }

}
