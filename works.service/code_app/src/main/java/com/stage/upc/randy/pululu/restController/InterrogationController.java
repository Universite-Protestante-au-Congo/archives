package com.stage.upc.randy.pululu.restController;

import com.stage.upc.randy.pululu.models.Interrogation;
import com.stage.upc.randy.pululu.services.InterrogationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interro")
@CrossOrigin(origins = "http://localhost:4200")
public class InterrogationController {
    @Autowired
    InterrogationServices interrogationServices;

    @RequestMapping(method =  RequestMethod.GET)
    public List<Interrogation> getAllInterros(){
        return interrogationServices.getAllInterros();
    }

    @RequestMapping(value="/{id}",method =  RequestMethod.GET)
    public Interrogation getInterroById(@PathVariable("id") Long id){
        return interrogationServices.getInterroById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Interrogation createInterro(@RequestBody Interrogation interrogation) {
        return interrogationServices.saveInterro(interrogation);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Interrogation updateInterro(@RequestBody Interrogation interrogation) {
        return interrogationServices.updateInterro(interrogation);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteInterro(@PathVariable("id") Long id) {
        interrogationServices.deleteInterroById(id);
    }
}
