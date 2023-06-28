package com.stage.upc.randy.pululu.restController;

import com.stage.upc.randy.pululu.models.InternshipReport;
import com.stage.upc.randy.pululu.services.InternShipReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "http://localhost:4200")
public class InternshipController {
    @Autowired
    InternShipReportServices internShipReportServices;

    @RequestMapping(method =  RequestMethod.GET)
    public List<InternshipReport> getAllReports(){
        return internShipReportServices.getAllReports();
    }

    @RequestMapping(value="/{id}",method =  RequestMethod.GET)
    public InternshipReport getUserById(@PathVariable("id") Long id){
        return internShipReportServices.getReportById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public InternshipReport createReport(@RequestBody InternshipReport report) {
        return internShipReportServices.saveReport(report);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public InternshipReport updateReport(@RequestBody InternshipReport report) {
        return internShipReportServices.updateReport(report);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteReport(@PathVariable("id") Long id) {
        internShipReportServices.deleteReportById(id);
    }
}
