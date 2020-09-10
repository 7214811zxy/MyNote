package app.Service.Implement;

import app.Dao.DaoInterface;
import app.Service.ServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("serviceImpl")
public class ServiceImpl implements ServiceInterface {

    @Resource(name="Dao")
    DaoInterface dao;

    // transfer使用事务控制
    // 相当于
    /**
     * <aop:config>
     *     <aop:pointcut id="txPointcut" expression=(* Service.*.*(..))/>
     *     <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"/>
     * </aop:config>
     *
     * */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    // 转账服务
    // transfer(付款人，收款人，金额)
    public void transfer(String payName, String receiveName, int money) {
        dao.receiveMoney(receiveName, money);
        dao.payMoney(payName, money);
    }

}
