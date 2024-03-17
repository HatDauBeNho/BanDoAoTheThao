package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Theloai;
import com.do_bong_da.dto.TheloaiDto;
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
public class TheloaiMapperImpl implements TheloaiMapper {

    @Override
    public Theloai toEntity(TheloaiDto dto) {
        if ( dto == null ) {
            return null;
        }

        Theloai theloai = new Theloai();

        theloai.setId( dto.getId() );
        theloai.setModifiedUser( dto.getModifiedUser() );
        theloai.setModifiedDate( dto.getModifiedDate() );
        theloai.setCreatedUser( dto.getCreatedUser() );
        theloai.setCreatedDate( dto.getCreatedDate() );
        theloai.setDeleted( dto.isDeleted() );
        theloai.setMaDanhMuc( dto.getMaDanhMuc() );
        theloai.setTenTheLoai( dto.getTenTheLoai() );

        return theloai;
    }

    @Override
    public TheloaiDto toDto(Theloai entity) {
        if ( entity == null ) {
            return null;
        }

        TheloaiDto theloaiDto = new TheloaiDto();

        theloaiDto.setId( entity.getId() );
        theloaiDto.setModifiedUser( entity.getModifiedUser() );
        theloaiDto.setModifiedDate( entity.getModifiedDate() );
        theloaiDto.setCreatedUser( entity.getCreatedUser() );
        theloaiDto.setCreatedDate( entity.getCreatedDate() );
        theloaiDto.setDeleted( entity.isDeleted() );
        theloaiDto.setMaDanhMuc( entity.getMaDanhMuc() );
        theloaiDto.setTenTheLoai( entity.getTenTheLoai() );

        return theloaiDto;
    }

    @Override
    public List<Theloai> toEntity(List<TheloaiDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Theloai> list = new ArrayList<Theloai>( dtoList.size() );
        for ( TheloaiDto theloaiDto : dtoList ) {
            list.add( toEntity( theloaiDto ) );
        }

        return list;
    }

    @Override
    public List<TheloaiDto> toDto(List<Theloai> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TheloaiDto> list = new ArrayList<TheloaiDto>( entityList.size() );
        for ( Theloai theloai : entityList ) {
            list.add( toDto( theloai ) );
        }

        return list;
    }

    @Override
    public Set<TheloaiDto> toDto(Set<Theloai> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<TheloaiDto> set = new LinkedHashSet<TheloaiDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Theloai theloai : entityList ) {
            set.add( toDto( theloai ) );
        }

        return set;
    }
}
