package com.do_bong_da.controller;

import com.do_bong_da.common_api.Nguoidung;
import com.do_bong_da.dto.NguoidungDto;
import com.do_bong_da.repository.NguoidungRepository;
import com.do_bong_da.service.NguoidungService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/nguoidung")
@RestController
@Slf4j
@Api("nguoidung")
public class NguoidungController {
    private final NguoidungService nguoidungService;
    private final NguoidungRepository nguoidungRepository;

    public NguoidungController(NguoidungService nguoidungService, NguoidungRepository nguoidungRepository) {
        this.nguoidungService = nguoidungService;
        this.nguoidungRepository = nguoidungRepository;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated NguoidungDto nguoidungDto) {
        Map<String, Object> result = new HashMap<>();
        try{
            Nguoidung nguoidung1 = nguoidungRepository.findByTenDangNhap(nguoidungDto.getTenDangNhap());
            if(nguoidung1 != null){
                result.put("result", "Tên đăng nhập đã được sử dụng");
                result.put("success", false);
            }
            else{
                nguoidungDto.setQuyen("USER");
                NguoidungDto nguoidung = nguoidungService.save(nguoidungDto);
                result.put("result", nguoidung);
                result.put("success", true);
            }

        } catch (Exception e){
            result.put("result", "Thêm người dùng không thành công");
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            NguoidungDto nguoidung = nguoidungService.findById(id);
            result.put("result", nguoidung);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy thông tin người dùng");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            nguoidungService.deleteById(id);
            result.put("result", "Xóa người dùng thành công");
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Xóa người dùng không thành công");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(NguoidungDto nguoidungDto, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<>();
        try{
            Page<NguoidungDto> nguoidungPage = nguoidungService.findByCondition(nguoidungDto, pageable);
            result.put("result", nguoidungPage);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Có lỗi khi lấy danh sách người dùng");
            result.put("success", false);
        }

        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Validated NguoidungDto nguoidungDto, @PathVariable("id") Long id) {
        Map<String, Object> result = new HashMap<>();
        try{
            nguoidungDto.setQuyen("USER");
            NguoidungDto nguoidung = nguoidungService.update(nguoidungDto, id);
            result.put("result", nguoidung);
            result.put("success", true);
        } catch (Exception e){
            result.put("result", "Cập nhật người dùng không thành công");
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login/{tenDangNhap}/{matKhau}")
    public ResponseEntity<Map<String, Object>> login(@PathVariable("tenDangNhap") String tenDangNhap, @PathVariable("matKhau") String matKhau) {
        Map<String, Object> result = new HashMap<>();
        try{
            Nguoidung nguoidung = nguoidungRepository.findByTenDangNhapAndMatKhau(tenDangNhap, matKhau);
            if(nguoidung == null){
                result.put("result", "Sai tên đăng nhập hoặc mật khẩu");
                result.put("success", false);
            }
            else{
                result.put("result", nguoidung);
                result.put("success", true);
            }
        } catch (Exception e){
            result.put("result", "Đăng nhập không thành công");
            result.put("success", false);
        }
        return ResponseEntity.ok(result);
    }
}