package com.do_bong_da.controller;

import com.do_bong_da.common_api.Hinhanh;
import com.do_bong_da.dto.HinhanhDto;
import com.do_bong_da.dto.SanphamDto;
import com.do_bong_da.mapper.HinhanhMapper;
import com.do_bong_da.service.HinhanhService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/hinhanh")
@RestController
@Slf4j
@Api("hinhanh")
public class HinhanhController {
    private final HinhanhService hinhanhService;

    public HinhanhController(HinhanhService hinhanhService) {
        this.hinhanhService = hinhanhService;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated HinhanhDto hinhanhDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            HinhanhDto hinhanh = hinhanhService.save(hinhanhDto);
            result.put("result", hinhanh);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Thêm hình ảnh mới không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            HinhanhDto hinhanh = hinhanhService.findById(id);
            result.put("result", hinhanh);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy thông tin hình ảnh");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            hinhanhService.deleteById(id);
            result.put("result", "Xóa hình ảnh thành công");
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Xóa hình ảnh không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(HinhanhDto hinhanhDto, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        try{
            Page<HinhanhDto> hinhanhPage = hinhanhService.findByCondition(hinhanhDto, pageable);
            result.put("result", hinhanhPage);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách hình ảnh");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated HinhanhDto hinhanhDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            HinhanhDto hinhanh = hinhanhService.update(hinhanhDto, id);
            result.put("result", hinhanh);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Cập nhật hình ảnh không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }
}