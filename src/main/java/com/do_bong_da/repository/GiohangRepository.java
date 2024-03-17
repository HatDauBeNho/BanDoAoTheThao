package com.do_bong_da.repository;

import com.do_bong_da.common_api.Giohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiohangRepository extends JpaRepository<Giohang, Long>, JpaSpecificationExecutor<Giohang> {
    List<Giohang> findByMaNguoiDung(Long userId);
}