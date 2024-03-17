package com.do_bong_da.common_api;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "donhang_sanpham")
@Getter
@Setter
@DynamicUpdate
public class DonHangSanPham extends BaseEntity {

    @Column(name = "ma_don_hang")
    private Long maDonHang;

    @Column(name = "ma_san_pham")
    private Long maSanPham;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

    @Column(name = "kich_co")
    private String kichCo;
}
