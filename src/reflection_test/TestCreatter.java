package reflection_test;

import java.lang.reflect.InvocationTargetException;

public class TestCreatter {

    private TestCreatter(){};

    public static void start(Class aClass){
        try {
            aClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void start(String className){

    }


}
