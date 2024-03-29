package com.do_bong_da.upload_files;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

@Service
public interface FilesStorageService {
    public void init();
    public Map<Integer, String> save(MultipartFile file);
    public Map<Integer, String> saveCCCD(MultipartFile file);
    public String saveFile(MultipartFile file);
    public Resource load(String filename);
//    public void deleteAll();
    public Stream<Path> loadAll();
}