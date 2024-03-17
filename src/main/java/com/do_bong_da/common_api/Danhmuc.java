package com.do_bong_da.common_api;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "danhmuc")
@Getter
@Setter
@DynamicUpdate
public class Danhmuc extends BaseEntity{

    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;
}
