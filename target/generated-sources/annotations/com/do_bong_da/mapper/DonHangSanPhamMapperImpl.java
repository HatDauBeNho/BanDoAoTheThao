package com.do_bong_da.mapper;

import com.do_bong_da.common_api.DonHangSanPham;
import com.do_bong_da.dto.DonHangSanPhamDto;
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
public class DonHangSanPhamMapperImpl implements DonHangSanPhamMapper {

    @Override
    public DonHangSanPham toEntity(DonHangSanPhamDto dto) {
        if ( dto == null ) {
            return null;
        }

        DonHangSanPham donHangSanPham = new DonHangSanPham();

        donHangSanPham.setId( dto.getId() );
        donHangSanPham.setModifiedUser( dto.getModifiedUser() );
        donHangSanPham.setModifiedDate( dto.getModifiedDate() );
        donHangSanPham.setCreatedUser( dto.getCreatedUser() );
        donHangSanPham.setCreatedDate( dto.getCreatedDate() );
        donHangSanPham.setDeleted( dto.isDeleted() );
        donHangSanPham.setMaDonHang( dto.getMaDonHang() );
        donHangSanPham.setMaSanPham( dto.getMaSanPham() );
        donHangSanPham.setSoLuong( dto.getSoLuong() );
        donHangSanPham.setMauSac( dto.getMauSac() );
        donHangSanPham.setGiaBan( dto.getGiaBan() );
        donHangSanPham.setKichCo( dto.getKichCo() );

        return donHangSanPham;
    }

    @Override
    public DonHangSanPhamDto toDto(DonHangSanPham entity) {
        if ( entity == null ) {
            return null;
        }

        DonHangSanPhamDto donHangSanPhamDto = new DonHangSanPhamDto();

        donHangSanPhamDto.setId( entity.getId() );
        donHangSanPhamDto.setModifiedUser( entity.getModifiedUser() );
        donHangSanPhamDto.setModifiedDate( entity.getModifiedDate() );
        donHangSanPhamDto.setCreatedUser( entity.getCreatedUser() );
        donHangSanPhamDto.setCreatedDate( entity.getCreatedDate() );
        donHangSanPhamDto.setDeleted( entity.isDeleted() );
        donHangSanPhamDto.setMaDonHang( entity.getMaDonHang() );
        donHangSanPhamDto.setMaSanPham( entity.getMaSanPham() );
        donHangSanPhamDto.setSoLuong( entity.getSoLuong() );
        donHangSanPhamDto.setMauSac( entity.getMauSac() );
        donHangSanPhamDto.setGiaBan( entity.getGiaBan() );
        donHangSanPhamDto.setKichCo( entity.getKichCo() );

        return donHangSanPhamDto;
    }

    @Override
    public List<DonHangSanPham> toEntity(List<DonHangSanPhamDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DonHangSanPham> list = new ArrayList<DonHangSanPham>( dtoList.size() );
        for ( DonHangSanPhamDto donHangSanPhamDto : dtoList ) {
            list.add( toEntity( donHangSanPhamDto ) );
        }

        return list;
    }

    @Override
    public List<DonHangSanPhamDto> toDto(List<DonHangSanPham> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DonHangSanPhamDto> list = new ArrayList<DonHangSanPhamDto>( entityList.size() );
        for ( DonHangSanPham donHangSanPham : entityList ) {
            list.add( toDto( donHangSanPham ) );
        }

        return list;
    }

    @Override
    public Set<DonHangSanPhamDto> toDto(Set<DonHangSanPham> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<DonHangSanPhamDto> set = new LinkedHashSet<DonHangSanPhamDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( DonHangSanPham donHangSanPham : entityList ) {
            set.add( toDto( donHangSanPham ) );
        }

        return set;
    }
}
