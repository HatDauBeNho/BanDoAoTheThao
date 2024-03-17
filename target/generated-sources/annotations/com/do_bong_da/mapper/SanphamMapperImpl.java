package com.do_bong_da.mapper;

import com.do_bong_da.common_api.Sanpham;
import com.do_bong_da.dto.SanphamDto;
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
public class SanphamMapperImpl implements SanphamMapper {

    @Override
    public Sanpham toEntity(SanphamDto dto) {
        if ( dto == null ) {
            return null;
        }

        Sanpham sanpham = new Sanpham();

        sanpham.setId( dto.getId() );
        sanpham.setModifiedUser( dto.getModifiedUser() );
        sanpham.setModifiedDate( dto.getModifiedDate() );
        sanpham.setCreatedUser( dto.getCreatedUser() );
        sanpham.setCreatedDate( dto.getCreatedDate() );
        sanpham.setDeleted( dto.isDeleted() );
        sanpham.setMaTheLoai( dto.getMaTheLoai() );
        sanpham.setTenSanPham( dto.getTenSanPham() );
        sanpham.setGiaBan( dto.getGiaBan() );
        sanpham.setNhaCungCap( dto.getNhaCungCap() );
        sanpham.setXuatXu( dto.getXuatXu() );
        sanpham.setKichCo( dto.getKichCo() );
        sanpham.setMauSac( dto.getMauSac() );
        sanpham.setTrongLuong( dto.getTrongLuong() );
        sanpham.setTenAnh( dto.getTenAnh() );

        return sanpham;
    }

    @Override
    public SanphamDto toDto(Sanpham entity) {
        if ( entity == null ) {
            return null;
        }

        SanphamDto sanphamDto = new SanphamDto();

        sanphamDto.setId( entity.getId() );
        sanphamDto.setModifiedUser( entity.getModifiedUser() );
        sanphamDto.setModifiedDate( entity.getModifiedDate() );
        sanphamDto.setCreatedUser( entity.getCreatedUser() );
        sanphamDto.setCreatedDate( entity.getCreatedDate() );
        sanphamDto.setDeleted( entity.isDeleted() );
        sanphamDto.setMaTheLoai( entity.getMaTheLoai() );
        sanphamDto.setTenSanPham( entity.getTenSanPham() );
        sanphamDto.setGiaBan( entity.getGiaBan() );
        sanphamDto.setNhaCungCap( entity.getNhaCungCap() );
        sanphamDto.setXuatXu( entity.getXuatXu() );
        sanphamDto.setKichCo( entity.getKichCo() );
        sanphamDto.setMauSac( entity.getMauSac() );
        sanphamDto.setTrongLuong( entity.getTrongLuong() );
        sanphamDto.setTenAnh( entity.getTenAnh() );

        return sanphamDto;
    }

    @Override
    public List<Sanpham> toEntity(List<SanphamDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Sanpham> list = new ArrayList<Sanpham>( dtoList.size() );
        for ( SanphamDto sanphamDto : dtoList ) {
            list.add( toEntity( sanphamDto ) );
        }

        return list;
    }

    @Override
    public List<SanphamDto> toDto(List<Sanpham> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SanphamDto> list = new ArrayList<SanphamDto>( entityList.size() );
        for ( Sanpham sanpham : entityList ) {
            list.add( toDto( sanpham ) );
        }

        return list;
    }

    @Override
    public Set<SanphamDto> toDto(Set<Sanpham> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<SanphamDto> set = new LinkedHashSet<SanphamDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Sanpham sanpham : entityList ) {
            set.add( toDto( sanpham ) );
        }

        return set;
    }
}
