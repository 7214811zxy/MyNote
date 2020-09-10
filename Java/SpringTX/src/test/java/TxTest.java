import TX.Control.Control;
import TX.config.springConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { springConfig.class })
public class TxTest {

    @Resource(name="control")
    Control control;

    @Test
    //
    public void test(){
        control.deal("mike", "peter", 100);
    }

}
