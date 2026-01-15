package com.zeroanjqhk.camppingbackend.campping.service;

import com.zeroanjqhk.camppingbackend.campping.entity.TbCampListEntity;
import com.zeroanjqhk.camppingbackend.campping.repository.TbCampListRepository;
import com.zeroanjqhk.camppingbackend.common.response.CommonResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HomeService {

    private TbCampListRepository tbCampListRepository;

    public HomeService(TbCampListRepository tbCampListRepository){
        this.tbCampListRepository =tbCampListRepository;
    }

    public CommonResponse<Object> selectCmppingList(){
        List<TbCampListEntity> tbCampListEntity = tbCampListRepository.selectCmppingList();
        return CommonResponse.success("11","as", tbCampListEntity);
    }
}
