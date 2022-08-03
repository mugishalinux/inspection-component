package com.parika.inspection.manager.services;
import org.springframework.data.domain.Page;
import com.parika.inspection.manager.models.ParkingInspections;
import com.parika.inspection.manager.dto.ParkingInspectionDto;

import java.util.Optional;

public interface ParkingInspectionService {

    ParkingInspections createParkingInspections(ParkingInspectionDto parkingInspectionDto);

    Page<ParkingInspections> getAllParkingInspections(Optional<Integer> slotId,Optional<Integer> fieldAgentId,Optional<Integer> vehicleId, int page, int sizePage, String sortBy);

    ParkingInspections getSingleParkingInspectionsById(int id);

    ParkingInspections updateParkingInspections(ParkingInspectionDto parkingInspectionDto, int id);

    void deleteParkingInspections(int id);
}
