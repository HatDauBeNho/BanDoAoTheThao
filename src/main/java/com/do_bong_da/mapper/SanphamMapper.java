package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Sanpham;
import com.do_bong_da.dto.SanphamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SanphamMapper extends EntityMapper<SanphamDto, Sanpham> {
}