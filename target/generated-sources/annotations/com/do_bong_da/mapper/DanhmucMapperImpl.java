package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Danhmuc;
import com.do_bong_da.dto.DanhmucDto;
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
public class DanhmucMapperImpl implements DanhmucMapper {

    @Override
    public Danhmuc toEntity(DanhmucDto dto) {
        if ( dto == null ) {
            return null;
        }

        Danhmuc danhmuc = new Danhmuc();

        danhmuc.setId( dto.getId() );
        danhmuc.setModifiedUser( dto.getModifiedUser() );
        danhmuc.setModifiedDate( dto.getModifiedDate() );
        danhmuc.setCreatedUser( dto.getCreatedUser() );
        danhmuc.setCreatedDate( dto.getCreatedDate() );
        danhmuc.setDeleted( dto.isDeleted() );
        danhmuc.setTenDanhMuc( dto.getTenDanhMuc() );

        return danhmuc;
    }

    @Override
    public DanhmucDto toDto(Danhmuc entity) {
        if ( entity == null ) {
            return null;
        }

        DanhmucDto danhmucDto = new DanhmucDto();

        danhmucDto.setId( entity.getId() );
        danhmucDto.setModifiedUser( entity.getModifiedUser() );
        danhmucDto.setModifiedDate( entity.getModifiedDate() );
        danhmucDto.setCreatedUser( entity.getCreatedUser() );
        danhmucDto.setCreatedDate( entity.getCreatedDate() );
        danhmucDto.setDeleted( entity.isDeleted() );
        danhmucDto.setTenDanhMuc( entity.getTenDanhMuc() );

        return danhmucDto;
    }

    @Override
    public List<Danhmuc> toEntity(List<DanhmucDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Danhmuc> list = new ArrayList<Danhmuc>( dtoList.size() );
        for ( DanhmucDto danhmucDto : dtoList ) {
            list.add( toEntity( danhmucDto ) );
        }

        return list;
    }

    @Override
    public List<DanhmucDto> toDto(List<Danhmuc> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DanhmucDto> list = new ArrayList<DanhmucDto>( entityList.size() );
        for ( Danhmuc danhmuc : entityList ) {
            list.add( toDto( danhmuc ) );
        }

        return list;
    }

    @Override
    public Set<DanhmucDto> toDto(Set<Danhmuc> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<DanhmucDto> set = new LinkedHashSet<DanhmucDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Danhmuc danhmuc : entityList ) {
            set.add( toDto( danhmuc ) );
        }

        return set;
    }
}
