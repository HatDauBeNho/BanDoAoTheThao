package com.do_bong_da.common_api;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "donhang")
@Getter
@Setter
@DynamicUpdate
public class Donhang extends BaseEntity{

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ma_nguoi_dung")
    private Long maNguoiDung;

    @Column(name = "dia_chi")
    private String diaChi;
}
