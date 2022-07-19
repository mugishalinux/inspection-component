package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.util.AgentDeploymentInputHandle;

import java.util.List;

public interface AgentDeploymentService {

    AgentDeployments createAgentDeployments(AgentDeploymentInputHandle agentDeploymentInputHandle);

    List<AgentDeployments> getAllAgentDeployments();

    AgentDeployments getSingleAgentDeployments(int id);

    AgentDeployments updateAgentDeployments(AgentDeploymentInputHandle agentDeploymentInputHandle, int id);

    void deleteAgentDeployments(int id);

}
