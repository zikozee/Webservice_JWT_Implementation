package com.zikozee.sprinboot.consumingwebservices.Controller;

import com.zikozee.sprinboot.consumingwebservices.Entity.Address;
import com.zikozee.sprinboot.consumingwebservices.Entity.User;
import com.zikozee.sprinboot.consumingwebservices.Service.UserService;
import com.zikozee.sprinboot.consumingwebservices.jwt.resource.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService){
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> getUsersList(){

        return userService.getUserList();
        //return "List:==>>" + userService.alternativeUserList().toString();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        if(userId >= userService.getUserList().size() || userId<= 0){
            throw new AuthenticationException("Student id not found -  " + userId);
        }
        return userService.getUser(userId);
    }

    //used @GetMapping("/address") initially making me add additional ant matcher to secure /address/**
    @GetMapping("/users/address")
    public List<Address> getUserAddress(){
        return userService.getAddressList();
    }

    @GetMapping("/users/address/{userId}")
    public Address getUserAddress(@PathVariable int userId){
        if(userId >= userService.getUserList().size() || userId<= 0){
            throw new AuthenticationException("Student id not found -  " + userId);
        }
        return userService.getUserAddress(userId);
    }

    @PostMapping("/users")
    public User AddUser(User user){
        //also just in case they pass an id in JSON ... set id to 0
        // this is to force  a save of new item  ... instead of update
        user.setId(0);

        userService.saveUser(user);

        return user;
    }

    @PutMapping("/users")
    public User Update(User user){

        userService.saveUser(user);

        return user;
    }

    @DeleteMapping("/users/{userId}")
    public String Delete(@PathVariable int userId){
        userService.deleteUser(userId);

        return "user with id "+ userId + " was deleted successfully";
    }

}
