package com.tanikazeriku.controller.Hyperion;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import com.tanikazeriku.pojo.DTO.HyperionUserDTO;
import com.tanikazeriku.pojo.DTO.KakuyaUserDTO;
import com.tanikazeriku.pojo.Entity.User;
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
    public Result hyperionLoginRequest(@RequestBody HyperionUserDTO user) {
        // 验证成功
        HyperionKeyDTO key = new HyperionKeyDTO();
        log.info("准备返回的数据: {}", key);
        return Result.success(key);
    }

    @PostMapping("/register")
    public Result hyperionRegisterRequest(@RequestBody HyperionUserDTO user) {
        return Result.success();
    }
}
