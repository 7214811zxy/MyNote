package TX.Service;

import TX.Dao.DaoInterface;
import org.springframework.stereotype.Component;
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

        /**
         * int i = 1 / 0 会导致 by zero错误，如果不使用事务，那么就会发生receive方没收到钱，但是pay方钱减少的问题
         * 当使用了事务之后，可以解决这个问题 具体的底层原理不是很清楚....以后再看~
         * */

        int i = 1/ 0;
        dao.payMoney(payName, money);
    }

}
