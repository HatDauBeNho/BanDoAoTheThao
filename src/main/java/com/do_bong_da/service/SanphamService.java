package com.do_bong_da.service;

import com.do_bong_da.common_api.Sanpham;
import com.do_bong_da.dto.SanphamDto;
import com.do_bong_da.handler.Utils;
import com.do_bong_da.mapper.SanphamMapper;
import com.do_bong_da.repository.SanphamRepository;
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
public class SanphamService {
    private final SanphamRepository repository;
    private final SanphamMapper sanphamMapper;

    public SanphamService(SanphamRepository repository, SanphamMapper sanphamMapper) {
        this.repository = repository;
        this.sanphamMapper = sanphamMapper;
    }

    public SanphamDto save(SanphamDto sanphamDto) {
        Sanpham entity = sanphamMapper.toEntity(sanphamDto);
        return sanphamMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public SanphamDto findById(Long id) {
        return sanphamMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<SanphamDto> findByCondition(SanphamDto sanphamDto, Pageable pageable) {
        Page<Sanpham> entityPage = repository.findAll(pageable);
        List<Sanpham> entities = entityPage.getContent();
        return new PageImpl<>(sanphamMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public SanphamDto update(SanphamDto sanphamDto, Long id) {
        SanphamDto data = findById(id);
        Sanpham entity = sanphamMapper.toEntity(sanphamDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(sanphamMapper.toDto(entity));
    }
}