package eylul.rentacar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:8080")
//This class is used for handling HTTP requests
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    //To handle get http requests
    public List<UserInformation> getAllUserInformation(){
        return userService.getAllUserInformation();
    }

    @GetMapping("/{id}")
    public UserInformation getUserInformationById(@PathVariable Long id) {
        return userService.getUserInformationById(id);
    }

    @PostMapping("/login")
    public UserInformation login(@RequestBody UserInformation userInformation) {
        return userService.getUserInformationByNameAndPassword(userInformation.getName(), userInformation.getPassword());
    }

    @PostMapping("")
    public UserInformation createBook(@RequestBody UserInformation userInformation) {
        return userService.createUserInformation(userInformation);
    }

    @PutMapping("/{id}")
    public UserInformation updateBook(@PathVariable Long id, @RequestBody UserInformation userInformation) {
        return userService.updateUserInformation(id, userInformation);
    }

    @DeleteMapping("/{id}")
    public void deleteUserInformation(@PathVariable Long id) {
        userService.deleteUserInformation(id);
    }
}
