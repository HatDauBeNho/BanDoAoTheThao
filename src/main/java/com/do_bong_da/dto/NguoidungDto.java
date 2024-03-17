package com.do_bong_da.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel()
@Getter
@Setter
public class NguoidungDto extends BaseDto {
    @Size(max = 255)
    private String tenDangNhap;
    @Size(max = 255)
    private String matKhau;
    @Size(max = 255)
    private String quyen;
    @Size(max = 255)
    private String hoTen;
    @Size(max = 255)
    private String soDienThoai;
    private int gioiTinh;
    private Date ngaySinh;
    @Size(max = 255)
    private String diaChi;

    public NguoidungDto() {
    }
}