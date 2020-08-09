
class Test{
    static String text;
    Test(String test){
        this.text = test;
    }
}

public class Equal2 {
    public static void main(String[] args) {
        Test a = new Test("apple");
        Test a1 = new Test("apple");
        Test b = new Test("peach");

        System.out.println(a.text); //peach
        System.out.println(a1.text); //peach
        System.out.println(b.text); //peach

        System.out.println( a.text == a1.text ); // true
        System.out.println( a.text == b.text ); // true
        System.out.println( a1.text == b.text ); // true
    }
}
