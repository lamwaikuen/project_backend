package com.fsse2203.project_backend.api;

import com.fsse2203.project_backend.config.EnvConfig;
import com.fsse2203.project_backend.data.product.CreateProductData;
import com.fsse2203.project_backend.data.product.ProductDetailData;
import com.fsse2203.project_backend.data.product.UpdateProductData;
import com.fsse2203.project_backend.data.product.dto.request.CreateProductRequestDto;
import com.fsse2203.project_backend.data.product.dto.request.UpdateDataRequestDto;
import com.fsse2203.project_backend.data.product.dto.response.GetProductResponseDto;
import com.fsse2203.project_backend.data.product.dto.response.ProductDetailResponseDto;
import com.fsse2203.project_backend.exception.CreateProductExistedException;
import com.fsse2203.project_backend.exception.ProductNotFoundException;
import com.fsse2203.project_backend.exception.StockInputExcepution;
import com.fsse2203.project_backend.repository.ProductRepository;
import com.fsse2203.project_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {EnvConfig.devBaseUrl,EnvConfig.proBaseUrl},maxAge = 3600)
@RestController
public class ProductApi {
    private final ProductService productService;

    @Autowired
    public ProductApi(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/product/create")
    public  ProductDetailResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) throws CreateProductExistedException, StockInputExcepution {
        return new ProductDetailResponseDto(productService.createProduct(
                new CreateProductData(createProductRequestDto)
        ));
    }

    @GetMapping("/public/product")
    public List<GetProductResponseDto> getAllProduct() {
        List<GetProductResponseDto> dtos = new ArrayList<>();

        List<ProductDetailData> datas = productService.getAllProduct();
        for (ProductDetailData data : datas) {
            dtos.add(new GetProductResponseDto(data));
        }
        return dtos;
    }

    @GetMapping("/public/product/{pid}")
    public ProductDetailResponseDto searchProductEntityByPid(@PathVariable("pid") Integer pid)
            throws ProductNotFoundException {
        return new ProductDetailResponseDto(productService.searchProductEntityByPid(pid));
    }

    @PutMapping("/product/update")
    public ProductDetailResponseDto updateProduct(@RequestBody UpdateDataRequestDto updatePersonRequestDto)throws StockInputExcepution {
        try {
            return new ProductDetailResponseDto(
                    productService.updateProduct(new UpdateProductData(updatePersonRequestDto))
            );
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

        @DeleteMapping("/product/delete")
        public ProductDetailResponseDto deleteProduct(@RequestParam Integer pid) {
            try {
                return new ProductDetailResponseDto(
                        productService.deleteProduct(pid)
                );
            } catch (ProductNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }

    }





