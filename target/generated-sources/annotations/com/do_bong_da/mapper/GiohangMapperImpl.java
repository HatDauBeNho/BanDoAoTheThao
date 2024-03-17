package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Giohang;
import com.do_bong_da.dto.GiohangDto;
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
public class GiohangMapperImpl implements GiohangMapper {

    @Override
    public Giohang toEntity(GiohangDto dto) {
        if ( dto == null ) {
            return null;
        }

        Giohang giohang = new Giohang();

        giohang.setId( dto.getId() );
        giohang.setModifiedUser( dto.getModifiedUser() );
        giohang.setModifiedDate( dto.getModifiedDate() );
        giohang.setCreatedUser( dto.getCreatedUser() );
        giohang.setCreatedDate( dto.getCreatedDate() );
        giohang.setDeleted( dto.isDeleted() );
        giohang.setMaNguoiDung( dto.getMaNguoiDung() );
        giohang.setMaSanPham( dto.getMaSanPham() );
        giohang.setSoLuong( dto.getSoLuong() );
        giohang.setMauSac( dto.getMauSac() );
        giohang.setGiaBan( dto.getGiaBan() );

        return giohang;
    }

    @Override
    public GiohangDto toDto(Giohang entity) {
        if ( entity == null ) {
            return null;
        }

        GiohangDto giohangDto = new GiohangDto();

        giohangDto.setId( entity.getId() );
        giohangDto.setModifiedUser( entity.getModifiedUser() );
        giohangDto.setModifiedDate( entity.getModifiedDate() );
        giohangDto.setCreatedUser( entity.getCreatedUser() );
        giohangDto.setCreatedDate( entity.getCreatedDate() );
        giohangDto.setDeleted( entity.isDeleted() );
        giohangDto.setMaNguoiDung( entity.getMaNguoiDung() );
        giohangDto.setMaSanPham( entity.getMaSanPham() );
        giohangDto.setSoLuong( entity.getSoLuong() );
        giohangDto.setMauSac( entity.getMauSac() );
        giohangDto.setGiaBan( entity.getGiaBan() );

        return giohangDto;
    }

    @Override
    public List<Giohang> toEntity(List<GiohangDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Giohang> list = new ArrayList<Giohang>( dtoList.size() );
        for ( GiohangDto giohangDto : dtoList ) {
            list.add( toEntity( giohangDto ) );
        }

        return list;
    }

    @Override
    public List<GiohangDto> toDto(List<Giohang> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<GiohangDto> list = new ArrayList<GiohangDto>( entityList.size() );
        for ( Giohang giohang : entityList ) {
            list.add( toDto( giohang ) );
        }

        return list;
    }

    @Override
    public Set<GiohangDto> toDto(Set<Giohang> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<GiohangDto> set = new LinkedHashSet<GiohangDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Giohang giohang : entityList ) {
            set.add( toDto( giohang ) );
        }

        return set;
    }
}
