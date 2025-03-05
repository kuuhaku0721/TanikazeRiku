package com.tanikazeriku.controller.Hyperion;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
import com.tanikazeriku.pojo.DTO.HyperionKeyDTO;
import com.tanikazeriku.pojo.DTO.HyperionValkyrieDTO;
import com.tanikazeriku.pojo.Entity.ValkyrieMedias;
import com.tanikazeriku.pojo.Entity.Valkyries;
import com.tanikazeriku.pojo.VO.ValkyrieInfoModel;
import com.tanikazeriku.service.ValkyrieMediasService;
import com.tanikazeriku.service.ValkyriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("gurei/hyperion")
public class HyperionGETController {

    @Autowired
    private ValkyriesService valkyriesService;

    @Autowired
    private ValkyrieMediasService valkyrieMediasService;


    @GetMapping("/user")
    public Result loginRequest() {
        HyperionKeyDTO key = new HyperionKeyDTO();
        log.info("准备返回的数据: {}", 1);
        return Result.success(key);
    }

    @GetMapping("/allImageUri")
    public Result getAllImageUri() {
        List<Valkyries> valkyriesList = valkyriesService.selectAll();
        List<ValkyrieMedias> valkyrieMediasList = valkyrieMediasService.selectAll();

        List<HyperionValkyrieDTO> dtoList = GeneralUtils.convertWithList(valkyriesList, HyperionValkyrieDTO.class);
        List<HyperionValkyrieDTO> anotherList = GeneralUtils.convertWithList(valkyrieMediasList, HyperionValkyrieDTO.class);
        dtoList.addAll(anotherList);

        return Result.success(dtoList);
    }

    @GetMapping("/valkyrie/{name}")
    public Result getValkyrieInfoByName(@PathVariable String name) {
        ValkyrieInfoModel model = new ValkyrieInfoModel();

        Valkyries valkyries = valkyriesService.selectByName(name);
        if(valkyries != null) {
            model.setTitle(valkyries.getName());
            model.setSubTitle(valkyries.getTitle());
            model.setImageUri(valkyries.getImageUri());
            model.setDescription(valkyries.getDescription());
        }

        ValkyrieMedias valkyrieMedias = valkyrieMediasService.selectByName(name);
        if(valkyrieMedias != null) {
            model.setTitle(valkyrieMedias.getName());
            model.setSubTitle(valkyrieMedias.getFileName());
            model.setImageUri(valkyrieMedias.getImageUri());
            model.setDescription(valkyrieMedias.getDescriptionComplete());
        }

        return Result.success(model);
    }




}
