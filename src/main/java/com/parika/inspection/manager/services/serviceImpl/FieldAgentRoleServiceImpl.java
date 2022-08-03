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
import java.util.Date;
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
        try{
            fieldAgentRole.setStatus(null);
            fieldAgentRole.setUpdatedBy(fieldAgentRole.getCreatedBy());
            fieldAgentRole.setCreatedOnDt(new Date());
            fieldAgentRole.setUpdatedOnDt(new Date());
            return fieldAgentRoleRepository.save(fieldAgentRole);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
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
        try{
            fieldAgentRoleExist.setRoleName(fieldAgentRole.getRoleName());
            fieldAgentRole.setStatus(null);
            fieldAgentRoleExist.setCreatedBy(fieldAgentRoleExist.getCreatedBy());
            fieldAgentRoleExist.setUpdatedBy(fieldAgentRole.getUpdatedBy());
            fieldAgentRoleExist.setCreatedOnDt(fieldAgentRoleExist.getCreatedOnDt());
            fieldAgentRoleExist.setUpdatedOnDt(new Date());
            return fieldAgentRoleRepository.save(fieldAgentRoleExist);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }

    @Override
    public void deleteFieldAgentRole(int id) {
        fieldAgentRoleRepository.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
        try {
            fieldAgentRoleRepository.deleteById(id);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
