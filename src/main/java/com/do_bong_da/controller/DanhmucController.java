package com.do_bong_da.controller;

import com.do_bong_da.dto.DanhmucDto;
import com.do_bong_da.dto.SanphamDto;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.do_bong_da.service.DanhmucService;

import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/danhmuc")
@RestController
@Slf4j
@Api("danhmuc")
public class DanhmucController {
    private final DanhmucService danhmucService;

    public DanhmucController(DanhmucService danhmucService) {
        this.danhmucService = danhmucService;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated DanhmucDto danhmucDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            DanhmucDto danhmuc = danhmucService.save(danhmucDto);
            result.put("result", danhmuc);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Thêm danh mục mới không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            DanhmucDto danhmuc = danhmucService.findById(id);
            result.put("result", danhmuc);
            result.put("success", true);
        }
        catch (Exception e){
            result.put("result", "Có lỗi khi lấy thông tin danh mục");
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            danhmucService.deleteById(id);
            result.put("result", "Xóa danh mục thành công");
            result.put("success", true);
        }
        catch (Exception e){
            result.put("result", "Xóa danh mục không thành công");
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(DanhmucDto danhmucDto, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        try{
            Page<DanhmucDto> danhmucPage = danhmucService.findByCondition(danhmucDto, pageable);
            result.put("result", danhmucPage);
            result.put("success", true);
        }
        catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách danh mục");
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated DanhmucDto danhmucDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            DanhmucDto danhmuc = danhmucService.update(danhmucDto, id);
            result.put("result", danhmuc);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Cập nhật danh mục không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }
}