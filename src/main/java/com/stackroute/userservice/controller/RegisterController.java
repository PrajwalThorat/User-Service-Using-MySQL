package com.stackroute.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.userservice.model.User;
import com.stackroute.userservice.service.UserService;



@RestController
@RequestMapping("/api/v1/userservice/registration")
public class RegisterController {

    @Autowired
    private UserService userService;

    
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
    	if(user != null)
    		try {
    			userService.saveUser(user);
    			return new ResponseEntity<User>(
    					user,
    					HttpStatus.CREATED);
    		}catch (Exception e) {
    			e.printStackTrace();
    			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }
}
