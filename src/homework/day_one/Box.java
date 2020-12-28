package homework.day_one;

import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit> {

    private final ArrayList<T> box;

    @SafeVarargs
    public Box(T... fruitArr) {
        this.box = TaskOneAndTwo.takeArrayList(fruitArr);
    }

    public double getWeight(){
        try {
            return box.size() * box.get(0).getWeight();
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public boolean compare(Box<? extends Fruit> newBox){  // можно просто Box, так как в самом класе уже есть привязка к типу class Box<T extends Fruit>
        return this.getWeight() == newBox.getWeight();
    }

    @SafeVarargs
    public final void addFruit(T... fuits){
        Collections.addAll(box,fuits);
    }

    public void intersperse(Box<T> newBox) {
        this.box.addAll(newBox.getBoxFruit());
        newBox.cleanBox();
    }

    public void cleanBox(){
        this.box.clear();
    }

    public ArrayList<T> getBoxFruit() {
        return box;
    }

}
