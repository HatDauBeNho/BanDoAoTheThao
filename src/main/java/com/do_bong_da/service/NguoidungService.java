package com.do_bong_da.service;

import com.do_bong_da.common_api.Nguoidung;
import com.do_bong_da.dto.NguoidungDto;
import com.do_bong_da.handler.Utils;
import com.do_bong_da.mapper.NguoidungMapper;
import com.do_bong_da.repository.NguoidungRepository;
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
public class NguoidungService {
    private final NguoidungRepository repository;
    private final NguoidungMapper nguoidungMapper;

    public NguoidungService(NguoidungRepository repository, NguoidungMapper nguoidungMapper) {
        this.repository = repository;
        this.nguoidungMapper = nguoidungMapper;
    }

    public NguoidungDto save(NguoidungDto nguoidungDto) {
        Nguoidung entity = nguoidungMapper.toEntity(nguoidungDto);
        return nguoidungMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public NguoidungDto findById(Long id) {
        return nguoidungMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<NguoidungDto> findByCondition(NguoidungDto nguoidungDto, Pageable pageable) {
        Page<Nguoidung> entityPage = repository.findAll(pageable);
        List<Nguoidung> entities = entityPage.getContent();
        return new PageImpl<>(nguoidungMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public NguoidungDto update(NguoidungDto nguoidungDto, Long id) {
        NguoidungDto data = findById(id);
        Nguoidung entity = nguoidungMapper.toEntity(nguoidungDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(nguoidungMapper.toDto(entity));
    }
}