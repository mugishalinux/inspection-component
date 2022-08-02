package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingInspectionsRepo extends JpaRepository<ParkingInspections, Integer> {
    List<ParkingInspections> findBySlotId(ParkingSlot parkingSlot, Pageable pageable);
    List<ParkingInspections> findByFieldAgents(FieldAgents fieldAgents, Pageable pageable);
    List<ParkingInspections> findByVehicle(Vehicle vehicle, Pageable pageable);
    List<ParkingInspections> findBySlotIdAndFieldAgentsAndVehicle(ParkingSlot parkingSlot,FieldAgents fieldAgents,Vehicle vehicle,Pageable pageable);
}
