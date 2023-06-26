package com.stage.upc.randy.pululu.services;

import com.stage.upc.randy.pululu.models.EndOfCycleWork;
import com.stage.upc.randy.pululu.models.Work;

import java.util.List;

public interface EndOfCycleWorkServices {
    EndOfCycleWork saveWork(EndOfCycleWork a);
    EndOfCycleWork updateWork(EndOfCycleWork a);
    void deleteWork(EndOfCycleWork a);
    void deleteWorkById(Long id);
    Work getWork(Long id);
    List<EndOfCycleWork> getAllWorks();
}
