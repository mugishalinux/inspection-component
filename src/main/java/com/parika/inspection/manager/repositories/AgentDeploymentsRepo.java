package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingArea;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentDeploymentsRepo extends JpaRepository<AgentDeployments, Integer> {
    List<AgentDeployments> findByFieldAgents(FieldAgents fieldAgents, Pageable pageable);
    List<AgentDeployments> findByParkingAreaId(ParkingArea parkingArea, Pageable pageable);
    List<AgentDeployments> findByFieldAgentsAndParkingAreaId(FieldAgents fieldAgents,ParkingArea parkingArea, Pageable pageable);
}
