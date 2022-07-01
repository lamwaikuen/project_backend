package com.fsse2203.project_backend.service.impl;

import com.fsse2203.project_backend.data.user.CreateUserData;
import com.fsse2203.project_backend.data.user.UserDetailData;
import com.fsse2203.project_backend.data.user.entity.UserEntity;
import com.fsse2203.project_backend.repository.UserRepository;
import com.fsse2203.project_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetailData createUser(CreateUserData data){
        UserEntity entity = new UserEntity(data);
        entity=userRepository.save(entity);
        return  new UserDetailData(entity);
    }
    @Override
    public UserDetailData getUserDetailByFirebaseUid(String firebaseUid) {
        if(userRepository.findByFirebaseUid(firebaseUid)==null){
            return null;
        }
       return new UserDetailData(getUserEntityByfireBaseUid(firebaseUid));
    }

    public UserEntity getUserEntityByfireBaseUid(String firebaseUid) {
        return  userRepository.findByFirebaseUid(firebaseUid);
    }
}
