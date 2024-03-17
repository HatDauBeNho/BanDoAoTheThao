package com.do_bong_da.upload_files;

import com.do_bong_da.handler.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Service
@Slf4j
public class FilesStorageServiceImpl implements FilesStorageService {
//    private final Path root = Paths.get("uploads");
    @Value("${aam.upload.dir}")
    private String uploadPath;

    @Value("${aam.upload.qrcode.dir}")
    private String uploadPathQR;

    @Value("${aam.upload.cccd.dir}")
    private String uploadPathCCCD;

    @Value("${aam.upload.image.dir}")
    private String uploadPathImg;

//    Path root = Paths.get(uploadPath);

    @Override
    public void init() {
        Utils.mkdirs(uploadPath);
        Utils.mkdirs(uploadPathQR);
        Utils.mkdirs(uploadPathCCCD);
//            Files.createDirectory(Paths.get(uploadPath));
//            Files.createDirectory(Paths.get(uploadPathQR));
//            Files.createDirectory(Paths.get(uploadPathCCCD));
    }

    @Override
    public Map<Integer, String> save(MultipartFile file) {
        Map<Integer, String> res = new HashMap<>();
        try {
            if (null == file || !isSupportedContentType(file.getContentType().toLowerCase())) {
                res.put(0, "File upload không hợp lệ!");
                return res;
            }
            String fileName = "file_" + Utils.getRandomString(12)+getFileExtension(file.getOriginalFilename());
            Files.copy(file.getInputStream(), Paths.get(uploadPath).resolve(fileName));
            res.put(1, fileName);
        } catch (Exception e) {
            throw new RuntimeException("Xảy ra lỗi trong quá trình xử lý. Error: " + e.getMessage());
        }
        return res;
    }

    @Override
    public Map<Integer, String> saveCCCD(MultipartFile file) {
        Map<Integer, String> res = new HashMap<>();
        try {
            if (null == file || !isSupportedContentType(file.getContentType().toLowerCase())) {
                res.put(0, "File upload không hợp lệ!");
                return res;
            }
            String fileName = "file_" + Utils.getRandomString(12)+getFileExtension(file.getOriginalFilename());
            Files.copy(file.getInputStream(), Paths.get(uploadPathCCCD).resolve(fileName));
            res.put(1, fileName);
        } catch (Exception e) {
            throw new RuntimeException("Xảy ra lỗi trong quá trình xử lý. Error: " + e.getMessage());
        }
        return res;
    }

    public String saveFile(MultipartFile file) {
        String fileName = "";
        try {
            if (null == file || !isSupportedContentType(file.getContentType().toLowerCase())) {
                return "File upload không hợp lệ!";
            }
            fileName = "file_" + Utils.getRandomString(12)+getFileExtension(file.getOriginalFilename());
            Files.copy(file.getInputStream(), Paths.get(uploadPath).resolve(fileName));
        } catch (Exception e) {
            throw new RuntimeException("Xảy ra lỗi trong quá trình xử lý. Error: " + e.getMessage());
        }
        return fileName;
    }

    @Override
    public Resource load(String filename) {
        try {
            File dir = new File(uploadPath);
            File f = Utils.searchFile(dir, filename);
            if (f != null) {
                Path path = f.toPath();
                return new UrlResource(path.toUri());
            }else {
                throw new RuntimeException("File not found!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(Paths.get(uploadPath), 1).filter(path -> !path.equals(Paths.get(uploadPath))).map(Paths.get(uploadPath)::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Không thể lấy danh sách files!");
        }
    }

//    @Override
//    public void deleteAll() {
//        FileSystemUtils.deleteRecursively(root.toFile());
//    }

    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("text/xml")
                || contentType.equals("text/plain")
                || contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg")
                || contentType.equals("image/gif")
                || contentType.equals("application/pdf")
                || contentType.equals("application/msword")
                || contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
                || contentType.equals("application/vnd.ms-excel")
                || contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                || contentType.equals("application/vnd.ms-powerpoint")
                || contentType.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")
                || contentType.equals("application/vnd.ms-access")
                || contentType.equals("audio/mpeg") //mp3
                || contentType.equals("audio/ogg")
                || contentType.equals("video/3gpp")
                || contentType.equals("video/x-msvideo")
                || contentType.equals("video/ogg")
                || contentType.equals("application/mp4")
                || contentType.equals("application/x-7z-compressed")
                || contentType.equals("application/zip")
                || contentType.equals("application/x-rar-compressed")
                || contentType.equals("application/octet-stream")
                || contentType.equals("application/x-www-form-urlencoded");

    }

    public String getFileExtension(String filename) {
//        String name = file.getName();
        int lastIndexOf = filename.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return filename.substring(lastIndexOf);
    }

    private void drawFinderPatternCircleStyle(Graphics2D graphics, int x, int y, int circleDiameter) {
        final int WHITE_CIRCLE_DIAMETER = circleDiameter*5/7;
        final int WHITE_CIRCLE_OFFSET = circleDiameter/7;
        final int MIDDLE_DOT_DIAMETER = circleDiameter*3/7;
        final int MIDDLE_DOT_OFFSET = circleDiameter*2/7;

        //Màu mắt ngoài cùng
        graphics.setColor(Color.decode("#009c87"));
        graphics.fillOval(x, y, circleDiameter, circleDiameter);
        //Màu mắt giữa
        graphics.setColor(Color.white);
        graphics.fillOval(x + WHITE_CIRCLE_OFFSET, y + WHITE_CIRCLE_OFFSET, WHITE_CIRCLE_DIAMETER, WHITE_CIRCLE_DIAMETER);
        //Màu mắt trong
        graphics.setColor(Color.decode("#f97918"));
        graphics.fillOval(x + MIDDLE_DOT_OFFSET, y + MIDDLE_DOT_OFFSET, MIDDLE_DOT_DIAMETER, MIDDLE_DOT_DIAMETER);
    }

}
