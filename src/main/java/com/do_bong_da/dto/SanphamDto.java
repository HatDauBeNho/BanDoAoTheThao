package com.do_bong_da.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@ApiModel()
@Getter
@Setter
public class SanphamDto extends BaseDto {
    private Long maTheLoai;
    @Size(max = 255)
    private String tenSanPham;
    private BigDecimal giaBan;
    @Size(max = 255)
    private String nhaCungCap;
    @Size(max = 255)
    private String xuatXu;
    @Size(max = 255)
    private String kichCo;
    private String mauSac;
    private String trongLuong;
    private String tenAnh;

    public SanphamDto() {
    }
}