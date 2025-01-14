package com.tanikazeriku.tanikazeriku.controller;


import com.tanikazeriku.tanikazeriku.common.request.Result;
import com.tanikazeriku.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import com.tanikazeriku.tanikazeriku.pojo.DTO.HyperionUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 通用 POST 请求
 */
@Slf4j
@RestController
@RequestMapping("persona")
public class GeneralPOSTController {

    // TODO: 还需要一个Service用来与数据库交互，一个autowired设置service用，稍后再说

    @PostMapping("/login")
    public Result hyperionLoginRequest(@RequestBody HyperionUserDTO user) {
        log.info("接收的body数据: {}", user);
        // 这里可以进行一些其他操作
        // 比如去数据库查找，匹配，验证等等等等
        // 查找到之后封装成一个DTO对象，返回
        HyperionKeyDTO key = new HyperionKeyDTO();
        log.info("准备返回的数据: {}", key);
        return Result.success(key);
    }

    @PostMapping("/register")
    public Result hyperionRegisterRequest(@RequestBody HyperionUserDTO user) {
        log.info("将要注册的用户信息: {}", user);
        // 注册，加密，等等以及其他
        return Result.success();
    }
}
