package com.tanikazeriku.controller.Kakuya;


import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
import com.tanikazeriku.pojo.DTO.*;
import com.tanikazeriku.pojo.Entity.*;
import com.tanikazeriku.pojo.Entity.Characters;
import com.tanikazeriku.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    // bug: 带_的全都没有

    @GetMapping(value = "/allUser")
    public Result allUsers() {
        List<User> userEntityList = userService.selectAll();
        List<KakuyaUserDTO> userDTOList = GeneralUtils.convertWithList(userEntityList, KakuyaUserDTO.class);
        log.info("result: {}", userDTOList);
        return Result.success(userDTOList);
    }
    @GetMapping(value = "/allCharacter")
    public Result allCharacter() {
        List<Characters> charactersEntityList = characterService.selectAll();
        List<KakuyaCharacterDTO> characterDTOList = GeneralUtils.convertWithList(charactersEntityList, KakuyaCharacterDTO.class);
        log.info("result: {}", characterDTOList);
        return Result.success(characterDTOList);
    }
    @GetMapping(value = "/allCharacterSkill")
    public Result allCharacterSkill() {
        List<CharacterSkill> characterSkillEntityList = characterSkillService.selectAll();
        List<KakuyaCharacterSkillDTO> characterSkillDTOList = GeneralUtils.convertWithList(characterSkillEntityList, KakuyaCharacterSkillDTO.class);
        log.info("result: {}", characterSkillDTOList);
        return Result.success(characterSkillDTOList);
    }
    @GetMapping(value = "/allDungeon")
    public Result allDungeon() {
        List<Dungeon> dungeonEntityList = dungeonService.selectAll();
        List<KakuyaDungeonDTO> dungeonDTOList = GeneralUtils.convertWithList(dungeonEntityList, KakuyaDungeonDTO.class);
        log.info("result: {}", dungeonDTOList);
        return Result.success(dungeonDTOList);
    }
    @GetMapping(value = "/allEventEasy")
    public Result allEventEasy() {
        List<Event> eventEasyEntityList = eventService.selectAllEasy();
        List<KakuyaEventDTO> eventEasyDTOList = GeneralUtils.convertWithList(eventEasyEntityList, KakuyaEventDTO.class);
        log.info("result: {}", eventEasyDTOList);
        return Result.success(eventEasyDTOList);
    }
    @GetMapping(value = "/allEventNormal")
    public Result allEventNormal() {
        List<Event> eventNormalEntityList = eventService.selectAllNormal();
        List<KakuyaEventDTO> eventNormalDTOList = GeneralUtils.convertWithList(eventNormalEntityList, KakuyaEventDTO.class);
        log.info("result: {}", eventNormalDTOList);
        return Result.success(eventNormalDTOList);
    }
    @GetMapping(value = "/allEventDifficult")
    public Result allEventDifficult() {
        List<Event> eventDifficultEntityList = eventService.selectAllDifficult();
        List<KakuyaEventDTO> eventDifficultDTOList = GeneralUtils.convertWithList(eventDifficultEntityList, KakuyaEventDTO.class);
        log.info("result: {}", eventDifficultDTOList);
        return Result.success(eventDifficultDTOList);
    }
    @GetMapping(value = "/allItem")
    public Result allItem() {
        List<Item> itemEntityList = itemService.selectAll();
        List<KakuyaItemDTO> itemDTOList = GeneralUtils.convertWithList(itemEntityList, KakuyaItemDTO.class);
        log.info("result: {}", itemDTOList);
        return Result.success(itemDTOList);
    }
}
