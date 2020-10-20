package GenericTutorial;

/**
 * generic type是一个泛型的class或者interface是类型的参数化
 * A generic type is a generic class or interface that is parameterized over types
 * */


/**
 * 语法
 * class name<T1, T2, ..., Tn> {}
 *
 * */
class Box<T> {
    private T object;

    public void set(T object) { this.object = object; }
    public T get() { return object; }
}


/**
 * 多个Type Parameters
 * */
class OrderedPair<K, V>  {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey()	{ return key; }

    public V getValue() { return value; }
}


/**
 * 调用/实例化一个泛型类
 * Invoking and Instantiating a Generic Type
 *
 * */
public class GenericTypes {
    public static void main(String[] args) {
        OrderedPair<String, Integer> orderedPair = new OrderedPair<>("age", 18);
        System.out.println(orderedPair.getKey());
        System.out.println(orderedPair.getValue());
    }
}
