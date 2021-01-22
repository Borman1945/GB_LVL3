package thread.lesson2;

public class Bus extends Automobile{

    private final int index;

    private static final int amaount = 20;

    public Bus(){
        this.index = (int) (Math.random() * 100);
        super.consumption = 7.5;
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
