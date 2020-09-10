package mvc.view;

import mvc.config.springConfig;
import mvc.control.control;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 基于junit和spring的集成测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {springConfig.class})
public class view {

    @Autowired
    private mvc.control.control control;

    @Test
    public void test(){
        control.getDataBaseInfo();
        control.request(1);
    }

}
