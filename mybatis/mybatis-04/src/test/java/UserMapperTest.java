import config.dao.UserMapper;
import config.pojo.User;
import config.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;


public class UserMapperTest {
    static Logger logger = Logger.getLogger(String.valueOf(UserMapper.class));

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //TODO
        System.out.println(mapper.getUserById(1));

        sqlSession.close();
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //TODO
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user:userByLimit){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("config.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void LogTest(){
        logger.info("info:进入了LogeTest方法:");
        logger.debug("debug:进入了LogTest方法");
        logger.error("error:进入了LogTest方法");
    }
}
