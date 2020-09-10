import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springAnnoAspect.TargetInterface;

@RunWith(SpringJUnit4ClassRunner.class) // 通过JUnit运行
@ContextConfiguration(classes = { SpringConfig.class }) // 加载上下文配置类
public class SpringMyAspectTest {

    @Autowired
    private TargetInterface target;

    @Test
    public void test(){
        target.save();
        target.load();
    }

}
