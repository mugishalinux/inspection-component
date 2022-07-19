package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.Profiles;
import com.parika.inspection.manager.repositories.FieldAgentRoleRepository;
import com.parika.inspection.manager.repositories.FieldAgentsRepo;
import com.parika.inspection.manager.repositories.ProfilesRepo;
import com.parika.inspection.manager.repositories.VehicleRepo;
import com.parika.inspection.manager.services.FieldAgentService;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FieldAgentServiceImpl implements FieldAgentService {
    private FieldAgentRoleRepository fieldAgentRoleRepository;
    private ProfilesRepo profilesRepo;
    private FieldAgentsRepo fieldAgentsRepo;

    public FieldAgentServiceImpl(FieldAgentRoleRepository fieldAgentRoleRepository, ProfilesRepo profilesRepo, FieldAgentsRepo fieldAgentsRepo) {
        this.fieldAgentRoleRepository = fieldAgentRoleRepository;
        this.profilesRepo = profilesRepo;
        this.fieldAgentsRepo = fieldAgentsRepo;
    }

    @Override
    public FieldAgents createFieldAgents(FieldAgentInputHandel fieldAgentInputHandel) {

        if(fieldAgentInputHandel.getProfileId() == 0){
            throw new ApiRequestException("please provide the profile id");
        } else if (fieldAgentInputHandel.getRoleId() == 0) {
            throw new ApiRequestException("please provide the role id");
        } else if (fieldAgentInputHandel.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (fieldAgentInputHandel.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {

            //check if profile exist into database
            Profiles profilesExist = profilesRepo.findById(fieldAgentInputHandel.getProfileId()).orElseThrow(()->new ApiRequestException("This Profile don't exist in our database"));

            //check if field agent role id exist into database
            FieldAgentRole fieldAgentRoleExist = fieldAgentRoleRepository.findById(fieldAgentInputHandel.getRoleId()).orElseThrow(()->new ApiRequestException("This field agent role id don't exist in our database"));


            FieldAgents fieldAgent = new FieldAgents();
            fieldAgent.setProfiles(profilesExist);
            fieldAgent.setRoleId(fieldAgentRoleExist);
            fieldAgent.setRegistrationDate(LocalDateTime.now());
            fieldAgent.setStatusId(fieldAgentInputHandel.getStatusId());

            fieldAgent.setCreatedBy(fieldAgentInputHandel.getCreatedBy());
            fieldAgent.setUpdatedBy(fieldAgentInputHandel.getCreatedBy());
            fieldAgent.setCreatedAt(LocalDateTime.now());
            fieldAgent.setUpdatedAt(LocalDateTime.now());
            return fieldAgentsRepo.save(fieldAgent);
        }
    }

    @Override
    public List<FieldAgents> getAllFieldAgents() {
        return fieldAgentsRepo.findAll();
    }

    @Override
    public FieldAgents getSingleFieldAgentsById(int id) {
        return fieldAgentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
    }

    @Override
    public FieldAgents updateFieldAgents(FieldAgentInputHandel fieldAgentInputHandel, int id) {

        //check if field agent exist into database
        FieldAgents fieldAgent = fieldAgentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

        if(fieldAgentInputHandel.getProfileId() == 0){
            throw new ApiRequestException("please provide the profile id");
        } else if (fieldAgentInputHandel.getRoleId() == 0) {
            throw new ApiRequestException("please provide the role id");
        } else if (fieldAgentInputHandel.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (fieldAgentInputHandel.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {

            //check if profile exist into database
            Profiles profilesExist = profilesRepo.findById(fieldAgentInputHandel.getProfileId()).orElseThrow(()->new ApiRequestException("This Profile don't exist in our database"));

            //check if field agent role id exist into database
            FieldAgentRole fieldAgentRoleExist = fieldAgentRoleRepository.findById(fieldAgentInputHandel.getRoleId()).orElseThrow(()->new ApiRequestException("This field agent role id don't exist in our database"));

            fieldAgent.setProfiles(profilesExist);
            fieldAgent.setRoleId(fieldAgentRoleExist);
            fieldAgent.setRegistrationDate(fieldAgent.getCreatedAt());
            fieldAgent.setStatusId(fieldAgentInputHandel.getStatusId());

            fieldAgent.setCreatedBy(fieldAgent.getCreatedBy());
            fieldAgent.setUpdatedBy(fieldAgentInputHandel.getUpdatedBy());
            fieldAgent.setCreatedAt(fieldAgent.getCreatedAt());
            fieldAgent.setUpdatedAt(LocalDateTime.now());
            return fieldAgentsRepo.save(fieldAgent);
        }
    }

    @Override
    public void deleteFieldAgents(int id) {
        fieldAgentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
        fieldAgentsRepo.deleteById(id);
    }
}
