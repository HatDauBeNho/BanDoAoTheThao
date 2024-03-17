package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Donhang;
import com.do_bong_da.dto.DonhangDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-17T20:11:47+0700",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class DonhangMapperImpl implements DonhangMapper {

    @Override
    public Donhang toEntity(DonhangDto dto) {
        if ( dto == null ) {
            return null;
        }

        Donhang donhang = new Donhang();

        donhang.setId( dto.getId() );
        donhang.setModifiedUser( dto.getModifiedUser() );
        donhang.setModifiedDate( dto.getModifiedDate() );
        donhang.setCreatedUser( dto.getCreatedUser() );
        donhang.setCreatedDate( dto.getCreatedDate() );
        donhang.setDeleted( dto.isDeleted() );
        donhang.setTrangThai( dto.getTrangThai() );
        donhang.setMaNguoiDung( dto.getMaNguoiDung() );
        donhang.setDiaChi( dto.getDiaChi() );

        return donhang;
    }

    @Override
    public DonhangDto toDto(Donhang entity) {
        if ( entity == null ) {
            return null;
        }

        DonhangDto donhangDto = new DonhangDto();

        donhangDto.setId( entity.getId() );
        donhangDto.setModifiedUser( entity.getModifiedUser() );
        donhangDto.setModifiedDate( entity.getModifiedDate() );
        donhangDto.setCreatedUser( entity.getCreatedUser() );
        donhangDto.setCreatedDate( entity.getCreatedDate() );
        donhangDto.setDeleted( entity.isDeleted() );
        donhangDto.setTrangThai( entity.getTrangThai() );
        donhangDto.setMaNguoiDung( entity.getMaNguoiDung() );
        donhangDto.setDiaChi( entity.getDiaChi() );

        return donhangDto;
    }

    @Override
    public List<Donhang> toEntity(List<DonhangDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Donhang> list = new ArrayList<Donhang>( dtoList.size() );
        for ( DonhangDto donhangDto : dtoList ) {
            list.add( toEntity( donhangDto ) );
        }

        return list;
    }

    @Override
    public List<DonhangDto> toDto(List<Donhang> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DonhangDto> list = new ArrayList<DonhangDto>( entityList.size() );
        for ( Donhang donhang : entityList ) {
            list.add( toDto( donhang ) );
        }

        return list;
    }

    @Override
    public Set<DonhangDto> toDto(Set<Donhang> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<DonhangDto> set = new LinkedHashSet<DonhangDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Donhang donhang : entityList ) {
            set.add( toDto( donhang ) );
        }

        return set;
    }
}
