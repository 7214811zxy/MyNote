import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MobileSpring {

    @Autowired
    @Qualifier("phoneNumber")
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Sim sim  = app.getBean("sim", Sim.class);
        sim.calling();
        sim.data();
        sim.getPhoneNumber();
        sim.getUserInfo();
    }
}
