## 1-前置知识

使用`Limit`分页

```mysql
从第2个开始，显示2个
SELECT * from user limit 2,2;

从第0个开始，显示3个
SELECT * from user limit 3;
```

## 2-RowBounds分页

Mapper.xml

```xml
<select id="getUserByRowBounds" resultMap="UserMap">
    select * from mybatis.user
</select>
```

Java测试代码

```java
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
```

## 3-plugin

mybatis-pageHelper