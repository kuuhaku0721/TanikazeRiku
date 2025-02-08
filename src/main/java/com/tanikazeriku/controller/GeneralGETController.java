package com.tanikazeriku.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 通用 GET 请求
 */
@Slf4j
@RestController
@RequestMapping("gurei")
public class GeneralGETController {

    // TODO: 保留，之后再说

//    @GetMapping(value = "/player", produces = MediaType.IMAGE_PNG_VALUE)
//    public Result kakuyaCharacters() {
//        TestController testController = new TestController();
//        CharacterCard characterCard = testController.getCharacterbyId(3);
//        log.info("准备返回的数据: {}", characterCard.name);
//        return Result.success(characterCard);
//    }
    // TODO: 图片和角色信息分开传输，图片可以直接用
    // TODO: 有一个问题是，如果实体里面也存图片，实体会过大，占带宽，而且用不上，实体不带图片，那就得重新考虑写法了，有点麻烦
    // TODO: 似乎是没问题的，实体类没有数据库有的，mybatis会直接忽略
//    @GetMapping(value = "/player/{id}", produces = MediaType.IMAGE_PNG_VALUE)
//    public ResponseEntity<byte[]> getImage(@PathVariable int id) throws SQLException, IOException {
//        TestController testController = new TestController();
//        CharacterCard characterCard = testController.getCharacterbyId(id);
//        log.info("id = {}, name = {}", id, characterCard.name);
//        if (characterCard != null) {
//            return ResponseEntity.ok().body(characterCard.image);
//        }
//        return ResponseEntity.notFound().build();
//    }


}
