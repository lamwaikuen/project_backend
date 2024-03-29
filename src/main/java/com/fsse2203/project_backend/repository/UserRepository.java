package com.fsse2203.project_backend.repository;

import com.fsse2203.project_backend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity,String> {
    UserEntity findByFirebaseUid(@Param("firebaseUid")String firebaseUid);
}
