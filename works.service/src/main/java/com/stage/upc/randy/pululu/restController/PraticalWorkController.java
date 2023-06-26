package com.stage.upc.randy.pululu.restController;

import com.stage.upc.randy.pululu.models.PraticalWork;
import com.stage.upc.randy.pululu.services.PraticalWorkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tp")
@CrossOrigin(origins = "http://localhost:4200")
public class PraticalWorkController {
    @Autowired
    PraticalWorkServices praticalWorkServices;

    @RequestMapping(method =  RequestMethod.GET)
    public List<PraticalWork> getAllPraticalWorks(){
        return praticalWorkServices.getAllPraticalWorks();
    }

    @RequestMapping(value="/{id}",method =  RequestMethod.GET)
    public PraticalWork getPraticalWorkById(@PathVariable("id") Long id){
        return praticalWorkServices.getPraticalWorkByid(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PraticalWork createPraticalWork(@RequestBody PraticalWork praticalWork) {
        return praticalWorkServices.savePraticalWork(praticalWork);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public PraticalWork updatePraticalWork(@RequestBody PraticalWork praticalWork) {
        return praticalWorkServices.updatePraticalWork(praticalWork);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deletePraticalWork(@PathVariable("id") Long id) {
        praticalWorkServices.delelePraticalWorkById(id);
    }
}
