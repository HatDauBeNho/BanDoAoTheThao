package com.do_bong_da.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class HinhanhDto extends BaseDto {
    private Long maSanPham;
    @Size(max = 255)
    private String urlLink;

    public HinhanhDto() {
    }
}