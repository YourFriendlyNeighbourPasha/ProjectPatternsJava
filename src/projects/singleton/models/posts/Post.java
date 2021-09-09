package projects.singleton.models.posts;

import projects.singleton.models.DailyStatistics;
import projects.singleton.models.vehicles.CargoVehicle;

public interface Post {
    DailyStatistics getStatistics();

    void processCargo(CargoVehicle vehicle);
}
