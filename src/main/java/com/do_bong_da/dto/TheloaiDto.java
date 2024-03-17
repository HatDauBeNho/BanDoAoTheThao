package com.do_bong_da.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class TheloaiDto extends BaseDto {
    private Long maDanhMuc;
    @Size(max = 255)
    private String tenTheLoai;

    public TheloaiDto() {
    }
}