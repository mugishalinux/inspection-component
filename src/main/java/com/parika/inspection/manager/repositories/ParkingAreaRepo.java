package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.ParkingArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingAreaRepo extends JpaRepository<ParkingArea, Integer> {
}
