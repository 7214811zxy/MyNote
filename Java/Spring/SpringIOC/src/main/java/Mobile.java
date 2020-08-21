public class Mobile {
    public static void main(String[] args) {
        Sim simCard = new ChinaTele("Peter", 18);
        simCard.calling();
        simCard.data();
        simCard.getPhoneNumber();
    }
}
