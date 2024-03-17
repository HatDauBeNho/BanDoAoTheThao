package com.do_bong_da.controller;

import com.do_bong_da.common_api.Theloai;
import com.do_bong_da.dto.TheloaiDto;
import com.do_bong_da.repository.TheloaiRepository;
import com.do_bong_da.service.TheloaiService;
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

@RequestMapping("/api/theloai")
@RestController
@Slf4j
@Api("theloai")
public class TheloaiController {
    private final TheloaiService theloaiService;
    private final TheloaiRepository repository;

    public TheloaiController(TheloaiService theloaiService, TheloaiRepository repository) {
        this.theloaiService = theloaiService;
        this.repository = repository;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated TheloaiDto theloaiDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            TheloaiDto theloai = theloaiService.save(theloaiDto);
            result.put("result", theloai);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Thêm thể loại mới không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            TheloaiDto theloai = theloaiService.findById(id);
            result.put("result", theloai);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy thông tin thể loại");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Lấy danh sách thể loại theo danh mục")
    @GetMapping("/get-by-danhmuc/{maDanhMuc}")
    public ResponseEntity<Map<String, Object>> findByMaDanhMuc(@PathVariable("maDanhMuc") Long maDanhMuc) {
        Map<String, Object> result = new HashMap<>();
        try{
            List<Theloai> theloaiList = repository.findByMaDanhMuc(maDanhMuc);
            result.put("result", theloaiList);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách thể loại theo danh mục");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            theloaiService.deleteById(id);
            result.put("result", "Xóa thể loại thành công");
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Xóa thể loại không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(TheloaiDto theloaiDto, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        try{
            Page<TheloaiDto> theloaiPage = theloaiService.findByCondition(theloaiDto, pageable);
            result.put("result", theloaiPage);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách thể loại");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated TheloaiDto theloaiDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            TheloaiDto theloai = theloaiService.update(theloaiDto, id);
            result.put("result", theloai);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Cập nhật thể loại không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }
}