public class HowToDeBUG {
        static void f (int x) {
            System.out.println ("line1 " + x);
            System.out.println ("line2 " + x);
            System.out.println ("line1 " + x);
            System.out.println ("line2 " + x);
            System.out.println ("line2 " + x);
            System.out.println ("line7 " + x);
            System.out.println ("line2 " + x);
            System.out.println ("line2 " + x);
            System.out.println ("line7 " + x);
            System.out.println ("line9999999999999 " + x);
            System.out.println ("line0 " + x);
            System.out.println ("line7 " + x);
            System.out.println ("line2 " + x);
            System.out.println ("line2 " + x);
        }

        static void g (int x) {
            f(x); //
            f(1); //
        }

        public static void main (String args[]) {
            g(2);
            g(3); //
        }
}
