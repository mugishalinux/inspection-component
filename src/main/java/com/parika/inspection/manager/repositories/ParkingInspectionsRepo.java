package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.ParkingInspections;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingInspectionsRepo extends JpaRepository<ParkingInspections, Integer> {
}
