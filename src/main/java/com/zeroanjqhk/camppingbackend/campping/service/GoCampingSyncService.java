package com.zeroanjqhk.camppingbackend.campping.service;

import com.zeroanjqhk.camppingbackend.campping.entity.TbCampListEntity;
import com.zeroanjqhk.camppingbackend.campping.repository.TbCampListRepository;
import com.zeroanjqhk.camppingbackend.external.gocampping.client.GoCampingClient;
import com.zeroanjqhk.camppingbackend.external.gocampping.request.BasedListRequest;
import com.zeroanjqhk.camppingbackend.external.gocampping.response.BasedListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoCampingSyncService {

    private final GoCampingClient client;
    private final ObjectMapper mapper;
    private final TbCampListRepository tbCampListRepository;
    // private final CampRepository repo;  // DB 붙으면

    public void sync() {
        var req = new BasedListRequest(1, 10);
        String raw = client.fetchBasedListRaw(req);
        BasedListResponse response = mapper.readValue(raw, BasedListResponse.class);
        System.out.println("[GoCampingBasedSyncJob] raw => " + response.response().body().items().item());

        List<BasedListResponse.Item> datas = response.response().body().items().item();
        List<TbCampListEntity> list = tbCampListRepository.findAll();
        
        if(list == null || list.size() == 0) {

            System.out.println("db데이터 없음");
            List<TbCampListEntity> entities = datas.stream()
                    .map(item -> {
                        TbCampListEntity e = new TbCampListEntity();
                        e.tbCampListSync(item);
                        return e;
                    })
                    .toList();

            tbCampListRepository.saveAll(entities);


        }else{

            // list = DB에서 조회한 TbCampListEntity 리스트
            Map<String, TbCampListEntity> dbMap = list.stream()
                    .collect(Collectors.toMap(
                            TbCampListEntity::getContentId,
                            Function.identity()
                    ));

            List<TbCampListEntity> toSave = new ArrayList<>();

            for (BasedListResponse.Item data : datas) {

                String contentId = data.contentId();
                if (contentId == null || contentId.isBlank()) continue;
                TbCampListEntity entity = dbMap.get(contentId);

                if (entity == null) {
                    //DB에 없음 → insert
                    TbCampListEntity newEntity = new TbCampListEntity();
                    newEntity.tbCampListSync(data);
                    toSave.add(newEntity);
                } else {
                    //DB에 있음 → update
                    entity.tbCampListSync(data);
                    toSave.add(entity);
                }
            }

            tbCampListRepository.saveAll(toSave);
            System.out.println("db데이터 있음 - sync 완료");
        }
        
        log.info("raw length={}", raw != null ? raw.length() : 0);
    }
}

