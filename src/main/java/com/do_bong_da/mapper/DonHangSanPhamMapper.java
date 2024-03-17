package com.do_bong_da.mapper;

import com.do_bong_da.common_api.DonHangSanPham;
import com.do_bong_da.dto.DonHangSanPhamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DonHangSanPhamMapper extends EntityMapper<DonHangSanPhamDto, DonHangSanPham> {
}