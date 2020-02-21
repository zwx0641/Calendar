package com.zeno.calendar.controller;

import com.zeno.calendar.pojo.User;
import com.zeno.calendar.pojo.VO.UserVO;
import com.zeno.calendar.service.UserService;
import com.zeno.calendar.utils.IMoocJSONResult;
import com.zeno.calendar.utils.MD5Utils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@RestController
/**
 * 用户相关业务的接口
 */
@RequestMapping("/user")
public class UserController extends BasicController {
    @Autowired
    private UserService userService;

    //用户上传头像
    @PostMapping("/uploadFace")
    public IMoocJSONResult logout(String userId, @RequestParam("file") MultipartFile[] files) throws Exception {
        //定义存储空间
        String fileSpace = "C:/workspace/Spring/calendar_storage";
        //保存到数据库的相对路径
        String uploadPathDB = "/" + userId + "/face";

        if(StringUtils.isEmpty(userId)) {
            return IMoocJSONResult.errorMsg("用户id为空");
        }

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if(files != null && files.length > 0) {


                String filename = files[0].getOriginalFilename();

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
                return IMoocJSONResult.errorMsg("Upload error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return IMoocJSONResult.errorMsg("Upload error");
        } finally {
            if(fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        User user = new User();
        user.setId(userId);
        user.setFace_image(uploadPathDB);
        userService.updateUserInfo(user);

        return IMoocJSONResult.ok(uploadPathDB);
    }

    @PostMapping("/query")
    public IMoocJSONResult query(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return IMoocJSONResult.errorMsg("User cannot be empty");
        }

        User user = userService.queryUserInfo(userId);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);

        return IMoocJSONResult.ok(userVO);
    }

    @PostMapping("/passchange")
    public IMoocJSONResult passChange(String userId, String formerPass, String newPass) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            return IMoocJSONResult.errorMsg("User cannot be empty");
        }

        User former = userService.queryUserInfo(userId);
        User latter = new User();

        if (former.getPassword().equals(MD5Utils.getMD5Str(formerPass))) {
            latter.setPassword(MD5Utils.getMD5Str(newPass));
            userService.updateUserInfo(latter);
            return IMoocJSONResult.ok();
        } else {
            return IMoocJSONResult.errorMsg("Wrong password");
        }
    }
}
