package com.aendyear.komawatsir.service;

import com.aendyear.komawatsir.dto.ImageDto;
import com.aendyear.komawatsir.entity.Image;
import com.aendyear.komawatsir.repository.ImageRepository;
import com.aendyear.komawatsir.type.ImageCategory;
import com.aendyear.komawatsir.type.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    // 이미지 정보 조회
    public ImageDto getSingleImage(Integer imageId) {
        ImageDto result = new ImageDto();

        Optional<Image> image = imageRepository.findById(imageId);
        if (image.isPresent()) {
            result = Mapper.toDto(image.get());
        }

        return result;
    }

    public List<ImageDto> getAllImage(ImageCategory category, Integer userId, boolean isFront) {
        System.out.println(SourceType.SERVICE + " " + category + " " +  isFront + " " +  userId);
        return imageRepository.findBySourceTypeAndCategoryAndIsFrontOrUserId(SourceType.SERVICE, category, isFront, userId).stream().map(Mapper::toDto).toList();
    }
}
