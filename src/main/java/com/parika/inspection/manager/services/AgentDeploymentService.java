package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.util.AgentDeploymentInputHandle;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface AgentDeploymentService {

    AgentDeployments createAgentDeployments(AgentDeploymentInputHandle agentDeploymentInputHandle);

    Page<AgentDeployments> getAllAgentDeployments(Optional<Integer> fieldAgent, Optional<Integer> parkingAreaId, int page, int sizePage, String sortBy);

    AgentDeployments getSingleAgentDeployments(int id);

    AgentDeployments updateAgentDeployments(AgentDeploymentInputHandle agentDeploymentInputHandle, int id);

    void deleteAgentDeployments(int id);

}
