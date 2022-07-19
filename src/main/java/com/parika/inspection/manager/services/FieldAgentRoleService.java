package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.FieldAgentRole;

import java.util.List;

public interface FieldAgentRoleService {

    FieldAgentRole createFieldAgentRole(FieldAgentRole fieldAgentRole);

    List<FieldAgentRole> getAllFieldAgentRole();

    FieldAgentRole getSingleFieldAgentRole(int id);

    FieldAgentRole updateTariff(FieldAgentRole fieldAgentRole, int id);

    void deleteFieldAgentRole(int id);
}
