package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Donhang;
import com.do_bong_da.dto.DonhangDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DonhangMapper extends EntityMapper<DonhangDto, Donhang> {
}