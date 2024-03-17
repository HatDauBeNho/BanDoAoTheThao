package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Hinhanh;
import com.do_bong_da.dto.HinhanhDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T20:11:48+0700",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class HinhanhMapperImpl implements HinhanhMapper {

    @Override
    public Hinhanh toEntity(HinhanhDto dto) {
        if ( dto == null ) {
            return null;
        }

        Hinhanh hinhanh = new Hinhanh();

        hinhanh.setId( dto.getId() );
        hinhanh.setModifiedUser( dto.getModifiedUser() );
        hinhanh.setModifiedDate( dto.getModifiedDate() );
        hinhanh.setCreatedUser( dto.getCreatedUser() );
        hinhanh.setCreatedDate( dto.getCreatedDate() );
        hinhanh.setDeleted( dto.isDeleted() );
        hinhanh.setMaSanPham( dto.getMaSanPham() );
        hinhanh.setUrlLink( dto.getUrlLink() );

        return hinhanh;
    }

    @Override
    public HinhanhDto toDto(Hinhanh entity) {
        if ( entity == null ) {
            return null;
        }

        HinhanhDto hinhanhDto = new HinhanhDto();

        hinhanhDto.setId( entity.getId() );
        hinhanhDto.setModifiedUser( entity.getModifiedUser() );
        hinhanhDto.setModifiedDate( entity.getModifiedDate() );
        hinhanhDto.setCreatedUser( entity.getCreatedUser() );
        hinhanhDto.setCreatedDate( entity.getCreatedDate() );
        hinhanhDto.setDeleted( entity.isDeleted() );
        hinhanhDto.setMaSanPham( entity.getMaSanPham() );
        hinhanhDto.setUrlLink( entity.getUrlLink() );

        return hinhanhDto;
    }

    @Override
    public List<Hinhanh> toEntity(List<HinhanhDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Hinhanh> list = new ArrayList<Hinhanh>( dtoList.size() );
        for ( HinhanhDto hinhanhDto : dtoList ) {
            list.add( toEntity( hinhanhDto ) );
        }

        return list;
    }

    @Override
    public List<HinhanhDto> toDto(List<Hinhanh> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HinhanhDto> list = new ArrayList<HinhanhDto>( entityList.size() );
        for ( Hinhanh hinhanh : entityList ) {
            list.add( toDto( hinhanh ) );
        }

        return list;
    }

    @Override
    public Set<HinhanhDto> toDto(Set<Hinhanh> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<HinhanhDto> set = new LinkedHashSet<HinhanhDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Hinhanh hinhanh : entityList ) {
            set.add( toDto( hinhanh ) );
        }

        return set;
    }
}
