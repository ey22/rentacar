package eylul.rentacar.protectionplans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //This marks the class as a REST controller for handling HTTP requests
@RequestMapping("/plans") //Base URL for all endpoints in this controller
@CrossOrigin(origins = "http://localhost:8080") //Web application runs on one port to request resources

//Handles HTTP Requests and return responses
public class PlansController {
    //Will use plansService methods
    @Autowired
    private PlansService plansService;

    //Fetch all plans from database and return list of plans
    @GetMapping("")
    //To handle get http requests
    public List<PlansInformation> getAllPlansInformation(){
        return plansService.getAllPlansInformation();
    }

    //Fetch plan details by id for a specific plan
    @GetMapping("/{id}")
    public PlansInformation getPlansInformationById(@PathVariable Long id) {
        return plansService.getPlansInformationById(id);
    }
}


