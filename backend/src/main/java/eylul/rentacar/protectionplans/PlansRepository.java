package eylul.rentacar.protectionplans;


import eylul.rentacar.protectionplans.PlansInformation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlansRepository extends JpaRepository<PlansInformation, Long> {
}

