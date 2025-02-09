package com.tanikazeriku.controller;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
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

    @PostMapping("/login")
    public Result generalLogin(@RequestBody String request) {
        UserWrapper user = GeneralUtils.convertToUserWrapper(request);
        // TODO: 正式的登录验证操作，这里暂做模拟

        List<User> userList = userService.selectAll();
        KakuyaUserDTO userDTO = GeneralUtils.convertEntityToDTO(userList.get(0), KakuyaUserDTO.class);
        log.info("接收到的数据: {}", user);
        log.info("登录操作，返回的数据: {}", userDTO);
        return Result.success(userDTO);
    }

    @PostMapping("/register")
    public Result generalRegister(@RequestBody String request) {
        UserWrapper user = GeneralUtils.convertToUserWrapper(request);
        // TODO: 注册操作
        log.info("接收到的数据: {}", user);
        return Result.success();
    }

}
