package eylul.rentacar.protectionplans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/plans")
@CrossOrigin(origins = "http://localhost:8080")

public class PlansController {
    @Autowired
    private PlansService plansService;

    @GetMapping("")
    //To handle get http requests
    public List<PlansInformation> getAllPlansInformation(){
        return plansService.getAllPlansInformation();
    }

    @GetMapping("/{id}")
    public PlansInformation getPlansInformationById(@PathVariable Long id) {
        return plansService.getPlansInformationById(id);
    }
}


