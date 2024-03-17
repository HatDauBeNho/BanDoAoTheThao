package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Giohang;
import com.do_bong_da.dto.GiohangDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GiohangMapper extends EntityMapper<GiohangDto, Giohang> {
}