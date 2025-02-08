package com.tanikazeriku.controller;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.service.CharacterService;
import com.tanikazeriku.service.DungeonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * 通用 GET 请求
 */
@Slf4j
@RestController
@RequestMapping("gurei")
public class GeneralGETController {
    @Autowired
    private CharacterService characterService;
    @Autowired
    private DungeonService dungeonService;

    /**
     * 获取一个随机图片
     * @return 随机挑一张图片
     */
    @GetMapping(value = "/randomImage", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> randomImage()  {
        List<ImageWrapper> allImages = characterService.getAllImages();
        List<ImageWrapper> dungeonImages = dungeonService.getAllImages();
        allImages.addAll(dungeonImages);

        Random random = new Random();
        int index = random.nextInt(allImages.size());
        ImageWrapper image = allImages.get(index);
        if (image != null) {
            return ResponseEntity.ok().body(image.getImage());
        }
        log.info("image is null, it`s error, check the method define");
        return ResponseEntity.notFound().build();
    }



}
