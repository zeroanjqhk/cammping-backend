package com.zeroanjqhk.camppingbackend.campping.repository;

import com.zeroanjqhk.camppingbackend.campping.entity.TbCampListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbCampListRepository extends JpaRepository<TbCampListEntity, Integer> {

    @Query(value = """
        SELECT *
        FROM (
          SELECT t.*, ROW_NUMBER() OVER(PARTITION BY do_nm ORDER BY seq) rn
          FROM tb_camp_list t
        ) a
        WHERE a.rn <= 2
        """, nativeQuery = true)
    List<TbCampListEntity> selectCmppingList();

}
