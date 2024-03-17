package com.do_bong_da.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@ApiModel()
@Getter
@Setter
public class GiohangDto extends BaseDto {
    private Long maNguoiDung;
    private Long maSanPham;
    private Integer soLuong;
    private String mauSac;
    private String giaBan;

    public GiohangDto() {
    }
}