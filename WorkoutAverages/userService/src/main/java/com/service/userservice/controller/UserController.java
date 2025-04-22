package com.service.userservice.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.service.userservice.dtos.PasswordChangeRequest;
import com.service.userservice.dtos.UserDTO;
// import com.service.userservice.entity.CustomActivity;
import com.service.userservice.entity.Login;
import com.service.userservice.entity.User;
import com.service.userservice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // @PutMapping("updatepassword/{username}")
    // public String changePassword(@PathVariable String username, @RequestBody PasswordChangeRequest changeRequest) {
    //     System.out.println("Put Update Password Route Healthy!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    //     User user = userService.changePasswordUser(username, changeRequest);
    //     return "The password for " + user.getUsername() + "was updated Successfully";
    // }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        userService.createUser(user);
        return "successful";
    }

    @PostMapping("/registration")
    public String registerUser(@RequestBody User user) {
        System.out.println("User Controller hit /////////////////////////////");
        userService.createUser(user);
        return "successful";
    }

    // @PostMapping("/activitycustom/{username}")
    // public String addCustomActivity(@PathVariable String username, @RequestBody Login login) {
       
    //     userService.createCustomActivity(username, login);
        
    //     return "successfully hit";
    // }

    // @GetMapping("/activitycustom/{username}")
    // public ArrayList<CustomActivity> returnAllUserCustomActivities(@PathVariable String username, @RequestBody String password) {
    //     ArrayList<CustomActivity> allActivities = userService.returnUserCustomActivities(username, password);
    //     //Just have to check here for a duplicate activity and throw a runtime error if found
    //     return allActivities;
    // }

    @GetMapping("/all")
    public ArrayList<UserDTO> returnAllUsers() {
        return userService.showRegisteredUsernames();
    }



    @GetMapping("health")
    public String getHealth(){
        return "Healthy";
    }
    



}
