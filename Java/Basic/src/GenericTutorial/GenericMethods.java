package GenericTutorial;

/**
 * The syntax for a generic method includes a list of type parameters, inside angle brackets,
 * which appears before the method's return type
 * <p>
 * 泛型方法的语法时这样滴。首先要用一个尖括号包含一个类型参数(type parameters)
 * 的列表(就是<T1, T2.....>这样子的东西，T称为type parameters)。这个东西应该出现在
 * 方法的返回值之前。
 */

class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<V, K> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Util1 {
    public static <K, V> boolean compare(K p1, V p2) {
        return true;
    }

    // 调用
    // <String, Integer> compare(String p1, Integer P2)

    {
        // 按照官方的写法 就可以这么调用
        // <String, Integer> compare(p1, P2)
    }
}

class Util2 {
    public static <K, V> boolean compare(Fn2<K> p1, V p2) {
        return true;
    }

    // 调用
    // compare(Fn2<String> p1, Integer P2)

    {
        // 按照官方的写法 就可以这么调用
        // <String, Integer> compare(Fn2<> p1, P2)
    }
}

class Util3 {
    public static <K, V> boolean compare(Fn2<K> p1, Fn1<V, K> p2) {
        return true;
    }

    // 调用
    // compare(Fn2<String> p1, Fn1<String, Integer> P2)

    {
        // 按照官方的写法 就可以这么调用
        // <String, Integer> compare(Fn2<> p1, Fn1<> P2)
    }
}

class Fn2<K> {

    private K key;

    public Fn2(K key) {
        this.key = key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }
}

class Fn1<K, V> {

    private K key;
    private V value;

    public Fn1(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class GenericMethods {
    public static void main(String[] args) {

        /**
         * 调用泛型方法的复杂语法
         * */
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<String, Integer> p2 = new Pair<>("pear", 2);
        boolean same1 = Util.compare(p1, p2);
        System.out.println(same1);

        /**
         * 调用泛型方法的简化语法
         * */
//        Pair<Integer, String> p3 = new Pair<>(1, "apple");
//        Pair<Integer, String> p4 = new Pair<>(2, "pear");
//        boolean same2 = Util.compare(p3, p4);
//        System.out.println(same2);

    }
}
