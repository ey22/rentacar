package eylul.rentacar;

import eylul.rentacar.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
//This class uses the UserRepository methods
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserInformation> getAllUserInformation() {
        return userRepository.findAll();
    }

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

    public UserInformation createUserInformation(UserInformation userInformation) {
        return userRepository.save(userInformation);
    }

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

    public void deleteUserInformation(Long id) {
        userRepository.deleteById(id);
    }

}
