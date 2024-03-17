package com.do_bong_da.repository;

import com.do_bong_da.common_api.Nguoidung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoidungRepository extends JpaRepository<Nguoidung, Long>, JpaSpecificationExecutor<Nguoidung> {
    Nguoidung findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
    Nguoidung findByTenDangNhap(String tenDangNhap);
}