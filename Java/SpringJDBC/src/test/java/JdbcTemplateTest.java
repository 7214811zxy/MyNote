import mvc.config.springConfig;
import mvc.dao.Jldb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class) // 通过JUnit运行
@ContextConfiguration(classes = { springConfig.class }) // 加载上下文配置类
public class JdbcTemplateTest {

    @Resource(name="jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Test
    // 增
    public void insert(){
        jdbcTemplate.update("INSERT INTO jldb VALUES(null, ?, ?)", "peter", 20200827);
    }

    @Test
    // 删
    public void delete(){
        jdbcTemplate.update("DELETE FROM jldb WHERE name=?", "peter");
    }

    @Test
    // 改
    public void update(){
        jdbcTemplate.update("UPDATE jldb SET name=?, birthday=? WHERE name=?", "peterUpdate", "666666","joker");
    }

    @Test
    // 查 - 查询所有
    public void queryAll(){
        List<Jldb> jldbList= jdbcTemplate.query("SELECT * FROM jldb", new BeanPropertyRowMapper<Jldb>(Jldb.class));
        System.out.println(jldbList);
    }

    // 查 - 查询单个
    @Test
    public void queryOne(){
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("SELECT * FROM jldb WHERE id=?", 6);
        Jldb jldbOne= jdbcTemplate.queryForObject("SELECT * FROM jldb WHERE id=?", new BeanPropertyRowMapper<Jldb>(Jldb.class), 12);
        System.out.println(jldbOne);
        System.out.println(mapList.get(0));
    }

    // 查 - 查询总数
    @Test
    public void querySum(){
        Long count= jdbcTemplate.queryForObject("SELECT COUNT(*) FROM jldb", Long.class);
        System.out.println(count);
    }
}
