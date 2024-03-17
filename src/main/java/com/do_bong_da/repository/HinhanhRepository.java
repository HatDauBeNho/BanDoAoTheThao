package com.do_bong_da.repository;

import com.do_bong_da.common_api.Hinhanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhanhRepository extends JpaRepository<Hinhanh, Long>, JpaSpecificationExecutor<Hinhanh> {
}