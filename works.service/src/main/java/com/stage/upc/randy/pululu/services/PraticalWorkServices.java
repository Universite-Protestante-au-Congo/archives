package com.stage.upc.randy.pululu.services;

import com.stage.upc.randy.pululu.models.PraticalWork;

import java.util.List;

public interface PraticalWorkServices {
    PraticalWork savePraticalWork(PraticalWork p);
    PraticalWork updatePraticalWork(PraticalWork p);
    void deletePraticalWork(PraticalWork p);
    void delelePraticalWorkById(Long id);
    PraticalWork getPraticalWorkByid(Long id);
    List<PraticalWork> getAllPraticalWorks();
}
