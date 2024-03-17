package com.do_bong_da.service;

import com.do_bong_da.common_api.Giohang;
import com.do_bong_da.dto.GiohangDto;
import com.do_bong_da.handler.Utils;
import com.do_bong_da.mapper.GiohangMapper;
import com.do_bong_da.repository.GiohangRepository;
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
public class GiohangService {
    private final GiohangRepository repository;
    private final GiohangMapper giohangMapper;

    public GiohangService(GiohangRepository repository, GiohangMapper giohangMapper) {
        this.repository = repository;
        this.giohangMapper = giohangMapper;
    }

    public GiohangDto save(GiohangDto giohangDto) {
        Giohang entity = giohangMapper.toEntity(giohangDto);
        return giohangMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public GiohangDto findById(Long id) {
        return giohangMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<GiohangDto> findByCondition(GiohangDto giohangDto, Pageable pageable) {
        Page<Giohang> entityPage = repository.findAll(pageable);
        List<Giohang> entities = entityPage.getContent();
        return new PageImpl<>(giohangMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public GiohangDto update(GiohangDto giohangDto, Long id) {
        GiohangDto data = findById(id);
        Giohang entity = giohangMapper.toEntity(giohangDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(giohangMapper.toDto(entity));
    }
}