package eylul.rentacar.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //This marks the class as a REST controller for handling HTTP requests
@RequestMapping("/users") //Base URL for all endpoints in this controller
@CrossOrigin(origins = "http://localhost:8080") //Web application runs on one port to request resources
//This class is used for handling HTTP requests
public class UserController {
    @Autowired
    private UserService userService;

    //Fetch all users from database and return list of users
    @GetMapping("")
    //To handle get http requests
    public List<UserInformation> getAllUserInformation(){
        return userService.getAllUserInformation();
    }

    //Fetch user details by id for a specific user
    @GetMapping("/{id}")
    public UserInformation getUserInformationById(@PathVariable Long id) {
        return userService.getUserInformationById(id);
    }

    //Check the correctness of the user information for login
    @PostMapping("/login")
    public UserInformation login(@RequestBody UserInformation userInformation) {
        return userService.getUserInformationByNameAndPassword(userInformation.getName(), userInformation.getPassword());
    }

    //Create user with their information
    @PostMapping("")
    public UserInformation createUser(@RequestBody UserInformation userInformation) {
        return userService.createUserInformation(userInformation);
    }

    //Update user details of an existing one
    @PutMapping("/{id}")
    public UserInformation updateUser(@PathVariable Long id, @RequestBody UserInformation userInformation) {
        return userService.updateUserInformation(id, userInformation);
    }

    //Delete an existing user with its id
    @DeleteMapping("/{id}")
    public void deleteUserInformation(@PathVariable Long id) {
        userService.deleteUserInformation(id);
    }
}
