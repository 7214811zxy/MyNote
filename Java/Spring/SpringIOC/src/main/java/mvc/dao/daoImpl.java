package mvc.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository("daoImpl")
public class daoImpl implements dao {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;

    public String getUserHobby(int userID) {
        if( userID == 1 ){
            return "Swim";
        }else {
            return "Eat";
        }
    }

    public void getDataBaseInfo(){
        System.out.println(String.format("driver:%s, url: %s", driver, url));
    }
}
