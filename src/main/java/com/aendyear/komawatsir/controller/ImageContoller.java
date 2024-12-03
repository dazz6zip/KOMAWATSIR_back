package com.aendyear.komawatsir.controller;

import com.aendyear.komawatsir.dto.ImageDto;
import com.aendyear.komawatsir.entity.Image;
import com.aendyear.komawatsir.repository.ImageRepository;
import com.aendyear.komawatsir.service.ImageService;
import com.aendyear.komawatsir.type.ImageCategory;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageContoller {

    @Autowired
    private ImageService imageService;

    @GetMapping("/image/{imageId}")
    @Operation(summary = "load single image", description = "단일 이미지 조회")
    public ResponseEntity<ImageDto> getSingleImage(@PathVariable Integer imageId) {
        return ResponseEntity.ok(imageService.getSingleImage(imageId));
    }

    // todo : 카테고리 + 페이징...
    // 이미지 목록 조회
    @GetMapping("/{type}/{userId}/{isFront}")
    @Operation(summary = "load all image by category", description = "카테고리별 이미지 조회")
    public ResponseEntity<List<ImageDto>> getAllImage(@PathVariable String type, @PathVariable Integer userId, @PathVariable boolean isFront) {
        ImageCategory category = type.equals("solid") ? ImageCategory.SOLID : type.equals("gradient")? ImageCategory.GRADATION : type.equals("custom") ? ImageCategory.CUSTOM : ImageCategory.SEASON;
        return ResponseEntity.ok(imageService.getAllImage(category, userId, isFront));
    }

}
