public class RunApp{
    public static void main(String[] args) {
        Container container = new Container("ApplicationConfig.xml");
        Person person = (Person) container.getBeanByAnno(Service.class);
        person.eat();
    }
}