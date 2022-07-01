package com.fsse2203.project_backend.service;

import com.fsse2203.project_backend.data.product.CreateProductData;
import com.fsse2203.project_backend.data.product.ProductDetailData;
import com.fsse2203.project_backend.data.product.UpdateProductData;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;
import com.fsse2203.project_backend.exception.CreateProductExistedException;
import com.fsse2203.project_backend.exception.ProductNotFoundException;
import com.fsse2203.project_backend.exception.StockInputExcepution;
import com.fsse2203.project_backend.exception.StockNotEnoughException;

import java.util.List;

public interface ProductService {
    ProductDetailData createProduct(CreateProductData createProductData) throws CreateProductExistedException, StockInputExcepution;
    List<ProductDetailData> getAllProduct();
    ProductDetailData searchProductEntityByPid(Integer pid) throws ProductNotFoundException;
    ProductDetailData updateProduct(UpdateProductData updateProductData) throws ProductNotFoundException,StockInputExcepution;
    ProductDetailData deleteProduct(Integer pid)throws ProductNotFoundException;
    void deduceProductStockByPid(Integer pid, Integer quantity) throws ProductNotFoundException, StockNotEnoughException;
    ProductEntity searchPid(Integer pid);
}
