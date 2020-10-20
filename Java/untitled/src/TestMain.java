import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    private static final List<Integer>  list = new ArrayList<>(200);

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
           t();
        });

        Thread t2 = new Thread(() -> {
            t();
        });

        t1.start();
        t2.start();

        Thread.sleep(1000L);
        printR();
    }

    private static void printR() {
        if(list == null || list.isEmpty()) {
            return;
        }

        for(Integer i : list){
            System.out.println(i);
        }
    }

    public static void t() {

        for(int i = 0; i < 100; i++){
            list.add(i);
        }
    }
}
