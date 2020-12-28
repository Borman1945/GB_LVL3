package homework.day_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class TaskOneAndTwo {



    public static void main(String[] args) {
        String[] arr = new String[]{"a","b","c"};

        System.out.println(String.join(",", arr));
        System.out.println("-----");

        chanArrValue(arr,0,2);
        System.out.println(String.join(",", arr));

        ArrayList<Integer> arrayList = takeArrayList(1,2,3,4,5,6,7,8);
        System.out.println(arrayList);

    }

    //the index starts at 0
    public static <T> void chanArrValue(T[] arr, int firstIndex, int secondIndex){
        T firstValue = arr[firstIndex];
        T seconValue = arr[secondIndex];
        arr[firstIndex] = seconValue;
        arr[secondIndex] = firstValue;
    }

    @SafeVarargs
    public static <E> ArrayList<E> takeArrayList(E... elements){
        ArrayList<E> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,elements);
        return arrayList;
    }

}
