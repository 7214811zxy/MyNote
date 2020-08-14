/**
 *
 *  TypeCasting练习
 *  Java当中的内存转换分为Implicit和Explicit两类
 *  8个primitive type的byte从小到大分别是
 *  部分特殊情况详见官网 https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 *  byte(8) -> short(16) -> int(32) -> long(32 ? 64) -> float(32) -> double(64)
 *  boolean (1)
 *  char (16 Unicode)
 *  当小byte数据向大byte数据转换时。会发生Implicit casting
 *  当大byte数据需要向小byte数据转换时，需要进行Explicit x = (int) f
 *
 * */
public class TypeCasting {
    public static void main(String[] args) {
        // 小转大
        // lets declare and initialize all primitive data types
        byte b = 97;
        short s= 3256;
        int x = 100;
        long l= 1223654555;
        float f = 10.32f;
        double d = 123.325698;
        char c = 'a';

        System.out.println("Values Before casting- Byte "+b +" Short "+s+" Int "+x+" Long "+l+" Float "+f+" Double "+d+" Char "+c);

        // Now performing type casting 小转大不会发生数据丢失
        s=b;   //No ERROR; Byte(8 bit) to Short(16 bit) casting.
        x=s;   //NO ERROR; Short(16 bit) to int(32 bit) casting.
        x=c;   //NO ERROR; char(8 bit) to int(32 bit) casting

        System.out.println("Values after casting- Short "+s +" Int "+x);

        // 大转小 Explicit 会发生数据丢失 这不是屁话么... --！
        x = (int) f;
        System.out.println("Values after casting float " + f + " to int " + x);

        // 数组类型的转换
        float[] floatArray = { 1.1f, 2.2f, 3.3f, 4.4f };

    }
}
