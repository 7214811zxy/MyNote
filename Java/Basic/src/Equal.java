/**
 * .equal和 == 的区别和本质
 * 了解了.equal和==之间的主要区别；了解了Java String Pool
 *
 * */


public final class Equal
{
    public static void main( String args[] )
    {
        String s1 = new String( "Test" );
        String s2 = new String( "Test" );

        System.out.println( "\n1 - PRIMITIVES ");
        System.out.println( s1 == s2 ); // false 变量s1和s2所指向的内存的地址不同
        System.out.println( s1.equals( s2 )); // true 逻辑值相等

        A a1 = new A();
        A a2 = new A();
        A2 a3 = new A2("apple");
        A2 a4 = new A2("peach");

        System.out.println( "\n2 - OBJECT TYPES / STATIC VARIABLE" );
        System.out.println( a1 == a2 ); // false
        System.out.println( a1.s == a2.s ); // true
        System.out.println( a3.s == a4.s ); // true
        System.out.println( a1.s.equals( a2.s ) ); // true
        System.out.println( a1.equals( a2 ) ); // false

        B b1 = new B();
        B b2 = new B();

        System.out.println( "\n3 - OBJECT TYPES / NON-STATIC VARIABLE" );
        System.out.println( b1 == b2 ); // false
        System.out.println( b1.getS() == b2.getS() ); // false 地址不同
        System.out.println( b1.getS().equals( b2.getS() ) ); // true 逻辑值相同
    }
}

final class A
{
    // static
    public static String s;
    A()
    {
        this.s = new String( "aTest" );
    }
}

final class A2
{
    // static
    public static String s;
    A2(String text)
    {
        this.s = text;
    }
}

final class B
{
    private String s;
    B()
    {
        this.s = new String( "aTest" );
    }

    public String getS()
    {
        return s;
    }

}