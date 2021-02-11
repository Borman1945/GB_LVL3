package reflection_test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestCreater {

    private TestCreater(){};

    public static void start(Class aClass){
        List<Method> testMethods = findMethods(aClass, Test.class);
        testMethods.sort((method1, method2) ->
                method1.getAnnotation(Test.class).priority() - method2.getAnnotation(Test.class).priority());
        if (testMethods.isEmpty()){
            System.out.println(String.format("%s нет тестовых методов в классе", aClass.getName()));
            return;
        }
        Object obj = createObject(aClass);

        List<Method> beforeSuites = findMethods(aClass, BeforeSuite.class);
        List<Method>  afterSuites = findMethods(aClass, AfterSuite.class);

        if (!beforeSuites.isEmpty() && beforeSuites.size() > 1){
            throw new RuntimeException("BeforeSuite must be one");
        }

        if (!afterSuites.isEmpty() && afterSuites.size() > 1){
            throw new RuntimeException("AfterSuite must be one");
        }

        if (!beforeSuites.isEmpty()){
            executeMethods(beforeSuites.get(0),obj);
        }

        for (Method tesTmethod : testMethods){
            executeMethods(tesTmethod,obj);
        }

        if (!afterSuites.isEmpty()){
            executeMethods(afterSuites.get(0),obj);
        }

    }

    private static void executeMethods(Method tesTmethod, Object object, Object... arg){
        try {
            tesTmethod.setAccessible(true);
            tesTmethod.invoke(object);
            tesTmethod.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    private static List<Method> findMethods(Class aClass,Class<? extends Annotation> annotationClass){
        List<Method> testMethods = new ArrayList<>();
        for (Method method: aClass.getDeclaredMethods()){
            if (method.isAnnotationPresent(annotationClass)){
                testMethods.add(method);
            }
        }
        return testMethods;
    }

    public static void start(String className){
        try {
            start(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static Object createObject(Class aClass){
        try {
          return  aClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
