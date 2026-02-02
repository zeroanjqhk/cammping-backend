package com.zeroanjqhk.camppingbackend.campping.dsl;

import com.zeroanjqhk.camppingbackend.campping.entity.TbCampListEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TbCampListDsl {

    /* home */
    List<TbCampListEntity> selectCmppingList();


    /* map */
    List<TbCampListEntity> selectMapList(double lng, double lat);


}
