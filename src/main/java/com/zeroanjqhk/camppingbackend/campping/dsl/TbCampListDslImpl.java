package com.zeroanjqhk.camppingbackend.campping.dsl;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zeroanjqhk.camppingbackend.campping.entity.QTbCampListEntity;
import com.zeroanjqhk.camppingbackend.campping.entity.TbCampListEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbCampListDslImpl implements TbCampListDsl {

    private final JPAQueryFactory queryFactory;
    private final QTbCampListEntity qtcl = QTbCampListEntity.tbCampListEntity;

    public TbCampListDslImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<TbCampListEntity> selectCmppingList() {
        return queryFactory.selectFrom(qtcl).fetch();
    }

    @Override
    public List<TbCampListEntity> selectMapList(double lng, double lat) {
        NumberTemplate<Double> distance = Expressions.numberTemplate(
                Double.class,
                "ST_Distance_Sphere(POINT({0}, {1}), POINT({2}, {3}))",
                qtcl.mapX, qtcl.mapY, lng, lat
        );

        return queryFactory
                .selectFrom(qtcl)
                .where(distance.loe(5000))
                .fetch();
    }
}
