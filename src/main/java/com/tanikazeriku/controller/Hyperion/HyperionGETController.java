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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("gurei/hyperion")
@CrossOrigin(origins = "http://localhost:5173")
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

        log.info("返回值大小: {}", dtoList.size());

        return Result.success(dtoList);
    }

    @GetMapping("/allImageUriPre")
    public Result getAllImageUriForPre() {
        List<ValkyrieMedias> valkyrieMediasList = valkyrieMediasService.selectAll();

        List<HyperionValkyrieDTO> dtoList = GeneralUtils.convertWithList(valkyrieMediasList, HyperionValkyrieDTO.class);
        List<HyperionValkyrieDTO> result = new ArrayList<>();
        for (int i = 0; i < dtoList.size(); i++) {
            if(i > 20) {
                result.add(dtoList.get(i));
            }
        }

        log.info("返回值大小: {}", result.size());

        return Result.success(result);
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

    @GetMapping("/valkyrie/all")
    public Result getAllValkyries() {
        List<ValkyrieMedias> valkyrieMediasList = valkyrieMediasService.selectAll();
        List<ValkyrieInfoModel> valkyrieInfoModelList = new ArrayList<>();
        for (ValkyrieMedias valkyrieMedia: valkyrieMediasList) {
            ValkyrieInfoModel model = new ValkyrieInfoModel();
            model.setTitle(valkyrieMedia.getName());
            model.setSubTitle(valkyrieMedia.getFileName());
            model.setImageUri(valkyrieMedia.getImageUri());
            model.setDescription(valkyrieMedia.getDescriptionShort());
            valkyrieInfoModelList.add(model);
        }
        return Result.success(valkyrieInfoModelList);
    }

    @GetMapping("/valkyrie/allPre")
    public Result getAllValkyriesForPre() {
        List<ValkyrieMedias> valkyrieMediasList = valkyrieMediasService.selectAll();
        List<ValkyrieInfoModel> valkyrieInfoModelList = new ArrayList<>();
        for (ValkyrieMedias valkyrieMedia: valkyrieMediasList) {
            if(valkyrieMedia.getId() > 21) {
                ValkyrieInfoModel model = new ValkyrieInfoModel();
                model.setTitle(valkyrieMedia.getName());
                model.setSubTitle(valkyrieMedia.getFileName());
                model.setImageUri(valkyrieMedia.getImageUri());
                model.setDescription(valkyrieMedia.getDescriptionShort());
                valkyrieInfoModelList.add(model);
            }
        }
        return Result.success(valkyrieInfoModelList);
    }




}
