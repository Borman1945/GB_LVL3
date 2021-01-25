package thread.lesson2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FuelStaion {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Semaphore smp = new Semaphore(3,true);

    public void fuel(Automobile automobile){

        try {
            smp.acquire();
            System.out.println("Идет заправка " + automobile.getIndex() + " имел топливо = " + automobile.tank);
            Thread.sleep(5000);
            automobile.tank = automobile.getMaxTank();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(automobile.getIndex() + " Заправлен полностью = " + automobile.tank);
            automobile.go(); // отправляю на трек
            smp.release();
        }
    }






}
