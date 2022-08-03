package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.Profiles;
import com.parika.inspection.manager.models.Status;
import com.parika.inspection.manager.repositories.*;
import com.parika.inspection.manager.services.FieldAgentService;
import com.parika.inspection.manager.dto.FieldAgentDto;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public FieldAgents createFieldAgents(FieldAgentDto fieldAgentDto) {
            //check if profile exist into database
            Profiles profilesExist = profilesRepo.findById(fieldAgentDto.getProfileId()).orElseThrow(()->new ApiRequestException("This Profile don't exist in our database"));
            //check if field agent role id exist into database
            FieldAgentRole fieldAgentRoleExist = fieldAgentRoleRepository.findById(fieldAgentDto.getRoleId()).orElseThrow(()->new ApiRequestException("This field agent role id don't exist in our database"));
            try{
                FieldAgents fieldAgent = new FieldAgents();
                fieldAgent.setProfiles(profilesExist);
                fieldAgent.setRoleId(fieldAgentRoleExist);
                fieldAgent.setRegistrationDate(new Date());
                fieldAgent.setStatus(null);
                fieldAgent.setCreatedBy(null);
                fieldAgent.setUpdatedBy(null);
                fieldAgent.setCreatedOnDt(new Date());
                fieldAgent.setUpdatedOnDt(new Date());
                return fieldAgentsRepo.save(fieldAgent);
            }catch (Exception e){
                throw new ApiRequestException(e.getMessage());
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
    public FieldAgents updateFieldAgents(FieldAgentDto fieldAgentDto, int id) {

             //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
            //check if profile exist into database
            Profiles profilesExist = profilesRepo.findById(fieldAgentDto.getProfileId()).orElseThrow(()->new ApiRequestException("This Profile don't exist in our database"));

            //check if field agent role id exist into database
            FieldAgentRole fieldAgentRoleExist = fieldAgentRoleRepository.findById(fieldAgentDto.getRoleId()).orElseThrow(()->new ApiRequestException("This field agent role id don't exist in our database"));
        try{
            fieldAgent.setProfiles(profilesExist);
            fieldAgent.setRoleId(fieldAgentRoleExist);
            fieldAgent.setRegistrationDate(new Date());
            fieldAgent.setStatus(null);
            fieldAgent.setCreatedBy(fieldAgent.getCreatedBy());
            fieldAgent.setUpdatedBy(null);
            fieldAgent.setCreatedOnDt(fieldAgent.getCreatedOnDt());
            fieldAgent.setUpdatedOnDt(new Date());
            return fieldAgentsRepo.save(fieldAgent);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }

    @Override
    public void deleteFieldAgents(int id) {
        fieldAgentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
        try{
            fieldAgentsRepo.deleteById(id);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
