package com.stackroute.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.userservice.model.User;
import com.stackroute.userservice.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/userservice/users")
public class UserController {

    @Autowired
    private UserService userService;
    

    
    @GetMapping 
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userService.getAllUsers();
        if(!users.isEmpty()) {
        	
        	return new ResponseEntity<List<User>>(users,
        			  HttpStatus.OK); 
        }
        return 	new ResponseEntity<>(null,
        		HttpStatus.NOT_FOUND);
    }

    @GetMapping (params = "name")
    public ResponseEntity<User> getUserByName(@RequestParam("name") String userName){
    	User user = userService.getUserByName(userName);
    	if(user != null) {
    		return new ResponseEntity<User>(user,
    				HttpStatus.OK);
    	}
        return new ResponseEntity<>(null,
        		HttpStatus.NOT_FOUND);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user != null) {
    		return new ResponseEntity<User>(user,
    				HttpStatus.OK);
    	}
        return new ResponseEntity<>(null,
        		HttpStatus.NOT_FOUND);
    }

    @PostMapping 
    public ResponseEntity<User> addUser(@RequestBody User user, HttpServletRequest request){
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
