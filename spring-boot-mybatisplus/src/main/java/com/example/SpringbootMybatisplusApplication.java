package com.example;

import com.example.entity.User;
import com.example.enums.Education;
import com.example.enums.Gender;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

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
        // testInsert();
        testList();
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

    private void testList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
