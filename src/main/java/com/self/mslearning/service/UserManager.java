package com.self.mslearning.service;

import com.self.mslearning.model.MyUser;

import java.util.ArrayList;
import java.util.List;

public interface UserManager {
    List<MyUser> myUserList = new ArrayList<MyUser>();

    List<MyUser> addUser(MyUser myUser);
}
