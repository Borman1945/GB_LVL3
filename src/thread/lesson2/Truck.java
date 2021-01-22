package thread.lesson2;

public class Truck extends Automobile{

    private final int index;

    private static final int amaount = 60;

    public Truck(){
        this.index = (int) (Math.random() * 100);
        super.consumption = 15;
        tank = amaount;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int getMaxTank(){
        return amaount;
    }

}
