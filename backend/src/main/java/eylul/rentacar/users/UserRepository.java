package eylul.rentacar.users;

import eylul.rentacar.users.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//Extend Jpa repository to inherit default database methods(save, delete,etc.)

@Repository
public interface UserRepository extends JpaRepository<UserInformation,Long> {
    //To use CRUD (Create, Read, Update, Delete) operations from JpaRepository

    //Find user by their name
    List<UserInformation> findByName(String name);
}


