## 使用 MyBatis-Plus 实现 BO 对象枚举类型与 JdbcType 互相转换



### 1. 相关版本说明

> Spring Boot 版本：2.2.2.RELEASE

> MyBatis-Plus 版本：3.3.0 

### 2. 模型准备

- 2.1 User BO

```java
@Data
@TableName("t_user")
public class User {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "name", jdbcType = JdbcType.VARCHAR)
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age", jdbcType = JdbcType.INTEGER)
    private Integer age;

    /**
     * 性别
     */
    @TableField(value = "gender", jdbcType = JdbcType.INTEGER)
    private Gender gender;

    /**
     * 学历
     */
    @TableField(value = "education", jdbcType = JdbcType.INTEGER)
    private Education education;

    /**
     * 生日
     */
    @TableField(value = "birthday", jdbcType = JdbcType.DATE)
    private Date birthday;
}
```

- 2.2 Gender enum

```java
public enum Gender {
    /**
     * 女性
     */
    FEMALE(0),

    /**
     * 男性
     */
    MALE(1),

    /**
     * 其他
     */
    OTHER(2);
    
    @Getter
    private final int value;

    Gender(int value) {
        this.value = value;
    }
}
```

- 2.3 Education enum

```java
public enum Education {
    /**
     * 本科
     */
    UNDERGRADUATE(0),

    /**
     * 硕士
     */
    MASTER(1),

    /**
     * 博士
     */
    DOCTOR(2);

    @Getter
    private final int value;

    Education(int value) {
        this.value = value;
    }
}
```

### 3. 实现

- 3.1 参考资料

  [Mybatis-Plus官网说明](https://mp.baomidou.com/config/#defaultenumtypehandler)

> ### defaultEnumTypeHandler
>
> - 类型：Class<? extends TypeHandler
> - 默认值：`org.apache.ibatis.type.EnumTypeHandler`
>
> 默认枚举处理类,如果配置了该属性,枚举将统一使用指定处理器进行处理
>
> - org.apache.ibatis.type.EnumTypeHandler : 存储枚举的名称
> - org.apache.ibatis.type.EnumOrdinalTypeHandler : 存储枚举的索引
> - com.baomidou.mybatisplus.extension.handlers.MybatisEnumTypeHandler : 枚举类需要实现IEnum接口或字段标记@EnumValue注解.(3.1.2以下版本为EnumTypeHandler)
> - ~~com.baomidou.mybatisplus.extension.handlers.EnumAnnotationTypeHandler: 枚举类字段需要标记@EnumValue注解~~

- 3.2 修改配置

可以看出 Mybatis-Plus 为我们提供了3种实现，MybatisEnumTypeHandler 这种实现灵活性较高，可以满足我们的要求，因此我们可以配置 defaultEnumTypeHandler 的 实现为MybatisEnumTypeHandler。 

> 注意: Mybatis 3.4.5 后才提供org.apache.ibatis.session.Configuration#setDefaultEnumTypeHandler()

``` properties
mybatis-plus.configuration.default-enum-type-handler=com.baomidou.mybatisplus.extension.handlers.MybatisEnumTypeHandler
```

- 3.3 实现一：枚举类实现 IEnum 接口的方式，改造 Gender 枚举类为

```java
public enum Gender implements IEnum<Integer> {

    /**
     * 女性
     */
    FEMALE(0),

    /**
     * 男性
     */
    MALE(1),

    /**
     * 其他
     */
    OTHER(2);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
```

- 3.4 实现二： 枚举字段标记 @EnumValue 方式，改造 Education 枚举类为

```java
public enum Education {

    /**
     * 本科
     */
    UNDERGRADUATE(0),

    /**
     * 硕士
     */
    MASTER(1),

    /**
     * 博士
     */
    DOCTOR(2);

    @Getter
    @EnumValue
    private final int value;

    Education(int value) {
        this.value = value;
    }
}
```

- 3.5 测试验证 

  UserMapper#insert(T entity) 向数据库插入数据

```java
@SpringBootApplication
public class SpringbootMybatisplusApplication implements ApplicationRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringbootMybatisplusApplication.class)
                .web(WebApplicationType.NONE)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Autowired
    UserMapper userMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        testInsert();
    }

    private void testInsert() {
        User user = new User();
        user.setName("test");
        user.setAge(25);
        user.setGender(Gender.MALE);
        user.setEducation(Education.UNDERGRADUATE);
        user.setBirthday(new Date());
        userMapper.insert(user);
        System.out.println(user);
    }
}
```

程序，成功向数据库插入记录，BO 对象枚举类型转换为 JdbcType 成功！

​		使用 UserMapper#selectList(null) 查询数据库记录

```java
@Override
public void run(ApplicationArguments args) throws Exception {
// testInsert();
testList();
}

private void testList() {
List<User> users = userMapper.selectList(null);
users.forEach(System.out::println);
}
```

运行程序，成功打印出 User 记录信息，JdbcType 转换为 BO 对象枚举类型 成功！