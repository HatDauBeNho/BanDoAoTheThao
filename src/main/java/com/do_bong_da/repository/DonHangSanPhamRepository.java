package com.do_bong_da.repository;

import com.do_bong_da.common_api.DonHangSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangSanPhamRepository extends JpaRepository<DonHangSanPham, Long>, JpaSpecificationExecutor<DonHangSanPham> {
    List<DonHangSanPham> findByMaDonHang(Long maDonHang);
}