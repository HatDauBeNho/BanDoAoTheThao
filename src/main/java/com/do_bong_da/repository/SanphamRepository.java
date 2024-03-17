package com.do_bong_da.repository;

import com.do_bong_da.common_api.Sanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanphamRepository extends JpaRepository<Sanpham, Long>, JpaSpecificationExecutor<Sanpham> {
    List<Sanpham> findByMaTheLoai(Long maTheLoai);
}