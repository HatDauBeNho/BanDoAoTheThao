package com.do_bong_da.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel()
@Getter
@Setter
public class DanhmucDto extends BaseDto {
    private String tenDanhMuc;

    public DanhmucDto() {
    }
}