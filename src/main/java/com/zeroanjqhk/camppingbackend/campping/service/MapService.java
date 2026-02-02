package com.zeroanjqhk.camppingbackend.campping.service;

import com.zeroanjqhk.camppingbackend.campping.entity.TbCampListEntity;
import com.zeroanjqhk.camppingbackend.campping.repository.TbCampListRepository;
import com.zeroanjqhk.camppingbackend.common.response.CommonResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    private final TbCampListRepository tbCampListRepository;

    public MapService(TbCampListRepository tbCampListRepository) {
        this.tbCampListRepository = tbCampListRepository;
    }

    public CommonResponse<Object> selectMapList(){

        tbCampListRepository.selectMapList(1,2);

        List<TbCampListEntity> tbCampListEntity = tbCampListRepository.selectCamppingList();
        return CommonResponse.success("11","as", tbCampListEntity);
    }
}
