package app.Dao.Implement;

import app.Dao.DaoInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("Dao")
public class DaoImpl implements DaoInterface {


    @Resource(name="jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    // 收款处理
    // receiveMoney( 收款人姓名， 金额 )
    public void receiveMoney(String name, int money) {
        jdbcTemplate.update("UPDATE account SET money = money + ? WHERE name = ?", money, name);
    }

    // 付款处理
    // payMoney( 汇款人姓名， 金额 )
    public void payMoney(String name, int money) {
        jdbcTemplate.update("UPDATE account SET money = money - ? WHERE name = ?", money, name);
    }
}
