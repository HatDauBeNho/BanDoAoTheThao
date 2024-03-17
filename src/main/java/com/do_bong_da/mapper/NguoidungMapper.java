package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Nguoidung;
import com.do_bong_da.dto.NguoidungDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NguoidungMapper extends EntityMapper<NguoidungDto, Nguoidung> {
}