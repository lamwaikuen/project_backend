package com.fsse2203.project_backend.repository;

import com.fsse2203.project_backend.data.Transaction.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionProductRepository extends CrudRepository <TransactionProductEntity,Integer>{

}
