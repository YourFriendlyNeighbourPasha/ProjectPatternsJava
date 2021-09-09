package projects.singleton.helpers;

import projects.singleton.models.DailyStatistics;
import projects.singleton.models.posts.Post;
import projects.singleton.models.vehicles.CargoVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadHelper {


    public static void initializeTask(int amount, List<CargoVehicle> vehicles, List<Post> posts) {
        List<Thread> threads = initializeThreads(amount, vehicles, posts);
        try {
            for (Thread t : threads) {
                t.start();
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<Thread> initializeThreads(int amount, List<CargoVehicle> vehicles, List<Post> posts) {
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < amount; i++) {
            Post post = pickRandom(posts);
            CargoVehicle vehicle = pickRandom(vehicles);
            threads.add(new Thread(() -> {
                post.processCargo(vehicle);
                System.out.println(DailyStatistics.getInstance().getInfo());
            }));
        }

        return threads;
    }

    private static <T> T pickRandom(List<T> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

}
