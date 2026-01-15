package com.zeroanjqhk.camppingbackend.campping.dsl;

import com.zeroanjqhk.camppingbackend.campping.entity.QTbCampListEntity;
import com.zeroanjqhk.camppingbackend.campping.entity.TbCampListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbCampListDslImpl implements TbCampListDsl {

    QTbCampListEntity Qtcl = QTbCampListEntity.tbCampListEntity;
    QTbCampListEntity t2 = new QTbCampListEntity("t2");

    @Override
    public List<TbCampListEntity> selectCmppingList() {





        return List.of();
    }
}
