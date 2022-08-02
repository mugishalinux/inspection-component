package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.Profiles;
import com.parika.inspection.manager.models.Status;
import com.parika.inspection.manager.repositories.*;
import com.parika.inspection.manager.services.FieldAgentService;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FieldAgentServiceImpl implements FieldAgentService {
    private FieldAgentRoleRepository fieldAgentRoleRepository;
    private ProfilesRepo profilesRepo;
    private FieldAgentsRepo fieldAgentsRepo;
    private StatusesRepo statusesRepo;

    public FieldAgentServiceImpl(FieldAgentRoleRepository fieldAgentRoleRepository, ProfilesRepo profilesRepo, FieldAgentsRepo fieldAgentsRepo, StatusesRepo statusesRepo) {
        super();
        this.fieldAgentRoleRepository = fieldAgentRoleRepository;
        this.profilesRepo = profilesRepo;
        this.fieldAgentsRepo = fieldAgentsRepo;
        this.statusesRepo = statusesRepo;
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
            //check if status id exist
            Status status = statusesRepo.findById(fieldAgentInputHandel.getStatusId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));

            FieldAgents fieldAgent = new FieldAgents();
            fieldAgent.setProfiles(profilesExist);
            fieldAgent.setRoleId(fieldAgentRoleExist);
            fieldAgent.setRegistrationDate(LocalDateTime.now());
            fieldAgent.setStatus(status);

            fieldAgent.setCreatedBy(fieldAgentInputHandel.getCreatedBy());
            fieldAgent.setUpdatedBy(fieldAgentInputHandel.getCreatedBy());
            fieldAgent.setCreatedOnDt(LocalDateTime.now());
            fieldAgent.setUpdatedOnDt(LocalDateTime.now());
            return fieldAgentsRepo.save(fieldAgent);
        }
    }

    @Override
    public Page<FieldAgents> getAllFieldAgents(Optional<Integer> profile, Optional<Integer> roleId, int page, int sizePage, String sortBy) {
        if(profile.isPresent() && !roleId.isPresent()){
            //check if profile exist into database
            Profiles profilesExist = profilesRepo.findById(profile.get()).orElseThrow(()->new ApiRequestException("This Profile don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<FieldAgents> slicedResult = new PageImpl<>(fieldAgentsRepo.findByProfiles(profilesExist,pageable));
            return new PageImpl<>(slicedResult.getContent());
        } else if (!profile.isPresent() && roleId.isPresent()) {
            //check if field agent role id exist into database
            FieldAgentRole fieldAgentRoleExist = fieldAgentRoleRepository.findById(roleId.get()).orElseThrow(()->new ApiRequestException("This field agent role id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<FieldAgents> slicedResult = new PageImpl<>(fieldAgentsRepo.findByRoleId(fieldAgentRoleExist,pageable));
            return new PageImpl<>(slicedResult.getContent());
        } else if (profile.isPresent() && roleId.isPresent()) {
            //check if field agent role id exist into database
            FieldAgentRole fieldAgentRoleExist = fieldAgentRoleRepository.findById(roleId.get()).orElseThrow(()->new ApiRequestException("This field agent role id don't exist in our database"));
            //check if profile exist into database
            Profiles profilesExist = profilesRepo.findById(profile.get()).orElseThrow(()->new ApiRequestException("This Profile don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<FieldAgents> slicedResult = new PageImpl<>(fieldAgentsRepo.findByProfilesAndRoleId(profilesExist,fieldAgentRoleExist,pageable));
            return new PageImpl<>(slicedResult.getContent());
        }else {
            return fieldAgentsRepo.findAll(PageRequest.of(page,sizePage , Sort.Direction.ASC ,sortBy));
        }
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
            //check if status id exist
            Status status = statusesRepo.findById(fieldAgentInputHandel.getStatusId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));

            fieldAgent.setProfiles(profilesExist);
            fieldAgent.setRoleId(fieldAgentRoleExist);
            fieldAgent.setRegistrationDate(fieldAgent.getCreatedOnDt());
            fieldAgent.setStatus(status);

            fieldAgent.setCreatedBy(fieldAgent.getCreatedBy());
            fieldAgent.setUpdatedBy(fieldAgentInputHandel.getUpdatedBy());
            fieldAgent.setCreatedOnDt(fieldAgent.getCreatedOnDt());
            fieldAgent.setUpdatedOnDt(LocalDateTime.now());
            return fieldAgentsRepo.save(fieldAgent);
        }
    }

    @Override
    public void deleteFieldAgents(int id) {
        fieldAgentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
        fieldAgentsRepo.deleteById(id);
    }
}
