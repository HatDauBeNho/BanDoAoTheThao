package com.do_bong_da.service;

import com.do_bong_da.common_api.Hinhanh;
import com.do_bong_da.dto.HinhanhDto;
import com.do_bong_da.handler.Utils;
import com.do_bong_da.mapper.HinhanhMapper;
import com.do_bong_da.repository.HinhanhRepository;
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
public class HinhanhService {
    private final HinhanhRepository repository;
    private final HinhanhMapper hinhanhMapper;

    public HinhanhService(HinhanhRepository repository, HinhanhMapper hinhanhMapper) {
        this.repository = repository;
        this.hinhanhMapper = hinhanhMapper;
    }

    public HinhanhDto save(HinhanhDto hinhanhDto) {
        Hinhanh entity = hinhanhMapper.toEntity(hinhanhDto);
        return hinhanhMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public HinhanhDto findById(Long id) {
        return hinhanhMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<HinhanhDto> findByCondition(HinhanhDto hinhanhDto, Pageable pageable) {
        Page<Hinhanh> entityPage = repository.findAll(pageable);
        List<Hinhanh> entities = entityPage.getContent();
        return new PageImpl<>(hinhanhMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public HinhanhDto update(HinhanhDto hinhanhDto, Long id) {
        HinhanhDto data = findById(id);
        Hinhanh entity = hinhanhMapper.toEntity(hinhanhDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(hinhanhMapper.toDto(entity));
    }
}