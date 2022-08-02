package com.parika.inspection.manager.services;
import org.springframework.data.domain.Page;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingInspections;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import com.parika.inspection.manager.util.ParkingIspInputHandle;

import java.util.List;
import java.util.Optional;

public interface ParkingInspectionService {

    ParkingInspections createParkingInspections(ParkingIspInputHandle parkingIspInputHandle);

    Page<ParkingInspections> getAllParkingInspections(Optional<Integer> slotId,Optional<Integer> fieldAgentId,Optional<Integer> vehicleId, int page, int sizePage, String sortBy);

    ParkingInspections getSingleParkingInspectionsById(int id);

    ParkingInspections updateParkingInspections(ParkingIspInputHandle parkingIspInputHandle, int id);

    void deleteParkingInspections(int id);
}
