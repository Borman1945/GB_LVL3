package thread.lesson2;

public abstract class Automobile {

    public int tank;
    public double consumption;

    public boolean go(){
        while(tank > tank/2){
                tank = tank - ((int) (Math.random() * 10) + (int) consumption);
                return true;
        }
        tank = tank > 0 ? tank : tank * (-1);
        return true;
    }

    public abstract int getMaxTank();

    public abstract int getIndex();

}
