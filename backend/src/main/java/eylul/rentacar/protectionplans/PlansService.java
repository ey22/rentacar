package eylul.rentacar.protectionplans;

import eylul.rentacar.protectionplans.PlansInformation;
import eylul.rentacar.protectionplans.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//This class acts as a bridge between the PlansController and PlansRepository
@Service
public class PlansService {
    @Autowired
    private PlansRepository plansRepository;
    //Retrieve all plans from the database, return list
    public List<PlansInformation> getAllPlansInformation() {
        return plansRepository.findAll();
    }
    //Retrieve a plan by its unique ID
    public PlansInformation getPlansInformationById(Long id) {
        return plansRepository.findById(id).orElse(null);
    }



}
