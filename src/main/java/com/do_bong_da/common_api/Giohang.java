package com.do_bong_da.common_api;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "giohang")
@Getter
@Setter
@DynamicUpdate
public class Giohang extends BaseEntity{

    @Column(name = "ma_nguoi_dung")
    private Long maNguoiDung;

    @Column(name = "ma_san_pham")
    private Long maSanPham;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "gia_ban")
    private String giaBan;
}
