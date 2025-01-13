package com.tanikazeriku.tanikazeriku.controller;

import com.tanikazeriku.tanikazeriku.common.request.Result;
import com.tanikazeriku.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用 GET 请求
 */
@Slf4j
@RestController
@RequestMapping("gurei")
public class GeneralGETController {

    // TODO: 还需要一个Service用来与数据库交互，一个autowired设置service用，稍后再说

    @GetMapping("/key")
    public Result hyperionLoginRequest() {
        HyperionKeyDTO key = new HyperionKeyDTO();
        log.info("准备返回的数据: {}", key);
        return Result.success(key);
    }
}
