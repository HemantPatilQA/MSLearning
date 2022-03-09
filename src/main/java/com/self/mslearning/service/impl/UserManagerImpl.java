package com.self.mslearning.service.impl;

import com.self.mslearning.model.MyUser;
import com.self.mslearning.service.UserManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagerImpl implements UserManager {
    @Override
    public List<MyUser> addUser(MyUser myUser) {
        myUserList.add(myUser);
        return myUserList;
    }
}
