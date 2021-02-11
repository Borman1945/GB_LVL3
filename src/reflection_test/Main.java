package reflection_test;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
/*
     Rombo rombo = new Rombo();
     Class aClass = rombo.getClass();
     for (Method method: aClass.getDeclaredMethods()){
         System.out.println(method.getName());
     }*/
        TestCreater.start(Rombo.class);
    }

}
