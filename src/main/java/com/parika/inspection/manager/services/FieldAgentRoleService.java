package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.FieldAgentRole;
import org.springframework.data.domain.Page;
import java.util.List;

public interface FieldAgentRoleService {

    FieldAgentRole createFieldAgentRole(FieldAgentRole fieldAgentRole);

    Page<FieldAgentRole> getAllFieldAgentRole(int page, int sizePage, String sortBy);

    FieldAgentRole getSingleFieldAgentRole(int id);

    FieldAgentRole updateTariff(FieldAgentRole fieldAgentRole, int id);

    void deleteFieldAgentRole(int id);
}
