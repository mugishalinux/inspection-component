package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface FieldAgentService {

    FieldAgents createFieldAgents(FieldAgentInputHandel fieldAgentInputHandel);

    Page<FieldAgents> getAllFieldAgents(Optional<Integer> profile, Optional<Integer> roleId, int page, int sizePage, String sortBy);

    FieldAgents getSingleFieldAgentsById(int id);

    FieldAgents updateFieldAgents(FieldAgentInputHandel fieldAgentInputHandel, int id);

    void deleteFieldAgents(int id);
}
