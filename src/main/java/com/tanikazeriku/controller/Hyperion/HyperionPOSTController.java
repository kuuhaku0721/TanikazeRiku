package com.tanikazeriku.controller.Hyperion;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import com.tanikazeriku.pojo.DTO.KakuyaUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("persona/hyperion")
public class HyperionPOSTController {

    @PostMapping("/login")
    public Result hyperionLoginRequest(@RequestBody KakuyaUserDTO user) {
        log.info("接收的body数据: {}", user);
        HyperionKeyDTO key = new HyperionKeyDTO();
        log.info("准备返回的数据: {}", key);
        return Result.success(key);
    }

    @PostMapping("/register")
    public Result hyperionRegisterRequest(@RequestBody KakuyaUserDTO user) {
        log.info("将要注册的用户信息: {}", user);
        return Result.success();
    }
}
