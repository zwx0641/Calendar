package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.User;
import com.zeno.calendar.pojo.VO.UserVO;
import com.zeno.calendar.service.UserService;
import com.zeno.calendar.utils.JSONResult;
import com.zeno.calendar.utils.MD5Utils;
import io.swagger.annotations.Api;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author rf
 */
@RestController
/**
 * 用户相关业务的接口
 */
@Api(value = "User APIs", tags = {"Controller for user APIs"})
@RequestMapping("/user")
public class UserController extends BasicController {
    @Autowired
    private UserService userService;

    //用户上传头像
    @PostMapping("/uploadFace")
    public JSONResult logout(String userId, @RequestParam("file") MultipartFile[] files) throws Exception {
        //定义存储空间
        String fileSpace = "C:/workspace/Spring/calendar_storage";
        //保存到数据库的相对路径
        String uploadPathDB = "/" + userId + "/face";

        if(StringUtils.isEmpty(userId)) {
            return JSONResult.errorMsg("用户id为空");
        }

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if(files != null && files.length > 0) {


                String filename = files[0].getOriginalFilename();
                System.out.println(filename);

                if (!StringUtils.isEmpty(filename)) {
                    //绝对路径
                    String finalFacePath = fileSpace + uploadPathDB + "/" + filename;
                    //相对路径
                    uploadPathDB += ("/" + filename);

                    File outFile = new File(finalFacePath);
                    if(outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return JSONResult.errorMsg("Upload error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JSONResult.errorMsg("Upload error");
        } finally {
            if(fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        System.out.println(uploadPathDB);
        User user = new User();
        user.setId(userId);
        user.setFace_image(uploadPathDB);
        userService.updateUserInfo(user);

        return JSONResult.ok(uploadPathDB);
    }

    @PostMapping("/query")
    public JSONResult query(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return JSONResult.errorMsg("User cannot be empty");
        }

        User user = userService.queryUserInfo(userId);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);

        return JSONResult.ok(userVO);
    }

    @PostMapping("/passchange")
    public JSONResult passChange(String userId, String formerPass, String newPass) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            return JSONResult.errorMsg("User cannot be empty");
        }

        User former = userService.queryUserInfo(userId);
        User latter = new User();

        if (former.getPassword().equals(MD5Utils.getMD5Str(formerPass))) {
            latter.setPassword(MD5Utils.getMD5Str(newPass));
            userService.updateUserInfo(latter);
            return JSONResult.ok();
        } else {
            return JSONResult.errorMsg("Wrong password");
        }
    }
}
