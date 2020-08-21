public class ChinaTele implements Sim{

    private String phoneNumber;

    private String userName;
    private int age;

    ChinaTele( String userName, int age ){
        this.userName = userName;
        this.age = age;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void calling() {
        System.out.println("Calling by ChinaTele");
    }

    public void data() {
        System.out.println("Get ChinaTele Data");
    }

    public void getPhoneNumber() {
        System.out.println("PhoneNumber is " + phoneNumber);
    }

    public void getUserInfo(){
        System.out.println("userName: " + userName + " " + "age: " + age );
    }

}
