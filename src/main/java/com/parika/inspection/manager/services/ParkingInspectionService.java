package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingInspections;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import com.parika.inspection.manager.util.ParkingIspInputHandle;

import java.util.List;

public interface ParkingInspectionService {

    ParkingInspections createParkingInspections(ParkingIspInputHandle parkingIspInputHandle);

    List<ParkingInspections> getAllParkingInspections();

    ParkingInspections getSingleParkingInspectionsById(int id);

    ParkingInspections updateParkingInspections(ParkingIspInputHandle parkingIspInputHandle, int id);

    void deleteParkingInspections(int id);
}
