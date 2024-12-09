package eylul.rentacar.protectionplans;


import eylul.rentacar.protectionplans.PlansInformation;
import org.springframework.data.jpa.repository.JpaRepository;
//Extend Jpa repository to inherit default database methods(save, delete,etc.)

public interface PlansRepository extends JpaRepository<PlansInformation, Long> {
}

