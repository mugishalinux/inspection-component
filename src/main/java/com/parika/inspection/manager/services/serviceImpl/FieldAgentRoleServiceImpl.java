package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.repositories.FieldAgentRoleRepository;
import com.parika.inspection.manager.services.FieldAgentRoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class FieldAgentRoleServiceImpl implements FieldAgentRoleService {
    private FieldAgentRoleRepository fieldAgentRoleRepository;

    public FieldAgentRoleServiceImpl(FieldAgentRoleRepository fieldAgentRoleRepository) {
        super();
        this.fieldAgentRoleRepository = fieldAgentRoleRepository;
    }

    @Override
    public FieldAgentRole createFieldAgentRole(FieldAgentRole fieldAgentRole) {

        if(fieldAgentRole.getRoleName() == null){
            throw new ApiRequestException("please field agent name");
        } else if (fieldAgentRole.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (fieldAgentRole.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {
            fieldAgentRole.setUpdatedBy(fieldAgentRole.getCreatedBy());
            fieldAgentRole.setCreatedAt(LocalDateTime.now());
            fieldAgentRole.setUpdatedAt(LocalDateTime.now());
            return fieldAgentRoleRepository.save(fieldAgentRole);
        }
    }

    @Override
    public List<FieldAgentRole> getAllFieldAgentRole() {
        return fieldAgentRoleRepository.findAll();
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
        } else if (fieldAgentRole.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (fieldAgentRole.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {
            fieldAgentRoleExist.setRoleName(fieldAgentRole.getRoleName());
            fieldAgentRoleExist.setStatusId(fieldAgentRole.getStatusId());
            fieldAgentRoleExist.setCreatedBy(fieldAgentRoleExist.getCreatedBy());
            fieldAgentRoleExist.setUpdatedBy(fieldAgentRole.getUpdatedBy());
            fieldAgentRoleExist.setCreatedAt(fieldAgentRoleExist.getCreatedAt());
            fieldAgentRoleExist.setUpdatedAt(LocalDateTime.now());
            return fieldAgentRoleRepository.save(fieldAgentRoleExist);
        }
    }

    @Override
    public void deleteFieldAgentRole(int id) {
        fieldAgentRoleRepository.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
        fieldAgentRoleRepository.deleteById(id);
    }
}
