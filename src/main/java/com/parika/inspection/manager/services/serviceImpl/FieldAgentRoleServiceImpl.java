package com.parika.inspection.manager.services.serviceImpl;
import com.parika.inspection.manager.models.Status;
import com.parika.inspection.manager.repositories.StatusesRepo;
import org.springframework.data.domain.Page;
import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.repositories.FieldAgentRoleRepository;
import com.parika.inspection.manager.services.FieldAgentRoleService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class FieldAgentRoleServiceImpl implements FieldAgentRoleService {
    private FieldAgentRoleRepository fieldAgentRoleRepository;
    private StatusesRepo statusesRepo;

    public FieldAgentRoleServiceImpl(FieldAgentRoleRepository fieldAgentRoleRepository, StatusesRepo statusesRepo) {
        super();
        this.fieldAgentRoleRepository = fieldAgentRoleRepository;
        this.statusesRepo = statusesRepo;
    }

    @Override
    public FieldAgentRole createFieldAgentRole(FieldAgentRole fieldAgentRole) {

        if(fieldAgentRole.getRoleName() == null){
            throw new ApiRequestException("please field agent name");
        } else if (fieldAgentRole.getStatus() == null) {
            throw new ApiRequestException("please provide the status id");
        } else if (fieldAgentRole.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {
            //check if status id exist
            Status status = statusesRepo.findById(fieldAgentRole.getStatus().getId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));
            fieldAgentRole.setStatus(status);
            fieldAgentRole.setUpdatedBy(fieldAgentRole.getCreatedBy());
            fieldAgentRole.setCreatedOnDt(LocalDateTime.now());
            fieldAgentRole.setUpdatedOnDt(LocalDateTime.now());
            return fieldAgentRoleRepository.save(fieldAgentRole);
        }
    }

    @Override
    public Page<FieldAgentRole> getAllFieldAgentRole(int page, int sizePage, String sortBy) {
        return fieldAgentRoleRepository.findAll(PageRequest.of(page,sizePage , Sort.Direction.ASC ,sortBy));
    }

    @Override
    public FieldAgentRole getSingleFieldAgentRole(int id) {
        return fieldAgentRoleRepository.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
    }

    @Override
    public FieldAgentRole updateTariff(FieldAgentRole fieldAgentRole, int id) {

        //check if field agent role id exist into database
        FieldAgentRole fieldAgentRoleExist = fieldAgentRoleRepository.findById(id).orElseThrow(()->new ApiRequestException("This field agent role id don't exist in our database"));

        if(fieldAgentRole.getRoleName() == null){
            throw new ApiRequestException("please field agent name");
        } else if (fieldAgentRole.getStatus() == null) {
            throw new ApiRequestException("please provide the status id");
        } else if (fieldAgentRole.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {
            //check if status id exist
            Status status = statusesRepo.findById(fieldAgentRole.getStatus().getId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));
            fieldAgentRoleExist.setRoleName(fieldAgentRole.getRoleName());
            fieldAgentRole.setStatus(status);
            fieldAgentRoleExist.setCreatedBy(fieldAgentRoleExist.getCreatedBy());
            fieldAgentRoleExist.setUpdatedBy(fieldAgentRole.getUpdatedBy());
            fieldAgentRoleExist.setCreatedOnDt(fieldAgentRoleExist.getCreatedOnDt());
            fieldAgentRoleExist.setUpdatedOnDt(LocalDateTime.now());
            return fieldAgentRoleRepository.save(fieldAgentRoleExist);
        }
    }

    @Override
    public void deleteFieldAgentRole(int id) {
        fieldAgentRoleRepository.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
        fieldAgentRoleRepository.deleteById(id);
    }
}
