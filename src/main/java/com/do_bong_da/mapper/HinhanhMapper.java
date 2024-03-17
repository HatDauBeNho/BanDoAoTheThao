package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Hinhanh;
import com.do_bong_da.dto.HinhanhDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HinhanhMapper extends EntityMapper<HinhanhDto, Hinhanh> {
}