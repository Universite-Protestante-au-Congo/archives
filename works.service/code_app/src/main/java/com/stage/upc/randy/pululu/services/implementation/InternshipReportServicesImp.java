package com.stage.upc.randy.pululu.services.implementation;

import com.stage.upc.randy.pululu.models.InternshipReport;
import com.stage.upc.randy.pululu.repository.InternshipReportRepository;
import com.stage.upc.randy.pululu.services.InternShipReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InternshipReportServicesImp implements InternShipReportServices {
    @Autowired
    InternshipReportRepository internshipReportRepository;
    @Override
    public InternshipReport saveReport(InternshipReport i) {
        return internshipReportRepository.save(i);
    }

    @Override
    public InternshipReport updateReport(InternshipReport i) {
        return internshipReportRepository.save(i);
    }

    @Override
    public void deleteReport(InternshipReport i) {
        internshipReportRepository.delete(i);
    }

    @Override
    public void deleteReportById(Long id) {
        internshipReportRepository.deleteById(id);
    }

    @Override
    public InternshipReport getReportById(Long id) {
        return internshipReportRepository.findById(id).get();
    }

    @Override
    public List<InternshipReport> getAllReports() {
        return internshipReportRepository.findAll();
    }
}
