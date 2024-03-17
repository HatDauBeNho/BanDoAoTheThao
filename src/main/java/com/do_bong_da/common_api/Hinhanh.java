package com.do_bong_da.common_api;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "hinhanh")
@Getter
@Setter
@DynamicUpdate
public class Hinhanh extends BaseEntity {
    @Column(name = "ma_san_pham")
    private Long maSanPham;

    @Column(name = "url_link")
    private String urlLink;
}
