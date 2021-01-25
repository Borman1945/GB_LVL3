package thread.lesson2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        FuelStaion fuelStaion = new FuelStaion();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ArrayList<Automobile> arrayList = automobileFactory();



        arrayList.forEach(automobile -> {
            automobile.go(); // аналог того что они двигаются
            executorService.execute(() -> fuelStaion.fuel(automobile));
        });

        executorService.shutdown();

    }

    public static ArrayList<Automobile> automobileFactory(){
        ArrayList<Automobile> arrayList = new ArrayList<>();
        int auto = (int) (Math.random() * 10);
        for(int i = 0; i < 10; i++){
            if (auto > 7) {
                auto = (int) (Math.random() * 10);
                arrayList.add(new Truck());
            } else if (auto > 4){
                auto = (int) (Math.random() * 10);
                arrayList.add(new Bus());
            } else {
                auto = (int) (Math.random() * 10);
                arrayList.add(new Car());
            }
        }
        return arrayList;
    }


}
