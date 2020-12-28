package homework.day_one;

public class Task3 {

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.getWeight());

        Apple[] apples = new Apple[]{new Apple(),new Apple()};
        Orange[] oranges = new Orange[]{new Orange(),new Orange()};

        Box<Apple> appleBox = new Box<>(apples);
        System.out.println("Вес коробки равен: " + appleBox.getWeight());
        System.out.println("Количество яблок: " + appleBox.getBoxFruit().size());
        appleBox.addFruit(apple);
        System.out.println("Новое количество яблок: " + appleBox.getBoxFruit().size());
        System.out.println("Новый вес коробки равен: " + appleBox.getWeight());

        //appleBox.addFruit(new Orange());  -- Cannot resolve method 'addFruit(homework.day_one.Orange)' Не подходит тип, так как он задан дженериком при объевлении сильной типизацией в Apple

        Box<Orange> orangeBox = new Box<>(oranges);
        //будут равны
        System.out.println(appleBox.compare(orangeBox));
        // не будут равны
        orangeBox.addFruit(new Orange());
        System.out.println(appleBox.compare(orangeBox));

        System.out.println(orangeBox.getBoxFruit().size());

        //appleBox.intersperse(orangeBox); -- checked exception Required type:Box<Apple>    Provided:Box<Orange>

        Box<Apple> newAppleBox = new Box<>(new Apple(),new Apple(),new Apple(),new Apple());
        System.out.println("Новая коробка с яблоками весит: " + newAppleBox.getWeight());

        appleBox.intersperse(newAppleBox);
        System.out.println("Теперь appleBox весит: " + appleBox.getWeight() + " а вторая корробка стала весить :" + newAppleBox.getWeight());

        System.out.println(newAppleBox.getBoxFruit().size());
    }
}
