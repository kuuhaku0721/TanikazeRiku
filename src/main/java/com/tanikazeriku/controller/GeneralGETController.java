package com.tanikazeriku.controller;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import com.tanikazeriku.pojo.Entity.CharacterCard;
import com.tanikazeriku.pojo.Entity.User;
import com.tanikazeriku.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 通用 GET 请求
 */
@Slf4j
@RestController
@RequestMapping("gurei")
public class GeneralGETController {

    @Autowired
    private UserService userService;

    @GetMapping("/key")
    public Result hyperionLoginRequest() {
        HyperionKeyDTO key = new HyperionKeyDTO();
        log.info("准备返回的数据: {}", key);
        return Result.success(key);
    }

    @GetMapping(value = "/player", produces = MediaType.IMAGE_PNG_VALUE)
    public Result kakuyaCharacters() {
        TestController testController = new TestController();
        CharacterCard characterCard = testController.getCharacterbyId(3);
        log.info("准备返回的数据: {}", characterCard.name);
        return Result.success(characterCard);
    }
    // TODO: 图片和角色信息分开传输，图片可以直接用
    // TODO: 有一个问题是，如果实体里面也存图片，实体会过大，占带宽，而且用不上，实体不带图片，那就得重新考虑写法了，有点麻烦
    // TODO: 似乎是没问题的，实体类没有数据库有的，mybatis会直接忽略
    @GetMapping(value = "/player/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable int id) throws SQLException, IOException {
        TestController testController = new TestController();
        CharacterCard characterCard = testController.getCharacterbyId(id);
        log.info("id = {}, name = {}", id, characterCard.name);
        if (characterCard != null) {
            return ResponseEntity.ok().body(characterCard.image);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/user")
    public Result kakuyaUsers() {
        User user = userService.getAllUsers();
        log.info("准备返回的数据: {}", user);
        return Result.success(user);
    }
}
