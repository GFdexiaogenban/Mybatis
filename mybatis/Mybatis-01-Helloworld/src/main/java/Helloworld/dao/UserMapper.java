package Helloworld.dao;

import Helloworld.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据Id查询用户
    User getUserById(int id);
    List<User> getUserLike(String value);
    //insert 一个用户
    int addUser(User user);
    //万能Map
    int addUser2(Map<String,Object> map);
    //update
    int updateUser(User user);
    //delete
    int deleteUser(int id);
}
