package com.self.mslearning.controller;

import com.self.mslearning.model.MyUser;
import com.self.mslearning.service.impl.UserManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyUserController {

    //List<MyUser>  myUserList = new ArrayList<MyUser>();
    @Autowired UserManagerImpl myUserMgr;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(){
        return "Hello World ";
    }

    @PostMapping(value = "/userManager/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<MyUser>> addUser(@RequestBody MyUser myUser){
        return new ResponseEntity<List<MyUser>>(myUserMgr.addUser(myUser), HttpStatus.OK);
    }
/*
    @GetMapping(value = "/userManager/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<MyUser>> getUsers(@RequestParam(value = "name", required = false) String sName){
        if(sName != null) {
            List<MyUser> myLocalUserList = new ArrayList<MyUser>();
            myUserList.forEach(myUser -> {
                if (myUser.getfName().contains(sName) || myUser.getlName().contains(sName) || myUser.getUserName().contains(sName))
                    myLocalUserList.add(myUser);
            });
            return new ResponseEntity<List<MyUser>>(myLocalUserList, HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<MyUser>>(myUserList, HttpStatus.OK);
    }

    @DeleteMapping("/userManager/deleteUser")
    public @ResponseBody ResponseEntity<List<MyUser>> removeUser(@RequestParam(value = "name", required = false) String sName){
        if(sName != null) {
            List<MyUser> myLocalUserList = new ArrayList<MyUser>();
            myUserList.forEach(myUser -> {
                if (myUser.getfName().contains(sName) || myUser.getlName().contains(sName) || myUser.getUserName().contains(sName))
                    myLocalUserList.add(myUser);
            });

            myLocalUserList.forEach(myUser -> myUserList.remove(myUser));
        }
        return new ResponseEntity<List<MyUser>>(myUserList, HttpStatus.OK);
    }*/
}
