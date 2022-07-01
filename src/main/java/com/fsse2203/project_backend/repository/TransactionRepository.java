package com.fsse2203.project_backend.repository;

import com.fsse2203.project_backend.data.Transaction.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer> {
TransactionEntity findByTidAndUser_FirebaseUid(Integer tid,String firebaseUid);
}
