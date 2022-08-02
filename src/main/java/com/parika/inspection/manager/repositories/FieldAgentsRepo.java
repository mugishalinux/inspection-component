package com.parika.inspection.manager.repositories;

import com.parika.inspection.manager.models.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldAgentsRepo extends JpaRepository<FieldAgents, Integer>{
    List<FieldAgents> findByProfiles(Profiles profiles, Pageable pageable);
    List<FieldAgents> findByRoleId(FieldAgentRole fieldAgentRole, Pageable pageable);
    List<FieldAgents> findByProfilesAndRoleId(Profiles profiles,FieldAgentRole fieldAgentRole, Pageable pageable);
}
