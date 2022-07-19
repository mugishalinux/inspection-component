package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Integer> {
}
