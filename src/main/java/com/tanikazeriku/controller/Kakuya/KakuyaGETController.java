package com.tanikazeriku.controller.Kakuya;


import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
import com.tanikazeriku.pojo.DTO.*;
import com.tanikazeriku.pojo.Entity.*;
import com.tanikazeriku.pojo.Entity.Characters;
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
 * 所有 "kakuya" 相关的get请求
 */
@Slf4j
@RestController
@RequestMapping("gurei/kakuya")
public class KakuyaGETController {
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
     * 获取全部用户表数据
     * @return List<KakuyaUserDTO>
     */
    @GetMapping(value = "/allUser")
    public Result allUsers() {
        List<User> userEntityList = userService.selectAll();
        List<KakuyaUserDTO> userDTOList = GeneralUtils.convertWithList(userEntityList, KakuyaUserDTO.class);
        log.info("result: {}", userDTOList);
        return Result.success(userDTOList);
    }

    /**
     * 获取全部角色表数据
     * @return List<KakuyaCharacterDTO>
     */
    @GetMapping(value = "/allCharacter")
    public Result allCharacter() {
        List<Characters> charactersEntityList = characterService.selectAll();
        List<KakuyaCharacterDTO> characterDTOList = GeneralUtils.convertWithList(charactersEntityList, KakuyaCharacterDTO.class);
        log.info("result: {}", characterDTOList);
        return Result.success(characterDTOList);
    }

    /**
     * 获取全部技能表数据
     * @return List<KakuyaCharacterSkillDTO>
     */
    @GetMapping(value = "/allCharacterSkill")
    public Result allCharacterSkill() {
        List<CharacterSkill> characterSkillEntityList = characterSkillService.selectAll();
        List<KakuyaCharacterSkillDTO> characterSkillDTOList = GeneralUtils.convertWithList(characterSkillEntityList, KakuyaCharacterSkillDTO.class);
        log.info("result: {}", characterSkillDTOList);
        return Result.success(characterSkillDTOList);
    }

    /**
     * 获取全部迷宫表数据
     * @return List<KakuyaDungeonDTO>
     */
    @GetMapping(value = "/allDungeon")
    public Result allDungeon() {
        List<Dungeon> dungeonEntityList = dungeonService.selectAll();
        List<KakuyaDungeonDTO> dungeonDTOList = GeneralUtils.convertWithList(dungeonEntityList, KakuyaDungeonDTO.class);
        log.info("result: {}", dungeonDTOList);
        return Result.success(dungeonDTOList);
    }

    /**
     * 获取全部简单事件表数据
     * @return List<KakuyaEventDTO>
     */
    @GetMapping(value = "/allEventEasy")
    public Result allEventEasy() {
        List<Event> eventEasyEntityList = eventService.selectAllEasy();
        List<KakuyaEventDTO> eventEasyDTOList = GeneralUtils.convertWithList(eventEasyEntityList, KakuyaEventDTO.class);
        log.info("result: {}", eventEasyDTOList);
        return Result.success(eventEasyDTOList);
    }

    /**
     * 获取全部普通事件表数据
     * @return List<KakuyaEventDTO>
     */
    @GetMapping(value = "/allEventNormal")
    public Result allEventNormal() {
        List<Event> eventNormalEntityList = eventService.selectAllNormal();
        List<KakuyaEventDTO> eventNormalDTOList = GeneralUtils.convertWithList(eventNormalEntityList, KakuyaEventDTO.class);
        log.info("result: {}", eventNormalDTOList);
        return Result.success(eventNormalDTOList);
    }

    /**
     * 获取全部困难事件表数据
     * @return List<KakuyaEventDTO>
     */
    @GetMapping(value = "/allEventDifficult")
    public Result allEventDifficult() {
        List<Event> eventDifficultEntityList = eventService.selectAllDifficult();
        List<KakuyaEventDTO> eventDifficultDTOList = GeneralUtils.convertWithList(eventDifficultEntityList, KakuyaEventDTO.class);
        log.info("result: {}", eventDifficultDTOList);
        return Result.success(eventDifficultDTOList);
    }

    /**
     * 获取全部道具表数据
     * @return List<KakuyaItemDTO>
     */
    @GetMapping(value = "/allItem")
    public Result allItem() {
        List<Item> itemEntityList = itemService.selectAll();
        List<KakuyaItemDTO> itemDTOList = GeneralUtils.convertWithList(itemEntityList, KakuyaItemDTO.class);
        log.info("result: {}", itemDTOList);
        return Result.success(itemDTOList);
    }

    /**
     * 根据id获取图片
     * @param id dugeon的id
     * @return 对应的图片
     */
    @GetMapping(value = "/image/dungeon/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImageById(@PathVariable int id) {
        log.info("dungeon id: {}", id);
        ImageWrapper image = dungeonService.getImageById(id);
        if (image != null) {
            return ResponseEntity.ok().body(image.getImage());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 根据id获取用户头像icon
     * @param id 用户id
     * @return icon
     */
    @GetMapping(value = "/image/user/{id}", produces = MediaType.IMAGE_PNG_VALUE)
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
}
