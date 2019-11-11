package com.java.controller.user;

import com.java.bean.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 用户Controller
 *
 * @author wangzefeng
 * @date 2019/11/3 23:24
 */
@Api(tags = "用户管理")
@RestController()
@RequestMapping("users")
public class UserController {

    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取用户列表")
    @GetMapping("")
    public List<User> getUserList() {

        return new ArrayList<>(users.values());
    }


    @ApiOperation(value = "创建用户", notes = "根据用户User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详情实体user", required = true, dataType = "用户实体")
    @PostMapping("")
    public String postUser(@RequestBody User user) {

        users.put(user.getId(), user);
        return "success";
    }


    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }


    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传递过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体User", required = true, dataType = "用户实体")
    })
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id, User user) {
        User u = users.get(id);
        u.setUserName(user.getUserName());
        u.setAddress(user.getAddress());
        u.setAge(user.getAge());
        u.setEmail(user.getEmail());
        users.put(id, u);
        return "success";
    }


    @ApiOperation(value = "删除用户信息", notes = "根据url的id来删除指定对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
