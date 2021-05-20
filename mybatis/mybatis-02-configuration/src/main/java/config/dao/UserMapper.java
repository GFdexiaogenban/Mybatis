package config.dao;

import config.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据Id查询用户
    User getUserById(int id);
    //insert 一个用户
    int addUser(User user);
    //update
    int updateUser(User user);
    //delete
    int deleteUser(int id);
}
