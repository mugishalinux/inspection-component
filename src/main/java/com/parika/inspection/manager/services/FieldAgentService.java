package com.parika.inspection.manager.services;

import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import org.springframework.stereotype.Service;

import java.util.List;
public interface FieldAgentService {

    FieldAgents createFieldAgents(FieldAgentInputHandel fieldAgentInputHandel);

    List<FieldAgents> getAllFieldAgents();

    FieldAgents getSingleFieldAgentsById(int id);

    FieldAgents updateFieldAgents(FieldAgentInputHandel fieldAgentInputHandel, int id);

    void deleteFieldAgents(int id);
}
