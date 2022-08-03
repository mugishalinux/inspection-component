package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.services.FieldSupervisionService;
import org.springframework.stereotype.Service;

@Service
public class FieldSupervisionServiceImpl implements FieldSupervisionService {
//    private FieldAgentsRepo fieldAgentsRepo;
//    private FieldSupervisionRepo fieldSupervisionRepo;
//
//    public FieldSupervisionServiceImpl(FieldAgentsRepo fieldAgentsRepo, FieldSupervisionRepo fieldSupervisionRepo) {
//        this.fieldAgentsRepo = fieldAgentsRepo;
//        this.fieldSupervisionRepo = fieldSupervisionRepo;
//    }
//
//    @Override
//    public FieldSupervision createFieldSupervision(FieldSupervisionDto fieldSupervisionInputHandle) {
//
//        if(fieldSupervisionInputHandle.getGetSuperviseId() == 0){
//            throw new ApiRequestException("please provide list of people to be supervised id");
//        } else if (fieldSupervisionInputHandle.getSupervisorId() == 0) {
//            throw new ApiRequestException("please provide the id of field agent with role of supervisor");
//        } else if (fieldSupervisionInputHandle.getStartTime() == 0) {
//            throw new ApiRequestException("please provide the start time");
//        } else if (fieldSupervisionInputHandle.getEndTime() == 0) {
//            throw new ApiRequestException("please provide the end time");
//        } else if (fieldSupervisionInputHandle.getStatusId() == 0) {
//            throw new ApiRequestException("please provide the status id");
//        }else if (fieldSupervisionInputHandle.getEndTime() == 0) {
//            throw new ApiRequestException("please provide the creator name");
//        }else {
//            // check if a field agent id with role of supervisor exist
//            FieldAgents fieldAgentSup = fieldAgentsRepo.findById(fieldSupervisionInputHandle.getSupervisorId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
//
//            // check if a field agent id with role of supervisor exist
//            FieldAgents fieldAgent = fieldAgentsRepo.findById(fieldSupervisionInputHandle.getSupervisorId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
//
////            int list = fieldSupervisionInputHandle.getSupervisorId();
////
////            for(int i=0; i < fieldSupervisionInputHandle.getGetSuperviseId().length ; i++){
////                fieldAgentsRepo.findById(fieldSupervisionInputHandle.getSupervisorId().[i])
////            }
//
//            FieldSupervision fieldSupervision = new FieldSupervision();
//            fieldSupervision.setSupervisorId(fieldAgentSup);
//            fieldSupervision.setSuperviseeId(fieldAgent);
//            fieldSupervision.setStartTime(fieldSupervisionInputHandle.getStartTime());
//            fieldSupervision.setEndTime(fieldSupervisionInputHandle.getEndTime());
//            fieldSupervision.setStatusId(fieldSupervisionInputHandle.getStatusId());
//            fieldSupervision.setCreatedAt(LocalDateTime.now());
//            fieldSupervision.setUpdatedAt(LocalDateTime.now());
//            fieldSupervision.setUpdatedBy(fieldSupervisionInputHandle.getCreatedBy());
//            return fieldSupervisionRepo.save(fieldSupervision);
//        }
//    }
//
//    @Override
//    public List<FieldSupervision> getAllFieldSupervision() {
//        return fieldSupervisionRepo.findAll();
//    }
//
//    @Override
//    public FieldSupervision getSingleFieldSupervisionById(int id) {
//
//        FieldAgents fieldAgent = fieldAgentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
//        return (FieldSupervision) fieldSupervisionRepo.findBysupervisorId(fieldAgent);
////        List  <FieldSupervision>  fieldSupervisions = fieldSupervisionRepo.findByFieldSupervisionId(fld);
////
//    }
//
//    @Override
//    public FieldSupervision updateFieldSupervision(FieldSupervisionDto fieldSupervisionInputHandle, int id) {
//
//        FieldSupervision fieldSupervision = fieldSupervisionRepo.findById(id).orElseThrow(()->new ApiRequestException("This field supervision id don't exist in our database"));
//
//        if(fieldSupervisionInputHandle.getGetSuperviseId() == 0){
//            throw new ApiRequestException("please provide list of people to be supervised id");
//        } else if (fieldSupervisionInputHandle.getSupervisorId() == 0) {
//            throw new ApiRequestException("please provide the id of field agent with role of supervisor");
//        } else if (fieldSupervisionInputHandle.getStartTime() == 0) {
//            throw new ApiRequestException("please provide the start time");
//        } else if (fieldSupervisionInputHandle.getEndTime() == 0) {
//            throw new ApiRequestException("please provide the end time");
//        } else if (fieldSupervisionInputHandle.getStatusId() == 0) {
//            throw new ApiRequestException("please provide the status id");
//        }else if (fieldSupervisionInputHandle.getEndTime() == 0) {
//            throw new ApiRequestException("please provide the creator name");
//        }else {
//            // check if a field agent id with role of supervisor exist
//            FieldAgents fieldAgentSup = fieldAgentsRepo.findById(fieldSupervisionInputHandle.getSupervisorId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
//
//            // check if a field agent id with role of supervisor exist
//            FieldAgents fieldAgent = fieldAgentsRepo.findById(fieldSupervisionInputHandle.getSupervisorId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
//
////            int list = fieldSupervisionInputHandle.getSupervisorId();
////
////            for(int i=0; i < fieldSupervisionInputHandle.getGetSuperviseId().length ; i++){
////                fieldAgentsRepo.findById(fieldSupervisionInputHandle.getSupervisorId().[i])
////            }
//
//
//            fieldSupervision.setSupervisorId(fieldAgentSup);
//            fieldSupervision.setSuperviseeId(fieldAgent);
//            fieldSupervision.setStartTime(fieldSupervisionInputHandle.getStartTime());
//            fieldSupervision.setEndTime(fieldSupervisionInputHandle.getEndTime());
//            fieldSupervision.setStatusId(fieldSupervisionInputHandle.getStatusId());
//            fieldSupervision.setCreatedAt(fieldSupervision.getCreatedAt());
//            fieldSupervision.setUpdatedAt(LocalDateTime.now());
//            fieldSupervision.setUpdatedBy(fieldSupervisionInputHandle.getUpdatedBy());
//            return fieldSupervisionRepo.save(fieldSupervision);
//        }
//    }
//
//    @Override
//    public void deleteFieldSupervision(int id) {
//        fieldSupervisionRepo.findById(id).orElseThrow(()->new ApiRequestException("This field supervision id don't exist in our database"));
//        fieldSupervisionRepo.deleteById(id);
//    }
}
