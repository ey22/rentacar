package eylul.rentacar.users;

import eylul.rentacar.users.UserInformation;
import eylul.rentacar.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
//This class acts as a bridge between the UserController and UserRepository
@Service
//This class uses the UserRepository methods
public class UserService {

    @Autowired //Allows Spring to automatically resolve and inject dependencies into a class
    private UserRepository userRepository;

    //Retrieve all users from the database, return list
    public List<UserInformation> getAllUserInformation() {
        return userRepository.findAll();
    }

    //Retrieve a user by its unique ID or name and password
    public UserInformation getUserInformationById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserInformation getUserInformationByNameAndPassword (String name,String password) {
       List<UserInformation> findUserInfo = userRepository.findByName(name);
       if(findUserInfo.size() == 1){
           UserInformation user = findUserInfo.getFirst();
           if(user.getPassword().equals(password)) {
               return user;
           }
           else{
               throw new IllegalArgumentException("Password is incorrect!");
           }
       }else if (findUserInfo.isEmpty()) {
           throw new NoSuchElementException("There is no user with this name!");
       }throw new IllegalStateException("Unexpected error Multiple users found!");
    }

    //Add user information to database
    public UserInformation createUserInformation(UserInformation userInformation) {
        return userRepository.save(userInformation);
    }

    //Update user information in the database
    public UserInformation updateUserInformation(Long id, UserInformation userInformation) {
        UserInformation existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(userInformation.getName());
            existingUser.setPassword(userInformation.getPassword());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    //Delete user from database
    public void deleteUserInformation(Long id) {
        userRepository.deleteById(id);
    }

}
