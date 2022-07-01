package com.fsse2203.project_backend.data.user.entity;


import com.fsse2203.project_backend.data.user.CreateUserData;
import com.fsse2203.project_backend.data.user.UserDetailData;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;

    @Column(name = "firebase_uid")
    private String firebaseUid;

    @Column(name = "email")
    private String email;

    public UserEntity() {
    }

    public UserEntity(CreateUserData data) {
        this.firebaseUid = data.getFirebaseUid();
        this.email = data.getEmail();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
