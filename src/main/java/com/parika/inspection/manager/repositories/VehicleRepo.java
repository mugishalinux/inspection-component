package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
}
