package com.do_bong_da.controller;

import com.do_bong_da.common_api.DonHangSanPham;
import com.do_bong_da.dto.DonHangSanPhamDto;
import com.do_bong_da.repository.DonHangSanPhamRepository;
import com.do_bong_da.service.DonHangSanPhamService;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/don-hang-san-pham")
@RestController
@Slf4j
@Api("don-hang-san-pham")
public class DonHangSanPhamController {
    private final DonHangSanPhamService donHangSanPhamService;
    private final DonHangSanPhamRepository repository;

    public DonHangSanPhamController(DonHangSanPhamService donHangSanPhamService, DonHangSanPhamRepository repository) {
        this.donHangSanPhamService = donHangSanPhamService;
        this.repository = repository;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated DonHangSanPhamDto donHangSanPhamDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            DonHangSanPhamDto donHangSanPham = donHangSanPhamService.save(donHangSanPhamDto);
            result.put("result", donHangSanPham);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Thêm đơn hàng mới không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{maDonHang}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("maDonHang") Long maDonHang) {
        Map<String, Object> result = new HashMap<>();
        try{
            List<DonHangSanPham> donHangSanPhams = repository.findByMaDonHang(maDonHang);
            result.put("result", donHangSanPhams);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy thông tin đơn hàng");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional.ofNullable(donHangSanPhamService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new FileSystemNotFoundException();
        });
        donHangSanPhamService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/page")
    public ResponseEntity<Page<DonHangSanPhamDto>> pageQuery(DonHangSanPhamDto donHangSanPhamDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<DonHangSanPhamDto> donHangSanPhamPage = donHangSanPhamService.findByCondition(donHangSanPhamDto, pageable);
        return ResponseEntity.ok(donHangSanPhamPage);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated DonHangSanPhamDto donHangSanPhamDto, @PathVariable("id") Long id) {
        donHangSanPhamService.update(donHangSanPhamDto, id);
        return ResponseEntity.ok().build();
    }
}