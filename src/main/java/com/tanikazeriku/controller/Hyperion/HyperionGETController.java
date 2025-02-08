package com.tanikazeriku.controller.Hyperion;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("gurei/hyperion")
public class HyperionGETController {


    @GetMapping("/user")
    public Result loginRequest() {
        HyperionKeyDTO key = new HyperionKeyDTO();
        log.info("准备返回的数据: {}", 1);
        return Result.success(key);
    }


}
