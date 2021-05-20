import config.dao.UserMapper;
import config.pojo.User;
import config.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;


public class UserMapperTest {

    @Test
    public void test() {
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：
        // List<User> userList= sqlSession.selectList("Helloworld.dao.UserMapper.getUserList");

        //方法二：
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void UseraddTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.addUser(new User(4, "wjy", "wjy"));

        System.out.println(result);
        sqlSession.commit();
        //提交事务
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser(new User(4, "更改后name", "更改后pwd"));
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.deleteUser(4);
        System.out.println(result);

        sqlSession.commit();
        sqlSession.close();
    }
}
