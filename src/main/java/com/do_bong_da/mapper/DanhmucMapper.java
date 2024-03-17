package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Danhmuc;
import com.do_bong_da.dto.DanhmucDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DanhmucMapper extends EntityMapper<DanhmucDto, Danhmuc> {
}