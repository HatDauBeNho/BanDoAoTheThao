package com.do_bong_da.service;

import com.do_bong_da.common_api.Theloai;
import com.do_bong_da.dto.TheloaiDto;
import com.do_bong_da.handler.Utils;
import com.do_bong_da.mapper.TheloaiMapper;
import com.do_bong_da.repository.TheloaiRepository;
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
public class TheloaiService {
    private final TheloaiRepository repository;
    private final TheloaiMapper theloaiMapper;

    public TheloaiService(TheloaiRepository repository, TheloaiMapper theloaiMapper) {
        this.repository = repository;
        this.theloaiMapper = theloaiMapper;
    }

    public TheloaiDto save(TheloaiDto theloaiDto) {
        Theloai entity = theloaiMapper.toEntity(theloaiDto);
        return theloaiMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public TheloaiDto findById(Long id) {
        return theloaiMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<TheloaiDto> findByCondition(TheloaiDto theloaiDto, Pageable pageable) {
        Page<Theloai> entityPage = repository.findAll(pageable);
        List<Theloai> entities = entityPage.getContent();
        return new PageImpl<>(theloaiMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public TheloaiDto update(TheloaiDto theloaiDto, Long id) {
        TheloaiDto data = findById(id);
        Theloai entity = theloaiMapper.toEntity(theloaiDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(theloaiMapper.toDto(entity));
    }
}