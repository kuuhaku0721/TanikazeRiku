package com.tanikazeriku.controller.Kakuya;

import com.tanikazeriku.pojo.Entity.Dungeon;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.User;
import com.tanikazeriku.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * kakuya 需要的 所有 图片 请求
 */
@Slf4j
@RestController
@RequestMapping("gurei/kakuya/image/")
public class KakuyaGETImageController {
    @Autowired
    private UserService userService;
    @Autowired
    private CharacterService characterService;
    @Autowired
    private CharacterSkillService characterSkillService;
    @Autowired
    private DungeonService dungeonService;
    @Autowired
    private EventService eventService;
    @Autowired
    private ItemService itemService;

    /**
     * 根据id获取图片
     * @param id dungeon的id
     * @return 对应的图片
     */
    @GetMapping(value = "dungeon/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImageById(@PathVariable int id) {
        log.info("dungeon id: {}", id);
        ImageWrapper image = dungeonService.getImageById(id);
        if (image != null) {
            return ResponseEntity.ok().body(image.getImage());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 根据id获取星级图片
     * @param id dungeon的id
     * @return dungeon对应的星级图片
     */
    @GetMapping(value = "level/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getLevelImageById(@PathVariable int id) {
        // bug: 数据库存储的level_star 带下划线，识别不出来
        log.info("dungeon id: {}", id);
        Dungeon dungeon = dungeonService.getLevelImageById(id);
        if (dungeon != null) {
            return ResponseEntity.ok().body(dungeon.getLevelStar());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 根据id获取用户头像icon
     * @param id 用户id
     * @return icon
     */
    @GetMapping(value = "user/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getIconById(@PathVariable int id) {
        log.info("user id: {}", id);
        List<User> userList = userService.selectAll();
        byte[] img = null;
        for(User user : userList) {
            if(user.getId() == id) {
                img = user.getIcon();
                break;
            }
        }
        if (img != null) {
            return ResponseEntity.ok().body(img);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 根据等级和id获取对应的事件图片
     * @param level 需求的等级
     * @param id 需求的id
     * @return 对应的image
     */
    @GetMapping(value = "event/{level}/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getEventImageByLevelAndId(@PathVariable String level ,@PathVariable int id) {
        log.info("event level: {} id: {}", level, id);
        ImageWrapper image = null;
        if(level.equals("easy")) {
            image = eventService.getEasyEventImageById(id);
        } else if(level.equals("normal")) {
            image = eventService.getNormalEventImageById(id);
        } else if(level.equals("difficult")) {
            image = eventService.getDifficultEventImageById(id);
        }
        if (image != null) {
            return ResponseEntity.ok().body(image.getImage());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 根据id获取角色图片
     * @param id 需求的character id
     * @return 对应的image
     */
    @GetMapping(value = "character/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getCharacterImageById(@PathVariable int id) {
        log.info("character id: {}", id);
        ImageWrapper image = characterService.getImageById(id);
        if (image != null) {
            return ResponseEntity.ok().body(image.getImage());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 根据id获取对应的item 图片
     * @param id 需求的id
     * @return 对应的image
     */
    @GetMapping(value = "item/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getItemImageById(@PathVariable int id) {
        log.info("item id: {}", id);        ImageWrapper image = itemService.getItemImageById(id);
        if (image != null) {
            return ResponseEntity.ok().body(image.getImage());
        }
        return ResponseEntity.notFound().build();
    }

}
