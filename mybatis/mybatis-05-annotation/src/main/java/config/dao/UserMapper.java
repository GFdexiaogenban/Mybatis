package config.dao;


import config.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {


    @Select("select * from user")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "user",property = "user"),
            @Result(column = "pwd",property = "password")
    })
    List<User> getUser();

    // 方法存在多个参数，所有参数前面必须加上@Param注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) value (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}
