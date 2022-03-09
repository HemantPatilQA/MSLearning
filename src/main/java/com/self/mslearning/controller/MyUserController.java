package com.self.mslearning.controller;

import com.self.mslearning.model.MyUser;
import com.self.mslearning.service.impl.UserManagerImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MyUserController {

    @Autowired UserManagerImpl myUserMgr;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(){
        return "Hello World ";
    }

    @PostMapping(value = "/userManager/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> addUser(@RequestBody MyUser myUser){
        List<JSONObject> response = new ArrayList<>();
        JSONObject resCode = new JSONObject();
        resCode.put("ResponseCode", "201");
        response.add(resCode);
        System.out.println(resCode);

        JSONObject resMessage = new JSONObject();
        resMessage.put("ResponseMessage", "User Added Successfully");
        response.add(resMessage);

        System.out.println(resMessage);
        /*int index = 1;
        myUserMgr.addUser(myUser).forEach(myUser1 -> {
            JSONObject user = new JSONObject();
            user.put("User" + index, myUser);
            response.add(user);
        });*/
        System.out.println(response);
        //return new ResponseEntity<Object>(response, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "Users", myUserMgr.addUser(myUser),
                "ResponseMessage", "User Added Successfully",
                "ResponseCode", "201"
        ));
    }

    @GetMapping(path = "/hello", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sayHello()
    {
        //Get data from service layer into entityList.

        List<JSONObject> entities = new ArrayList<JSONObject>();
        //for (Entity n : entityList) {
            JSONObject entity = new JSONObject();
            entity.put("aa", "bb");
            entities.add(entity);
        //}
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
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
