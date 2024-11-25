package eylul.rentacar.protectionplans;

import eylul.rentacar.protectionplans.PlansInformation;
import eylul.rentacar.protectionplans.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlansService {
    @Autowired
    private PlansRepository plansRepository;

    public List<PlansInformation> getAllPlansInformation() {
        return plansRepository.findAll();
    }

    public PlansInformation getPlansInformationById(Long id) {
        return plansRepository.findById(id).orElse(null);
    }



}
