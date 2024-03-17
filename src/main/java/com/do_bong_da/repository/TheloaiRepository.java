package com.do_bong_da.repository;

import com.do_bong_da.common_api.Theloai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheloaiRepository extends JpaRepository<Theloai, Long>, JpaSpecificationExecutor<Theloai> {
    List<Theloai> findByMaDanhMuc(Long maDanhMuc);
}