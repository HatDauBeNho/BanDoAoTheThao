package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Theloai;
import com.do_bong_da.dto.TheloaiDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TheloaiMapper extends EntityMapper<TheloaiDto, Theloai> {
}