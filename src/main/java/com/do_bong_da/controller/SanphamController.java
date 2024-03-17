package com.do_bong_da.controller;

import com.do_bong_da.common_api.Sanpham;
import com.do_bong_da.common_api.Theloai;
import com.do_bong_da.dto.SanphamDto;
import com.do_bong_da.repository.SanphamRepository;
import com.do_bong_da.service.SanphamService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/sanpham")
@RestController
@Slf4j
@Api("sanpham")
public class SanphamController {
    private final SanphamService sanphamService;
    private final SanphamRepository repository;

    public SanphamController(SanphamService sanphamService, SanphamRepository repository) {
        this.sanphamService = sanphamService;
        this.repository = repository;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated SanphamDto sanphamDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            SanphamDto sanpham = sanphamService.save(sanphamDto);
            result.put("result", sanpham);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Thêm sản phẩm mới không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            SanphamDto sanpham = sanphamService.findById(id);
            result.put("result", sanpham);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy thông tin sản phẩm");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Lấy danh sách sản phẩm theo thể loại")
    @GetMapping("/get-by-theloai/{maTheLoai}")
    public ResponseEntity<Map<String, Object>> findByMaTheLoai(@PathVariable("maTheLoai") Long maTheLoai) {
        Map<String, Object> result = new HashMap<>();
        try{
            List<Sanpham> sanphamList = repository.findByMaTheLoai(maTheLoai);
            result.put("result", sanphamList);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách sản phẩm theo thể loại");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            sanphamService.deleteById(id);
            result.put("result", "Xóa sản phẩm thành công");
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Xóa sản phẩm không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(SanphamDto sanphamDto, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        try{
            Page<SanphamDto> sanphamPage = sanphamService.findByCondition(sanphamDto, pageable);
            result.put("result", sanphamPage);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách sản phẩm");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated SanphamDto sanphamDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            SanphamDto sanpham = sanphamService.update(sanphamDto, id);
            result.put("result", sanpham);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Cập nhật sản phẩm không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }
}