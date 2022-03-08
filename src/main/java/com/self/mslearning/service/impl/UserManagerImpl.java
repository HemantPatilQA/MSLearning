package com.self.mslearning.service.impl;

import com.self.mslearning.model.MyUser;
import com.self.mslearning.service.UserManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerImpl implements UserManager {
    @Override
    public List<MyUser> addUser(MyUser myUser) {
        myUserList.add(myUser);
        return myUserList;
    }

    @Override
    public List<MyUser> getUsers(String sName) {
        if(sName != null) {
            List<MyUser> myLocalUserList = new ArrayList<>();
            myUserList.forEach(myUser -> {
                if(myUser.getfName().contains(sName) || myUser.getlName().contains(sName) || myUser.getUserName().contains(sName))
                    myLocalUserList.add(myUser);
            });
            return myLocalUserList;
        }else
            return myUserList;
    }

    @Override
    public List<MyUser> removeUser(String sName) {
        if(sName != null){
            List<MyUser> delUser = new ArrayList<>();
            myUserList.forEach(myUser -> {
                if(myUser.getfName().equalsIgnoreCase(sName) || myUser.getlName().equalsIgnoreCase(sName) || myUser.getUserName().equalsIgnoreCase(sName))
                    delUser.add(myUser);
            });

            delUser.forEach(myUserList::remove);
        }
        return myUserList;
    }
}
