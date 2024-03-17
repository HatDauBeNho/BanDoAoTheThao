package com.do_bong_da.repository;

import com.do_bong_da.common_api.Donhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DonhangRepository extends JpaRepository<Donhang, Long>, JpaSpecificationExecutor<Donhang> {
}