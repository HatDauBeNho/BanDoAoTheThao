package com.do_bong_da.service;

import com.do_bong_da.common_api.Donhang;
import com.do_bong_da.dto.DonhangDto;
import com.do_bong_da.handler.Utils;
import com.do_bong_da.mapper.DonhangMapper;
import com.do_bong_da.repository.DonhangRepository;
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
public class DonhangService {
    private final DonhangRepository repository;
    private final DonhangMapper donhangMapper;

    public DonhangService(DonhangRepository repository, DonhangMapper donhangMapper) {
        this.repository = repository;
        this.donhangMapper = donhangMapper;
    }

    public DonhangDto save(DonhangDto donhangDto) {
        Donhang entity = donhangMapper.toEntity(donhangDto);
        return donhangMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DonhangDto findById(Long id) {
        return donhangMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<DonhangDto> findByCondition(DonhangDto donhangDto, Pageable pageable) {
        Page<Donhang> entityPage = repository.findAll(pageable);
        List<Donhang> entities = entityPage.getContent();
        return new PageImpl<>(donhangMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public DonhangDto update(DonhangDto donhangDto, Long id) {
        DonhangDto data = findById(id);
        Donhang entity = donhangMapper.toEntity(donhangDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(donhangMapper.toDto(entity));
    }
}