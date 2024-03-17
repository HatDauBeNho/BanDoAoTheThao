package com.do_bong_da.common_api;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "theloai")
@Getter
@Setter
@DynamicUpdate
public class Theloai extends BaseEntity {
    @Column(name = "ma_danh_muc")
    private Long maDanhMuc;

    @Column(name = "ten_the_loai")
    private String tenTheLoai;
}
