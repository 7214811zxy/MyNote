package GenericTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * raw type：当一个泛型类或者泛型接口没有传染任何类型参数的时候我们称它为raw type
 * A raw type is the name of a generic class or interface without any type arguments.
 *
 * */

public class RawTypes {
    public static void main(String[] args) {

        List rawType = new ArrayList();
        rawType.add(1);

        List<Integer> parameterizedType = new ArrayList<>();
        parameterizedType.add(2);

        List rawTypeWaitForAssign;
        List<Integer> parameterizedTypeWaitForAssign;

        /**
         *
         * assigning a parameterized type to its raw type is allowed
         * if you assign a raw type to a parameterized type, you get a warning
         *
         * 将一个parameterized type赋值给raw type是允许的，但是如果将一个raw type分配给一个parameterized type 会报错
         * */


        // 分配可行 但是执行方法时会警告 unchecked invocation
        rawTypeWaitForAssign = parameterizedType;
        rawTypeWaitForAssign.add(0);

        // 赋值时会警告 Unchecked assignment
        parameterizedTypeWaitForAssign = rawType;
        parameterizedTypeWaitForAssign.add(0);

    }
}
