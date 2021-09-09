package projects.singleton;

import projects.singleton.helpers.SingletonEqualChecker;
import projects.singleton.helpers.ThreadHelper;
import projects.singleton.models.DailyStatistics;
import projects.singleton.models.posts.DeliveryPost;
import projects.singleton.models.posts.DispatchPost;
import projects.singleton.models.posts.Post;
import projects.singleton.models.vehicles.CargoBoat;
import projects.singleton.models.vehicles.CargoTruck;
import projects.singleton.models.vehicles.CargoType;
import projects.singleton.models.vehicles.CargoVehicle;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        CargoTruck truck1 = new CargoTruck("Volvo", CargoType.Simple, 16.5);
        CargoTruck truck2 = new CargoTruck("DAF", CargoType.Fragile, 12.7);

        CargoBoat boat1 = new CargoBoat("Maersk", CargoType.Fragile, 20.3);
        CargoBoat boat2 = new CargoBoat("Evergreen", CargoType.Simple, 25.8);

        List<CargoVehicle> vehicles = new ArrayList<CargoVehicle>();
        vehicles.add(truck1);
        vehicles.add(truck2);
        vehicles.add(boat1);
        vehicles.add(boat2);

        DeliveryPost deliveryPost1 = new DeliveryPost(DailyStatistics.getInstance());
        DeliveryPost deliveryPost2 = new DeliveryPost(DailyStatistics.getInstance());
        DeliveryPost deliveryPost3 = new DeliveryPost(DailyStatistics.getInstance());

        DispatchPost dispatchPost1 = new DispatchPost(DailyStatistics.getInstance());
        DispatchPost dispatchPost2 = new DispatchPost(DailyStatistics.getInstance());
        DispatchPost dispatchPost3 = new DispatchPost(DailyStatistics.getInstance());

        List<Post> posts = new ArrayList<Post>();
        posts.add(deliveryPost1);
        posts.add(deliveryPost2);
        posts.add(deliveryPost3);
        posts.add(dispatchPost1);
        posts.add(dispatchPost2);
        posts.add(dispatchPost3);

        ThreadHelper.initializeTask(10, vehicles, posts);

        System.out.println("test1 = " +
                SingletonEqualChecker.checkSingletonForEqualityBetweenTwoPosts(deliveryPost1, dispatchPost2));
        System.out.println("test2 = " +
                SingletonEqualChecker.checkSingletonForEqualityBetweenTwoPosts(deliveryPost3, dispatchPost3));
        System.out.println("test3 = " +
                SingletonEqualChecker.checkSingletonForEqualityBetweenTwoPosts(deliveryPost2, dispatchPost1));
        System.out.println("test4 = " +
                SingletonEqualChecker.checkSingletonForEqualityBetweenTwoPosts(deliveryPost1, dispatchPost3));

        System.out.println("test5 = " +
                SingletonEqualChecker.checkSingletonForEqualityWithGlobalAccessPoint(deliveryPost1));
        System.out.println("test6 = " +
                SingletonEqualChecker.checkSingletonForEqualityWithGlobalAccessPoint(dispatchPost2));
        System.out.println("test7 = " +
                SingletonEqualChecker.checkSingletonForEqualityWithGlobalAccessPoint(deliveryPost3));


        DailyStatistics.getInstance().reset();
        System.out.println(DailyStatistics.getInstance().getInfo());
    }
}
