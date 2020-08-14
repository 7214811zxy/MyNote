/**
 * Generics练习
 * 如何创建一个泛型数组
 *
 * */

import java.lang.reflect.Array;
import java.util.Arrays;

class GenericsArray {
    @SuppressWarnings({ "unchecked", "hiding" })
    public static <T> T[] getArray(Class<T> componentType,int length) {
        return (T[]) Array.newInstance(componentType, length);
    }
}

class Person {
    private int id;
    public Person(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Person [id=" + id + "]";
    }
}

public class Generics {
    public static void main(String[] args) {
        @SuppressWarnings("static-access")
        Person[] persons = new GenericsArray().getArray(Person.class, 10);

        System.out.println(Arrays.toString(persons));
        for (int i = 0; i < persons.length; i++) {
            persons[i]=new Person(i);
        }
        System.out.println(Arrays.toString(persons));
    }
}