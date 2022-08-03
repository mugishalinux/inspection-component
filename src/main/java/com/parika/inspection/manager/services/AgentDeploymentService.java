package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.dto.AgentDeploymentDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AgentDeploymentService {

    AgentDeployments createAgentDeployments(AgentDeploymentDto agentDeploymentDto);

    Page<AgentDeployments> getAllAgentDeployments(Optional<Integer> fieldAgent, Optional<Integer> parkingAreaId, int page, int sizePage, String sortBy);

    AgentDeployments getSingleAgentDeployments(int id);

    AgentDeployments updateAgentDeployments(AgentDeploymentDto agentDeploymentDto, int id);

    void deleteAgentDeployments(int id);

}
