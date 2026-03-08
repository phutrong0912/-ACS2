package com.dacs2.service;

import com.dacs2.model.Slider;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SliderService {

    List<Slider> getSliderList();

    void addSlider(MultipartFile img, String url) throws IOException;

    void deleteSlider(Integer id);

}
