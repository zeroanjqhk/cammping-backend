package com.zeroanjqhk.camppingbackend.campping.controller;

import com.zeroanjqhk.camppingbackend.campping.service.HomeService;
import com.zeroanjqhk.camppingbackend.common.response.CommonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    private HomeService homeService;

    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }

    @PostMapping("/selectCamppingList")
    public CommonResponse<Object> selectCamppingList() {
        return  homeService.selectCamppingList();
    }

}
