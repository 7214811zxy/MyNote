package GenericTutorial;


import java.util.ArrayList;
import java.util.List;

/**
 * There may be times when you want to restrict the types that can be used as type arguments in a parameterized type.
 * For example, a method that operates on numbers might only want to accept instances of Number or its subclasses.
 * This is what bounded type parameters are for.
 *
 * To declare a bounded type parameter, list the type parameter's name, followed by the extends keyword,
 * followed by its upper bound, which in this example is Number. Note that, in this context, extends is
 * used in a general sense to mean either "extends" (as in classes) or "implements" (as in interfaces).
 *
 * */
class MyBox<T> {

    private T t;

    public void set(T t) {
        System.out.println("set" + t);
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
}

class ListJustForTS<T, S>{

    List<Object> list =  new ArrayList<>();

    public void addT(T t){
        list.add(t);
    }

    public void addS(S s){
        list.add(s);
    }

    public List<Object> getList(){
        return list;
    }
}

public class BoundedTypeParameters {
    public static void main(String[] args) {

        // 创建一个只可以存Integer和String的List
        ListJustForTS<Integer, String> listJustForIntAndStr = new ListJustForTS<>();
        listJustForIntAndStr.addT(1);
        listJustForIntAndStr.addS("peter");

        List list = listJustForIntAndStr.getList();
        System.out.println(list);

    }
}
