package com.do_bong_da.controller;

import com.do_bong_da.dto.DonhangDto;
import com.do_bong_da.dto.SanphamDto;
import com.do_bong_da.service.DonhangService;
import io.swagger.annotations.Api;
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
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/donhang")
@RestController
@Slf4j
@Api("donhang")
public class DonhangController {
    private final DonhangService donhangService;

    public DonhangController(DonhangService donhangService) {
        this.donhangService = donhangService;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated DonhangDto donhangDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            DonhangDto donhang = donhangService.save(donhangDto);
            result.put("result", donhang);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Thêm đơn hàng mới không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            DonhangDto donhang = donhangService.findById(id);
            result.put("result", donhang);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy thông tin đơn hàng");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            donhangService.deleteById(id);
            result.put("result", "Xóa đơn hàng thành công");
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Xóa đơn hàng không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(DonhangDto donhangDto, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        try{
            Page<DonhangDto> donhangPage = donhangService.findByCondition(donhangDto, pageable);
            result.put("result", donhangPage);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách đơn hàng");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated DonhangDto donhangDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            DonhangDto donhang = donhangService.update(donhangDto, id);
            result.put("result", donhang);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Cập nhật đơn hàng không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }
}