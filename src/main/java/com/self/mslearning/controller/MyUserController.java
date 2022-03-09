package com.self.mslearning.controller;

import com.self.mslearning.model.MyUser;
import com.self.mslearning.service.impl.UserManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyUserController {

    @Autowired UserManagerImpl myUserMgr;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(){
        return "Hello World ";
    }

    @PostMapping(value = "/userManager/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<MyUser>> addUser(@RequestBody MyUser myUser){
        return new ResponseEntity<>(myUserMgr.addUser(myUser), HttpStatus.CREATED);
    }

    @GetMapping(value = "/userManager/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<MyUser>> getUsers(@RequestParam(value = "name", required = false) String sName){
        return new ResponseEntity<>(myUserMgr.getUsers(sName), HttpStatus.OK);
    }

    @DeleteMapping("/userManager/deleteUser")
    public @ResponseBody ResponseEntity<List<MyUser>> removeUser(@RequestParam(value = "name", required = false) String sName){
        return new ResponseEntity<>(myUserMgr.removeUser(sName), HttpStatus.OK);
    }
}
