package com.dacs2.service;

import com.dacs2.model.Category;
import com.dacs2.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Page<Product> getAllProductsPagination(Integer pageNumber, Integer pageSize, String sapxep);

    void deleteProduct(int id);

    Product getProductById(Integer id);

    List<Product> getProductByDanhMuc(Category danhmuc);

    Page<Product> searchProdcutOnAdmin(Integer pageNumber, Integer pageSize, String ch, String sapxep);

    Page<Product> getAllProductsForHomePagination(Integer pageNumber, Integer pageSize, String danhmuc, String thuonghieu, String sapxep, String danhGia, Double minPrice, Double maxPrice);

    Page<Product> searchProductPagination(Integer pageNumber, Integer pageSize, String ch, String danhmuc, String thuonghieu, String sapxep, String danhGia, Double minPrice, Double maxPrice);

    List<Product> getProductForView(Integer id);

    List<Product> getProductTop();

}
