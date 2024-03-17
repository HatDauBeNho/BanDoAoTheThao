package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Nguoidung;
import com.do_bong_da.dto.NguoidungDto;
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
public class NguoidungMapperImpl implements NguoidungMapper {

    @Override
    public Nguoidung toEntity(NguoidungDto dto) {
        if ( dto == null ) {
            return null;
        }

        Nguoidung nguoidung = new Nguoidung();

        nguoidung.setId( dto.getId() );
        nguoidung.setModifiedUser( dto.getModifiedUser() );
        nguoidung.setModifiedDate( dto.getModifiedDate() );
        nguoidung.setCreatedUser( dto.getCreatedUser() );
        nguoidung.setCreatedDate( dto.getCreatedDate() );
        nguoidung.setDeleted( dto.isDeleted() );
        nguoidung.setTenDangNhap( dto.getTenDangNhap() );
        nguoidung.setMatKhau( dto.getMatKhau() );
        nguoidung.setQuyen( dto.getQuyen() );
        nguoidung.setHoTen( dto.getHoTen() );
        nguoidung.setSoDienThoai( dto.getSoDienThoai() );
        nguoidung.setGioiTinh( dto.getGioiTinh() );
        nguoidung.setNgaySinh( dto.getNgaySinh() );
        nguoidung.setDiaChi( dto.getDiaChi() );

        return nguoidung;
    }

    @Override
    public NguoidungDto toDto(Nguoidung entity) {
        if ( entity == null ) {
            return null;
        }

        NguoidungDto nguoidungDto = new NguoidungDto();

        nguoidungDto.setId( entity.getId() );
        nguoidungDto.setModifiedUser( entity.getModifiedUser() );
        nguoidungDto.setModifiedDate( entity.getModifiedDate() );
        nguoidungDto.setCreatedUser( entity.getCreatedUser() );
        nguoidungDto.setCreatedDate( entity.getCreatedDate() );
        nguoidungDto.setDeleted( entity.isDeleted() );
        nguoidungDto.setTenDangNhap( entity.getTenDangNhap() );
        nguoidungDto.setMatKhau( entity.getMatKhau() );
        nguoidungDto.setQuyen( entity.getQuyen() );
        nguoidungDto.setHoTen( entity.getHoTen() );
        nguoidungDto.setSoDienThoai( entity.getSoDienThoai() );
        nguoidungDto.setGioiTinh( entity.getGioiTinh() );
        nguoidungDto.setNgaySinh( entity.getNgaySinh() );
        nguoidungDto.setDiaChi( entity.getDiaChi() );

        return nguoidungDto;
    }

    @Override
    public List<Nguoidung> toEntity(List<NguoidungDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Nguoidung> list = new ArrayList<Nguoidung>( dtoList.size() );
        for ( NguoidungDto nguoidungDto : dtoList ) {
            list.add( toEntity( nguoidungDto ) );
        }

        return list;
    }

    @Override
    public List<NguoidungDto> toDto(List<Nguoidung> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<NguoidungDto> list = new ArrayList<NguoidungDto>( entityList.size() );
        for ( Nguoidung nguoidung : entityList ) {
            list.add( toDto( nguoidung ) );
        }

        return list;
    }

    @Override
    public Set<NguoidungDto> toDto(Set<Nguoidung> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<NguoidungDto> set = new LinkedHashSet<NguoidungDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Nguoidung nguoidung : entityList ) {
            set.add( toDto( nguoidung ) );
        }

        return set;
    }
}
