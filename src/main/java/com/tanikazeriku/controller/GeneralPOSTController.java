package com.tanikazeriku.controller;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
import com.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import com.tanikazeriku.pojo.DTO.KakuyaUserDTO;
import com.tanikazeriku.pojo.Entity.User;
import com.tanikazeriku.pojo.Entity.UserWrapper;
import com.tanikazeriku.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通用 POST 请求
 */
@Slf4j
@RestController
@RequestMapping("persona")
public class GeneralPOSTController {
    @Autowired
    private UserService userService;

    /**
     * 通用登录接口
     * @param request 需要传入用户名和密码
     * @return 是否成功
     */
    @PostMapping("/login")
    public Result generalLogin(@RequestBody String request) {
        log.info("登录操作");
        UserWrapper user = GeneralUtils.convertToUserWrapper(request);
        UserWrapper userWrapper = userService.getUserByUsername(user.getUsername());
        if(userWrapper.getPassword().equals(user.getPassword())) {
            HyperionKeyDTO keyDTO = new HyperionKeyDTO();
            return Result.success(keyDTO);
        }
        return Result.success();
    }

    /**
     * 通用注册接口
     * @param request 传入用户名和密码
     * @return 请求成功
     */
    @PostMapping("/register")
    public Result generalRegister(@RequestBody String request) {
        log.info("接收到的数据: {}", request);
        UserWrapper user = GeneralUtils.convertToUserWrapper(request);
        user.setPassword(GeneralUtils.md5Encrypt(user.getPassword()));
        userService.registerUser(user.getUsername(), user.getPassword());
        log.info("注册逻辑完成");
        return Result.success();
    }

}
