package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.User;
import com.zeno.calendar.pojo.VO.UserVO;
import com.zeno.calendar.service.UserService;
import com.zeno.calendar.utils.JSONResult;
import com.zeno.calendar.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.UUID;

/**
 * @author rf
 */
@RestController
@Api(value = "User register & login APIs", tags = {"Controller for register login"})
public class RegisterLoginController extends BasicController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "User registration", notes = "User registration api")
    @PostMapping("/register")
    public JSONResult register(@RequestBody User user) throws Exception {

        //1. Username, password not empty
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return JSONResult.errorMsg("Username or password cannot be empty");
        }
        //2. Username existing?
        boolean isEmailExist = userService.queryEmailIsExist(user.getEmail());
        boolean isUsernameExist = userService.queryUsernameIsExist(user.getUsername());
        //3. Save user
        if (!isEmailExist && !isUsernameExist) {
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));

            userService.saveUser(user);
        } else if (isUsernameExist) {
            return JSONResult.errorMsg("Username already exists. Try another one");
        } else if (isEmailExist) {
            return JSONResult.errorMsg("Email already exists. Try another one");
        }

        user.setPassword("");

        UserVO userVO = setUserRedis(user);

        return JSONResult.ok(userVO);
    }

    public UserVO setUserRedis(User userModel) {

        String uniqueToken = UUID.randomUUID().toString();

        //设置用户redis session
        redis.set(USER_REDIS_SESSION + ":" + userModel.getId(), uniqueToken, 1000 * 60 * 30);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        userVO.setUserToken(uniqueToken);
        return userVO;
    }

    @ApiOperation(value = "User login", notes = "User login api")
    @PostMapping("/login")
    public JSONResult login(@RequestBody User user) throws Exception {
        String email = user.getEmail();
        String password = user.getPassword();

        // 1. Not empty
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            return JSONResult.errorMsg("Username or password cannot be empty");
        }

        // 2. User exists?
        User user1 = userService.queryUserForLogin(email, MD5Utils.getMD5Str(user.getPassword()));

        // 3. return
        if (user1 != null) {
            user1.setPassword("");
            UserVO userVO = setUserRedis(user1);
            return JSONResult.ok(userVO);
        } else {
            return JSONResult.errorMsg("Incorrect password or username.");
        }
    }

    @PostMapping("/logout")
    public JSONResult logout(String userId) throws Exception {
        //删除redis session
        redis.del(USER_REDIS_SESSION + ":" + userId);
        return JSONResult.ok();
    }
}
