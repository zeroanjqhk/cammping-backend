package com.zeroanjqhk.camppingbackend.campping.entity;

import com.zeroanjqhk.camppingbackend.external.gocampping.response.BasedListResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_camp_list")
@Getter
@Setter
@NoArgsConstructor
public class TbCampListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "content_id", nullable = false, length = 32, unique = true)
    private String contentId;

    @Column(name = "faclt_nm", nullable = false, length = 255)
    private String facltNm;

    @Column(name = "addr1", length = 255)
    private String addr1;

    @Column(name = "do_nm", length = 20)
    private String doNm;

    @Column(name = "sigungu_nm", length = 30)
    private String sigunguNm;

    @Column(name = "tel", length = 30)
    private String tel;

    @Column(name = "homepage", length = 500)
    private String homepage;

    @Column(name = "first_image_url", length = 800)
    private String firstImageUrl;

    @Column(name = "map_x", length = 20)
    private String mapX;

    @Column(name = "map_y", length = 20)
    private String mapY;

    @Column(name = "induty", length = 100)
    private String induty;

    @Column(name = "manage_sttus", length = 20)
    private String manageSttus;

    @Column(name = "line_intro", length = 500)
    private String lineIntro;

    @Lob
    @Column(name = "intro")
    private String intro;

    @Column(name = "createdtime")
    private String createdtime;

    @Column(name = "modifiedtime")
    private java.time.LocalDate modifiedtime;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", insertable = false, updatable = false)
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private java.time.LocalDateTime updatedAt;


    public void tbCampListSync(BasedListResponse.Item response) {
        this.contentId = response.contentId();
        this.facltNm = response.facltNm();
        this.addr1 = response.addr1();
        this.doNm = response.doNm();
        this.sigunguNm = response.sigunguNm();
        this.tel = response.tel();
        this.firstImageUrl = response.firstImageUrl();
        this.mapX = response.mapX();
        this.mapY = response.mapY();
        this.induty = response.induty();
        this.manageSttus = response.manageSttus();
        this.lineIntro = response.lineIntro();
        this.intro = response.intro();
    }
}