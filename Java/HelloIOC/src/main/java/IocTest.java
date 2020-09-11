public class IocTest {
    public static void main(String[] args) {
        Container container = new Container("ApplicationConfig.xml");
        Person person = (Person) container.getBean("person");
        person.eat();
    }
}
