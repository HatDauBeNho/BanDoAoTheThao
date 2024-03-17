package com.do_bong_da.dto;

import com.do_bong_da.common_api.Sanpham;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

@ApiModel()
@Getter
@Setter
public class DonHangSanPhamDto extends BaseDto {
    private Long maDonHang;
    private Long maSanPham;
    private Integer soLuong;
    @Size(max = 255)
    private String mauSac;
    private BigDecimal giaBan;
    private String kichCo;

    public DonHangSanPhamDto() {
    }
}