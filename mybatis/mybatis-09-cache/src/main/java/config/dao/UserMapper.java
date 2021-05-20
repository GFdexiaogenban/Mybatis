package config.dao;

import config.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User queryUserById(@Param("id") int id);
    int updateUser(User user);
}
