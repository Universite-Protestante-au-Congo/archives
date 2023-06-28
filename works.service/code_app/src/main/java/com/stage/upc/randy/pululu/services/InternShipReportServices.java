package com.stage.upc.randy.pululu.services;

import com.stage.upc.randy.pululu.models.InternshipReport;

import java.util.List;

public interface InternShipReportServices {
    InternshipReport saveReport(InternshipReport i);
    InternshipReport updateReport(InternshipReport i);
    void deleteReport(InternshipReport i);
    void deleteReportById(Long id);
    InternshipReport getReportById(Long id);
    List<InternshipReport> getAllReports();
}
