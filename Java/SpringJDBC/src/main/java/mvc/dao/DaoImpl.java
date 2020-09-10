package mvc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository("DaoImpl")
public class DaoImpl implements Dao {

    @Resource( name = "jdbcTemplate" )
    JdbcTemplate jdbcTemplate;
    public void updateDB(String sql){
        int row = jdbcTemplate.update(sql);
        System.out.println(row);
    }

}
