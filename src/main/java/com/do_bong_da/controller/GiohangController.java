package com.do_bong_da.controller;

import com.do_bong_da.common_api.Giohang;
import com.do_bong_da.dto.GiohangDto;
import com.do_bong_da.repository.GiohangRepository;
import com.do_bong_da.service.GiohangService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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

@RequestMapping("/api/giohang")
@RestController
@Slf4j
@Api("giohang")
public class GiohangController {
    private final GiohangService giohangService;
    private final GiohangRepository repository;

    public GiohangController(GiohangService giohangService, GiohangRepository repository) {
        this.giohangService = giohangService;
        this.repository = repository;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated GiohangDto giohangDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            GiohangDto giohang = giohangService.save(giohangDto);
            result.put("result", giohang);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Thêm giỏ hàng mới không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            GiohangDto giohang = giohangService.findById(id);
            result.put("result", giohang);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy dữ liệu");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Lấy danh sách giỏ hàng của người dùng")
    @GetMapping("/get-by-user/{userId}")
    public ResponseEntity<Map<String, Object>> findByUserId(@PathVariable("userId") Long userId) {
        Map<String, Object> result = new HashMap<>();
        try{
            List<Giohang> giohangList = repository.findByMaNguoiDung(userId);
            result.put("result", giohangList);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy dữ liệu");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            giohangService.deleteById(id);
            result.put("result", "Xóa sản phẩm thành công");
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Xóa sản phẩm khỏi không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(GiohangDto giohangDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        try{
            Page<GiohangDto> giohangPage = giohangService.findByCondition(giohangDto, pageable);
            result.put("result", giohangPage);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy dữ liệu");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated GiohangDto giohangDto, @PathVariable("id") Long id) {
        giohangService.update(giohangDto, id);
        return ResponseEntity.ok().build();
    }
}