package com.stage.upc.randy.pululu.restController;

import com.stage.upc.randy.pululu.models.EndOfCycleWork;
import com.stage.upc.randy.pululu.models.Work;
import com.stage.upc.randy.pululu.services.EndOfCycleWorkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
@CrossOrigin(origins = "http://localhost:4200")
public class EndOfCycleWorkController {
    @Autowired
    EndOfCycleWorkServices workServices;

    @RequestMapping(method =  RequestMethod.GET)
    public List<EndOfCycleWork> getAllWorks(){
        return workServices.getAllWorks();
    }

    @RequestMapping(value="/{id}",method =  RequestMethod.GET)
    public Work getWorkById(@PathVariable("id") Long id){
        return workServices.getWork(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Work createWork(@RequestBody EndOfCycleWork work) {
        return workServices.saveWork(work);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Work updateWork(@RequestBody EndOfCycleWork work) {
        return workServices.updateWork(work);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteWork(@PathVariable("id") Long id) {
        workServices.deleteWorkById(id);
    }
}
