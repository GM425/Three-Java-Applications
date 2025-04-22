package com.service.userservice.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// import com.service.userservice.dtos.PasswordChangeRequest;
// import com.service.userservice.dtos.RequestSummary;
// import com.service.userservice.dtos.Summary;
import com.service.userservice.dtos.UserDTO;
import com.service.userservice.entity.CustomActivity;
import com.service.userservice.entity.Login;
import com.service.userservice.entity.User;
import com.service.userservice.repository.CustomActivityRepository;
import com.service.userservice.repository.UserRepository;

@Service
public class UserService {
    
    // @Autowired
    // Remove contructor and uncomment to use dependency injection to let Spring handle
    // Using Constructor injection as userRepository essential and contructor injection is more reliable
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    // private CustomActivityRepository customActivityRepository;
    public String[] activities = {"Push-Ups Regular", "Push-Ups Clap", "Push-Ups One-Handed", "Sit-Ups", "Reverse Sit-Ups", "Crunches", "Burpies"};


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(User user){
        System.out.println("User Service hit /////////////////////////////");

        ArrayList<User> users = userRepository.findAll();
        boolean found = false;
        for (User userCheck : users){
            if (user.getUsername().equals(userCheck.getUsername()) || user.getEmail().equals(userCheck.getEmail())){
                found = true;
            }
        }
        if(found == true){
            throw(new RuntimeException("The user can't be created as this username and/or email is already taken. Please add with a different username and/or email as neither can be match an existing username or email."));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // public void createCustomActivity(String username, Login login){
    //     //User Table is checked and saved in an optional as it may or may not be found
    //     Optional<User> user = userRepository.findByUsername(username);
    //     //orElseThrow is added to the optional so if nothing is found for the optional, a runtime error will be thrown as there is no user with that username
    //     user.orElseThrow(() -> new RuntimeException("Can't create that activity as there is no account created with that username."));
    //     //checking the default Strings. If matches, the user is informed that this step isn't neccessary. 
    //     boolean found = false;
    //     for (String activity : activities){
    //         // Check this //////////////////////// as login.getActivity() is issue I think.
    //         if (activity.equals(login.getActivity())){
    //             found = true;
    //         }
    //     }
    //     if(found == true){
    //         throw(new RuntimeException("You have entered one of the available activities by default that include Push-Ups Regular, Push-Ups Clap, Push-Ups One-Handed, Sit-Ups, Reverse Sit-Ups, Crunches and Burpies. The default post route of record/create can be used to create records without creating the activity first as they don't need to be authenticated and created as custom activities."));
    //     }

        //the password for the passed in entity and the found user is checked to confirm authentication
        // System.out.println("check if this atleast runs ijdjdijdjdijfdiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii/////////////");
        // System.out.println("check/////////////");
        // System.out.println(login.getPassword());
        // System.out.println(user.get().getPassword());
        // System.out.println(login.getPassword().equals(user.get().getPassword()));

    //     if(login.getPassword().equals(user.get().getPassword())){
    //         System.out.println("check/////////////");
    //         System.out.println(login.getPassword());
    //         System.out.println(user.get().getPassword());
    //         //the password matches so a new Custom Activity Object is created
    //         CustomActivity activityToAdd = new CustomActivity();
    //         //the user the activity is associated with is set
    //         // activityToAdd.set(user.get());
    //         //the activity string is set
    //         activityToAdd.setActivity(login.getActivity());
    //         //the custom activity is saved to the customactivity_db table in the USER_DB database.
    //         customActivityRepository.save(activityToAdd);
    //     } else {
    //         //the password doesn't match so a runtime exception is thrown to be handled by the global exception handler saying that the password is incorrect.
    //         throw(new RuntimeException("That password is incorrect for the account with that username. Please try again."));
    //     }
    // }


    // public ArrayList<CustomActivity> returnUserCustomActivities(String username, String password){
    //       //User Table is checked and saved in an optional as it may or may not be found
    //       Optional<User> user = userRepository.findByUsername(username);
    //       //orElseThrow is added to the optional so if nothing is found for the optional, a runtime error will be thrown as there is no user with that username
    //       user.orElseThrow(() -> new RuntimeException("Can't see your custom activities as there is no account created with that username."));
    //       User userFound = user.get();
    //       //checking the default Strings. If matches, the user is informed that this step isn't neccessary. 
    //     //   boolean found = false;
    //     //   for (String activity : activities){
    //     //       if (activity.equals(login.getActivity())){
    //     //           found = true;
    //     //       }
    //     //   }
    //     //   if(found == true){
    //     //       throw(new RuntimeException("You have entered one of the available activities by default that include Push-Ups Regular, Push-Ups Clap, Push-Ups One-Handed, Sit-Ups, Reverse Sit-Ups, Crunches and Burpies."));
    //     //   }
    //       System.out.println("check if this atleast runs ijdjdijdjdijfdiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii/////////////");
    //       System.out.println("check/////////////");
    //       System.out.println(password);
    //       System.out.println(userFound.getPassword());
    //       System.out.println(password.equals(userFound.getPassword()));
    //       //the password for the passed in entity and the found user is checked to confirm authentication
    //       if(password.equals(userFound.getPassword())){
    //         System.out.println(password);
    //           System.out.println(user.get().getPassword());
    //           System.out.println(password.equals(userFound.getPassword()));
    //           return customActivityRepository.findAll();
    //       } else {
    //           //the password doesn't match so a runtime exception is thrown to be handled by the global exception handler saying that the password is incorrect.
    //           throw(new RuntimeException("That password is incorrect for the account with that username. Please try again."));
    //       }
    // }


    // public User changePasswordUser(String username, PasswordChangeRequest changeRequest){
    //     Optional<User> user = userRepository.findByUsername(username);
    //     user.orElseThrow(() -> new RuntimeException("The password cannot be changed as a user account doesn't exist with this username."));
    //     User userFound = user.get();
    //     if(userFound.getPassword().equals(changeRequest.getCurrentpw())){
    //         userFound.setPassword(changeRequest.getNewpw());
    //         userRepository.save(userFound);
    //         //Right now no place for new password to be provided. The password passed in is being authenticated but being set to static String literal of "passwordChanged"
    //         //Test, if see password changed, then create a login password that includes one to validate and one to be the new password
    //             //Or create and pass JWT token
    //         return userFound;
    //     } else {
    //         throw(new RuntimeException("You entered the password incorrectly for this username, so the user's password couldn't be updated."));
    //     }
    // } 
    
    public ArrayList<UserDTO> showRegisteredUsernames(){
        ArrayList<User> users = userRepository.findAll();
        ArrayList<UserDTO> usernamesAll = new ArrayList<UserDTO>();
        for (User user : users){
            UserDTO usernameDTO = new UserDTO(user);
            System.out.println("this is the encrypted password" + user.getPassword());
            usernamesAll.add(usernameDTO);
        }
        return usernamesAll;
    }

    // public Optional<User> getUserDetails(LoginRequest loginRequest){
    //     Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
    //     user.orElseThrow(() -> new RuntimeException("Can't find an account with that username."));
    // }

   
}
