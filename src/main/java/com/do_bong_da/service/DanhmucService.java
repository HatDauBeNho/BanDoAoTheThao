package com.do_bong_da.service;

import com.do_bong_da.common_api.Danhmuc;
import com.do_bong_da.dto.DanhmucDto;
import com.do_bong_da.handler.Utils;
import lombok.extern.slf4j.Slf4j;
import com.do_bong_da.mapper.DanhmucMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.do_bong_da.repository.DanhmucRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class DanhmucService {
    private final DanhmucRepository repository;
    private final DanhmucMapper danhmucMapper;

    public DanhmucService(DanhmucRepository repository, DanhmucMapper danhmucMapper) {
        this.repository = repository;
        this.danhmucMapper = danhmucMapper;
    }

    public DanhmucDto save(DanhmucDto danhmucDto) {
        Danhmuc entity = danhmucMapper.toEntity(danhmucDto);
        return danhmucMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DanhmucDto findById(Long id) {
        return danhmucMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<DanhmucDto> findByCondition(DanhmucDto danhmucDto, Pageable pageable) {
        Page<Danhmuc> entityPage = repository.findAll(pageable);
        List<Danhmuc> entities = entityPage.getContent();
        return new PageImpl<>(danhmucMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public DanhmucDto update(DanhmucDto danhmucDto, Long id) {
        DanhmucDto data = findById(id);
        Danhmuc entity = danhmucMapper.toEntity(danhmucDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(danhmucMapper.toDto(entity));
    }
}