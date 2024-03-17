package com.do_bong_da.service;

import com.do_bong_da.common_api.DonHangSanPham;
import com.do_bong_da.dto.DonHangSanPhamDto;
import com.do_bong_da.handler.Utils;
import com.do_bong_da.mapper.DonHangSanPhamMapper;
import com.do_bong_da.repository.DonHangSanPhamRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class DonHangSanPhamService {
    private final DonHangSanPhamRepository repository;
    private final DonHangSanPhamMapper donHangSanPhamMapper;

    public DonHangSanPhamService(DonHangSanPhamRepository repository, DonHangSanPhamMapper donHangSanPhamMapper) {
        this.repository = repository;
        this.donHangSanPhamMapper = donHangSanPhamMapper;
    }

    public DonHangSanPhamDto save(DonHangSanPhamDto donHangSanPhamDto) {
        DonHangSanPham entity = donHangSanPhamMapper.toEntity(donHangSanPhamDto);
        return donHangSanPhamMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DonHangSanPhamDto findById(Long id) {
        return donHangSanPhamMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<DonHangSanPhamDto> findByCondition(DonHangSanPhamDto donHangSanPhamDto, Pageable pageable) {
        Page<DonHangSanPham> entityPage = repository.findAll(pageable);
        List<DonHangSanPham> entities = entityPage.getContent();
        return new PageImpl<>(donHangSanPhamMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public DonHangSanPhamDto update(DonHangSanPhamDto donHangSanPhamDto, Long id) {
        DonHangSanPhamDto data = findById(id);
        DonHangSanPham entity = donHangSanPhamMapper.toEntity(donHangSanPhamDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(donHangSanPhamMapper.toDto(entity));
    }
}