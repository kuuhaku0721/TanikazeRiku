package com.tanikazeriku.controller.Kakuya;


import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
import com.tanikazeriku.pojo.DTO.*;
import com.tanikazeriku.pojo.Entity.*;
import com.tanikazeriku.pojo.Entity.Characters;
import com.tanikazeriku.pojo.VO.CharacterModel;
import com.tanikazeriku.pojo.VO.DuelModel;
import com.tanikazeriku.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 所有 "kakuya" 相关的get请求
 */
@Slf4j
@RestController
@RequestMapping("gurei/kakuya/")
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
    @GetMapping(value = "allUser")
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
    @GetMapping(value = "allCharacter")
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
    @GetMapping(value = "allCharacterSkill")
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
    @GetMapping(value = "allDungeon")
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
    @GetMapping(value = "allEventEasy")
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
    @GetMapping(value = "allEventNormal")
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
    @GetMapping(value = "allEventDifficult")
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
    @GetMapping(value = "allItem")
    public Result allItem() {
        List<Item> itemEntityList = itemService.selectAll();
        List<KakuyaItemDTO> itemDTOList = GeneralUtils.convertWithList(itemEntityList, KakuyaItemDTO.class);
        log.info("result: {}", itemDTOList);
        return Result.success(itemDTOList);
    }


    /**
     * 根据难度选一个dungeon决定一场对局
     * @param level 目标dungeon难度
     * @return 对局信息
     */
    @GetMapping(value = "duel/{level}")
    public Result getDuel(@PathVariable int level) {
        List<Dungeon> dungeonList = dungeonService.selectDungeonByLevel(level);
        Random random = new Random();
        int index = random.nextInt(dungeonList.size());
        Dungeon dungeon = dungeonList.get(index);

        DuelModel duelModel = new DuelModel();
        duelModel.setId(dungeon.getId());
        duelModel.setName(dungeon.getName());
        duelModel.setLevel(dungeon.getLevel());

        ArrayList<Integer> easyEventArray = new ArrayList<>();
        List<Event> allEasyEvent = eventService.selectAllEasy();
        for(int i = 0; i < dungeon.getEasyEventCount(); i++) {
            easyEventArray.add(random.nextInt(allEasyEvent.size()) + 1);
        }
        duelModel.setEasyEvent(easyEventArray.toString());

        ArrayList<Integer> normalEventArray = new ArrayList<>();
        List<Event> allNormalEvent = eventService.selectAllNormal();
        for (int i = 0; i < dungeon.getNormalEventCount(); i++) {
            normalEventArray.add(random.nextInt(allNormalEvent.size()) + 1);
        }
        duelModel.setNormalEvent(normalEventArray.toString());

        ArrayList<Integer> difficultEventArray = new ArrayList<>();
        List<Event> allDifficultEvent = eventService.selectAllDifficult();
        for (int i = 0; i < dungeon.getDifficultEventCount(); i++) {
            difficultEventArray.add(random.nextInt(allDifficultEvent.size()) + 1);
        }
        duelModel.setDifficultEvent(difficultEventArray.toString());

        ArrayList<Integer> itemArray = new ArrayList<>();
        List<Item> allItem = itemService.selectAll();
        for (int i = 0; i < dungeon.getItemCardCount(); i++) {
            itemArray.add(random.nextInt(allItem.size()) + 1);
        }
        duelModel.setItemArray(itemArray.toString());

        return Result.success(duelModel);
    }

    /**
     * 根据level和id获取对应等级的事件信息
     * @param level 需求的等级
     * @param id 需求的id
     * @return 对应的事件信息
     */
    @GetMapping("event/{level}/{id}")
    public Result getEventByLevelAndId(@PathVariable String level, @PathVariable int id) {
        if(level.equals("easy")) {
            Event event = eventService.getEasyEventById(id);
            KakuyaEventDTO eventDTO = GeneralUtils.convertEntityToDTO(event, KakuyaEventDTO.class);
            return Result.success(eventDTO);
        } else if(level.equals("normal")) {
            Event event = eventService.getNormalEventById(id);
            KakuyaEventDTO eventDTO = GeneralUtils.convertEntityToDTO(event, KakuyaEventDTO.class);
            return Result.success(eventDTO);
        } else if(level.equals("difficult")) {
            Event event = eventService.getDifficultEventById(id);
            KakuyaEventDTO eventDTO = GeneralUtils.convertEntityToDTO(event, KakuyaEventDTO.class);
            return Result.success(eventDTO);
        }
        return Result.error("输入的信息有误，请检查url参数");
    }

    /**
     * 随机获取一个character（with skill）
     * @return character和skill的组合类
     */
    @GetMapping("character")
    public Result getCharacter() {
        List<Characters> allCharacters = characterService.selectAll();
        Random random = new Random();
        Characters characters = allCharacters.get(random.nextInt(allCharacters.size()));

        CharacterSkill skill = characterSkillService.getSkillById(characters.getSkillId());

        KakuyaCharacterDTO characterDTO = GeneralUtils.convertEntityToDTO(characters, KakuyaCharacterDTO.class);
        KakuyaCharacterSkillDTO characterSkillDTO = GeneralUtils.convertEntityToDTO(skill, KakuyaCharacterSkillDTO.class);
        CharacterModel characterModel = new CharacterModel(characterDTO, characterSkillDTO);

        return Result.success(characterModel);
    }

    /**
     * 根据id获取对应的item信息
     * @param id 需求的id
     * @return 对应的item信息
     */
    @GetMapping("item/{id}")
    public Result getItemById(@PathVariable Integer id) {
        log.info("item id: {}", id);
        Item item = itemService.getItemById(id);
        KakuyaItemDTO itemDTO = GeneralUtils.convertEntityToDTO(item, KakuyaItemDTO.class);
        return Result.success(itemDTO);
    }

    /**
     * 无尽模式 获取一个dungeon，模式限定，获取到的一定是三星dungeon
     * @return 获取到的dungeon
     */
    @GetMapping(value = "duel/infinite")
    public Result getInfiniteDuel() {
        List<Dungeon> dungeonList = dungeonService.selectDungeonByLevel(3);
        Random random = new Random();
        int index = random.nextInt(dungeonList.size());
        Dungeon dungeon = dungeonList.get(index);

        DuelModel duelModel = new DuelModel();
        duelModel.setId(dungeon.getId());
        duelModel.setName(dungeon.getName());
        duelModel.setLevel(dungeon.getLevel());

        ArrayList<Integer> itemArray = new ArrayList<>();
        List<Item> allItem = itemService.selectAll();
        for (int i = 0; i < dungeon.getItemCardCount(); i++) {
            itemArray.add(random.nextInt(allItem.size()) + 1);
        }
        duelModel.setItemArray(itemArray.toString());

        return Result.success(duelModel);
    }

    /**
     * 无尽模式 获取一个事件卡 事件卡无等级限制，随机获取
     * @return 抽取到的事件卡
     */
    @GetMapping("event/infinite")
    public Result getInfiniteEvent() {
        Random random = new Random();
        Event event = null;
        int rate = random.nextInt(100) + 1;
        if(rate <= 20) {
            List<Event> eventList = eventService.selectAllEasy();
            event = eventList.get(random.nextInt(eventList.size()));
        } else if(rate <= 50) {
            List<Event> eventList = eventService.selectAllNormal();
            event = eventList.get(random.nextInt(eventList.size()));
        } else {
            List<Event> eventList = eventService.selectAllDifficult();
            event = eventList.get(random.nextInt(eventList.size()));
        }
        KakuyaEventDTO eventDTO = GeneralUtils.convertEntityToDTO(event, KakuyaEventDTO.class);
        return Result.success(eventDTO);
    }

}
