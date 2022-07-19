package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.AgentDeployments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentDeploymentsRepo extends JpaRepository<AgentDeployments, Integer> {
}
