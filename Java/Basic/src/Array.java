import java.util.Arrays;

/**
 * Array和 Generics练习
 * 类功能：不使用ArrayList，实现与JavaScript中类似的动态数组
 *
 * */

class JsArray<T>{

    T[] array;
    int length;

    JsArray(T[] array){
        this.array = array;
        this.length = this.array.length;
    }

    // 向数组中添加元素
    public void push(T[] pushedArray){

        T[] tempArray;

        // 计算新数组长度并初始化
        int length = pushedArray.length;
        int tempLength = this.length + length;
        tempArray = Arrays.copyOf( this.array, tempLength );

        // 遍历添加新数组元素
        if (tempLength - this.length >= 0)
            System.arraycopy(pushedArray, 0, tempArray, this.length, tempLength - this.length);

        // 更新数组和数组长度
        this.array = tempArray;
        this.length = this.length + length;
    }

    // 数组的切割：
    // 返回下标从start(包括start)开始之后的所有元素组成的新数组
    public JsArray<T> split(int start){

        try {
            // 计算新数组的长度
            int tempLength = this.length - start;
            T[] tempArray;
            tempArray = (T[]) new Object[tempLength];

            // 生成新数组
            // System.arrayCopy(source, sourceStartPos, target, targetStartPos, targetArrayLength)
            if (length - start >= 0) System.arraycopy(this.array, start, tempArray, 0, length - start);

            // 返回对象
            return new JsArray<>(tempArray);
        }catch ( Exception e ){

            // 异常捕捉
            if( start >= this.length || start < 0){
                System.out.println("array index out of bounds");
            }

        }

        return this;

    }

    // 数组的切割 返回一个下标从start开始到end结束的新数组
    // 返回下标从start(包括start)开始, 到下标end(包括end)之间元素组成的新数组
    public JsArray<T> split(int start, int end){

        try {
            // 计算新数组的长度
            int tempLength = end - start + 1;
            T[] tempArray;
            tempArray = (T[]) new Object[tempLength];

            // 生成新数组
            if (end + 1 - start >= 0) System.arraycopy(this.array, start, tempArray, 0, end + 1 - start);

            // 返回对象
            return new JsArray<>(tempArray);

        }catch ( Exception e ){

            // 异常捕捉
            if( start > this.length || end < 0 || start < end ){
                System.out.println("array index out of bounds");
            }

        }

        return this;

    }

    // 打印数组元素
    public void print(){
        System.out.println(Arrays.toString(this.array));
    }
}

public class Array {
    public static void main(String[] args) {

        // 1. 声明一个动态数组
        JsArray<Integer> testArray = new JsArray<Integer>( new Integer[] {1, 2, 3} );
        testArray.print(); // [1, 2, 3]

        // 向数组中添加元素
        testArray.push( new Integer[] {4, 5, 6} );
        testArray.print(); // [1, 2, 3, 4, 5, 6]

        // 数组的切割
        testArray.split(2).print(); // [3, 4, 5, 6]
        testArray.split(1, 4).print(); // [2, 3, 4, 5]

    }
}
