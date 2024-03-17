package com.do_bong_da.common_api;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sanpham")
@Getter
@Setter
@DynamicUpdate
public class Sanpham extends BaseEntity{

    @Column(name = "ma_the_loai")
    private Long maTheLoai;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

    @Column(name = "nha_cung_cap")
    private String nhaCungCap;

    @Column(name = "xuat_xu")
    private String xuatXu;

    @Column(name = "kich_co")
    private String kichCo;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "trong_luong")
    private String trongLuong;

    @Column(name = "ten_anh")
    private String tenAnh;
}
