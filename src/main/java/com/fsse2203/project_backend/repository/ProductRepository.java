package com.fsse2203.project_backend.repository;

import com.fsse2203.project_backend.data.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {
    ProductEntity findByPid(@Param("pid") Integer pid);
    boolean existsByName(@Param("Name")String name);
}
