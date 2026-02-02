package com.zeroanjqhk.camppingbackend.campping.controller;

import com.zeroanjqhk.camppingbackend.campping.service.HomeService;
import com.zeroanjqhk.camppingbackend.campping.service.MapService;
import com.zeroanjqhk.camppingbackend.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping("/selectMapList")
    public CommonResponse<Object> selectMapList() {
        return  mapService.selectMapList();
    }

}
