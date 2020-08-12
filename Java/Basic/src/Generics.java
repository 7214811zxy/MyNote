import java.lang.reflect.Array;
import java.util.Arrays;

public class Generics {
    public static void main(String[] args) {
        int[] intArray1 = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(intArray1));
        System.out.println(intArray1);
        int[] intArray2 = { 5, 6, 7, 8 };
        System.out.println(intArray2);
        int[] intArray3 = intArray1;
        System.out.println(intArray3);
        intArray3[0] = 99;
        System.out.println(Arrays.toString(intArray1));
        System.out.println(Arrays.toString(intArray2));
        System.out.println(Arrays.toString(intArray3));
    }
}
