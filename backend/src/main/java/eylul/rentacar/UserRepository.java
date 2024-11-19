package eylul.rentacar;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInformation,Long> {
    //To use CRUD (Create, Read, Update, Delete) operations from JpaRepository

    List<UserInformation> findByName(String name);
}


