package com.fsse2203.project_backend.service;

import com.fsse2203.project_backend.data.user.CreateUserData;
import com.fsse2203.project_backend.data.user.UserDetailData;
import com.fsse2203.project_backend.data.user.entity.UserEntity;

public interface UserService {
    UserDetailData getUserDetailByFirebaseUid(String firebaseUid);
    UserDetailData createUser(CreateUserData data);
    UserEntity getUserEntityByfireBaseUid(String firebaseUid);
}
