package com.dacs2.service;

import com.dacs2.model.Brand;

import java.util.List;

public interface BrandService {

    Brand save(Brand brand);

    Boolean existBrand(String name);

    List<Brand> getAllBrand();

    void deleteBrand(Integer id);

    Brand getBrandById(Integer id);

    List<Brand> getAllBrandIsActive();

}
