import config.dao.UserMapper;
import config.pojo.User;
import config.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUser();
        for (User user : users) {
            System.out.println(user);
        }

        // System.out.println(mapper.getUserById(1));

        // mapper.addUser(new User(5,"xxx","xxx"));

        // mapper.updateUser(new User(5,"heihei","heihei"));

        // mapper.deleteUser(5);
        sqlSession.close();
    }
}
