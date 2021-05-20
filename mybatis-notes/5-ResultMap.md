## 1-解决属性名和字段名不一致的问题

 根据 [4-配置详解.md](4-配置详解.md) 中的代码，将`User.java`中的`pwd`修改为`password`，这将导致`字段不匹配`

> 现象：

执行`UserMapperTest.java`中的`getUserByIdTest()`方法，得到返回值，但其中的`pwd`为空

```cmd
User{id=1, name='ckj', pwd='null'}
```

> 原因：

在`UserMapper.xml`中的`SQL`语句

```mysql
select * from user where id = #{id};
```

根据数据库的结构（字段名）可知，其本质是

```mysql
select id,name,pwd from user where id = #{id};
```

`sql`语句找到的数据，经过`类型处理器`处理，会找到其对应的字段，将找到的数据赋值给实体类字段，但`pwd`与`password`并不对应，所以，此时将数据赋值给`id`与`name`，而`password`为`null`

> 解决方法

### 1.1-别名

只要让`pwd as password`即可

```xml
<select id="getUserById" parameterType="int" resultType="config.pojo.User">
    select id,name,pwd as password from user where id = #{id};
</select>
```

### 1.2-resultMap

结果集映射

```cmd
id ——> id
name ——> name
pwd ——> password
```

更改`UserMapper.xml`的代码

```xml
<!--id 对应的resultMap编号 type 对应的实体类-->
<resultMap id="UserMap" type="config.pojo.User">
    <!--column 数据库中的字段 property 实体类中的属性-->
    <result column="id" property="id"></result>
    <result column="name" property="name"></result>
    <result column="pwd" property="password"></result>
</resultMap>

<select id="getUserById" parameterType="int" resultMap="UserMap">
    select *
    from user
    where id = #{id};
</select>
```

对应的`SQL`语句中，`resultMap`属性指定了采用的`映射对应所的id`，同级，实现相应的映射`resultMap`，其中，`id`为编号，`type`为对应的实体类，其下，`column`对应数据库中的字段，`property`对应实体类中的属性

`ResultMap` 的优秀之处——完全可以不用显式地配置它们，即不需要更改的字段不用手动配置，即将`第一行和第二行result`删去

