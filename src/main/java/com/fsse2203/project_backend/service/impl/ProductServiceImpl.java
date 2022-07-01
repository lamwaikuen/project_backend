package com.fsse2203.project_backend.service.impl;

import com.fsse2203.project_backend.data.product.CreateProductData;
import com.fsse2203.project_backend.data.product.ProductDetailData;
import com.fsse2203.project_backend.data.product.UpdateProductData;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;
import com.fsse2203.project_backend.exception.CreateProductExistedException;
import com.fsse2203.project_backend.exception.ProductNotFoundException;
import com.fsse2203.project_backend.exception.StockInputExcepution;
import com.fsse2203.project_backend.exception.StockNotEnoughException;
import com.fsse2203.project_backend.repository.ProductRepository;
import com.fsse2203.project_backend.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDetailData createProduct(CreateProductData createProductData) throws CreateProductExistedException, StockInputExcepution {
        ProductEntity newProductEntiy = new ProductEntity(createProductData);
        if(createProductData.getStock()<0){
            throw new StockInputExcepution();
        }
        if (productRepository.existsByName(newProductEntiy.getName())) {
            logger.warn("CreateProduct: Product Existed");
            throw new CreateProductExistedException();
        }

        newProductEntiy = productRepository.save(newProductEntiy);

        return new ProductDetailData(newProductEntiy);
    }
    @Override
    public List<ProductDetailData> getAllProduct() {
        List<ProductDetailData> productDetailDataList = new ArrayList<>();
        for (ProductEntity entity : productRepository.findAll()) {
            productDetailDataList.add(new ProductDetailData(entity));
        }
        return productDetailDataList;
    }

    @Override
    public ProductDetailData searchProductEntityByPid(Integer pid) throws ProductNotFoundException{
        ProductEntity productEntity= productRepository.findByPid(pid);
        if(productEntity==null){
            throw new ProductNotFoundException();
        }
        return  new ProductDetailData(productEntity);
    }

    @Override
    public ProductDetailData updateProduct(UpdateProductData updateProductData)throws ProductNotFoundException,StockInputExcepution{
        ProductEntity entity=searchPid(updateProductData.getPid());

        if (entity == null) {
            logger.warn("Update Person: Person Not Found");
            throw new ProductNotFoundException();
        }
        if(updateProductData.getStock()<0){
            throw new StockInputExcepution();
        }
        entity.setName(updateProductData.getName());
        entity.setImageUrl(updateProductData.getImageUrl());
        entity.setDescription(updateProductData.getDescription());
        entity.setPrice(updateProductData.getPrice());
        entity.setStock(updateProductData.getStock());
        return new ProductDetailData(productRepository.save(entity));
    }

    @Override
    public ProductDetailData deleteProduct(Integer pid) throws ProductNotFoundException {
        ProductEntity entity = searchPid(pid);
        if (entity == null) {
            logger.warn("Delete Product: Product Not Found");
            throw new ProductNotFoundException();
        }
        productRepository.delete(entity);
        logger.info("Delete product: " + entity);
        return new ProductDetailData(entity);
    }

    public void deduceProductStockByPid(Integer pid, Integer quantity) throws ProductNotFoundException,StockNotEnoughException {
        ProductEntity productEntity= productRepository.findByPid(pid);
        if(productEntity==null){
            throw new ProductNotFoundException();
        }
        if(productEntity.getStock()<quantity){
            throw new StockNotEnoughException();
        }
        productEntity.setStock(productEntity.getStock()-quantity);
        productRepository.save(productEntity);
    }


    @Override
    public ProductEntity searchPid (Integer pid) {
        return productRepository.findByPid(pid);
    }
}





