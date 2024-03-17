package com.do_bong_da.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@ApiModel()
@Getter
@Setter
public class DonhangDto extends BaseDto {
    private String trangThai;
    private Long maNguoiDung;
    private String diaChi;

    public DonhangDto() {
    }
}