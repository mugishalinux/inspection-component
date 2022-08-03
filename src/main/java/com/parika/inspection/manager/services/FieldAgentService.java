package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.dto.FieldAgentDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface FieldAgentService {

    FieldAgents createFieldAgents(FieldAgentDto fieldAgentDto);

    Page<FieldAgents> getAllFieldAgents(Optional<Integer> profile, Optional<Integer> roleId, int page, int sizePage, String sortBy);

    FieldAgents getSingleFieldAgentsById(int id);

    FieldAgents updateFieldAgents(FieldAgentDto fieldAgentDto, int id);

    void deleteFieldAgents(int id);
}
