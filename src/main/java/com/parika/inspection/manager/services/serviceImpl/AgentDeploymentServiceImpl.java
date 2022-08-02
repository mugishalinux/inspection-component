package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingArea;
import com.parika.inspection.manager.models.Status;
import com.parika.inspection.manager.repositories.AgentDeploymentsRepo;
import com.parika.inspection.manager.repositories.FieldAgentsRepo;
import com.parika.inspection.manager.repositories.ParkingAreaRepo;
import com.parika.inspection.manager.repositories.StatusesRepo;
import com.parika.inspection.manager.services.AgentDeploymentService;
import com.parika.inspection.manager.util.AgentDeploymentInputHandle;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgentDeploymentServiceImpl implements AgentDeploymentService {
    private FieldAgentsRepo fieldAgentsRepo;
    private ParkingAreaRepo parkingAreaRepo;
    private AgentDeploymentsRepo agentDeploymentsRepo;
    private StatusesRepo statusesRepo;

    public AgentDeploymentServiceImpl(FieldAgentsRepo fieldAgentsRepo, ParkingAreaRepo parkingAreaRepo, AgentDeploymentsRepo agentDeploymentsRepo, StatusesRepo statusesRepo) {
        super();
        this.fieldAgentsRepo = fieldAgentsRepo;
        this.parkingAreaRepo = parkingAreaRepo;
        this.agentDeploymentsRepo = agentDeploymentsRepo;
        this.statusesRepo = statusesRepo;
    }

    @Override
    public AgentDeployments createAgentDeployments(AgentDeploymentInputHandle agentDeploymentInputHandle) {

        if(agentDeploymentInputHandle.getFieldAgentId() == 0){
            throw new ApiRequestException("please provide the field agent id");
        } else if (agentDeploymentInputHandle.getParkingId() == 0) {
            throw new ApiRequestException("please provide the parking id");
        }else if (agentDeploymentInputHandle.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (agentDeploymentInputHandle.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {

            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(agentDeploymentInputHandle.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

            //check if parking id exist into database
            ParkingArea parkingAreaExist = parkingAreaRepo.findById(agentDeploymentInputHandle.getParkingId()).orElseThrow(()->new ApiRequestException("This Parking Area id don't exist in our database"));
            //check if status id exist
            Status status = statusesRepo.findById(agentDeploymentInputHandle.getStatusId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));

            AgentDeployments agentDeployments = new AgentDeployments();
            agentDeployments.setFieldAgents(fieldAgent);
            agentDeployments.setParkingAreaId(parkingAreaExist);
            agentDeployments.setDeploymentStartTime(LocalDateTime.now());
            agentDeployments.setDeploymentEndTime(LocalDateTime.now());
            agentDeployments.setStatus(status);
            agentDeployments.setCreatedOnDt(LocalDateTime.now());
            agentDeployments.setCreatedBy(agentDeploymentInputHandle.getCreatedBy());
            agentDeployments.setUpdatedBy(agentDeploymentInputHandle.getCreatedBy());
            agentDeployments.setUpdatedOnDt(LocalDateTime.now());
            return agentDeploymentsRepo.save(agentDeployments);
        }
    }

    @Override
    public Page<AgentDeployments> getAllAgentDeployments(Optional<Integer> fieldAgent, Optional<Integer> parkingAreaId, int page, int sizePage, String sortBy) {
        if(fieldAgent.isPresent() && !parkingAreaId.isPresent()){
            //check if field agent exist into database
            FieldAgents fieldAgentExist = fieldAgentsRepo.findById(fieldAgent.get()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<AgentDeployments> slicedResult = new PageImpl<>(agentDeploymentsRepo.findByFieldAgents(fieldAgentExist,pageable));
            return new PageImpl<>(slicedResult.getContent());
        } else if (!fieldAgent.isPresent() && parkingAreaId.isPresent()) {
            //check if parking id exist into database
            ParkingArea parkingAreaExist = parkingAreaRepo.findById(parkingAreaId.get()).orElseThrow(()->new ApiRequestException("This Parking Area id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<AgentDeployments> slicedResult = new PageImpl<>(agentDeploymentsRepo.findByParkingAreaId(parkingAreaExist,pageable));
            return new PageImpl<>(slicedResult.getContent());
        } else if (fieldAgent.isPresent() && parkingAreaId.isPresent()) {
            //check if field agent exist into database
            FieldAgents fieldAgentExist = fieldAgentsRepo.findById(fieldAgent.get()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
            //check if parking id exist into database
            ParkingArea parkingAreaExist = parkingAreaRepo.findById(parkingAreaId.get()).orElseThrow(()->new ApiRequestException("This Parking Area id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<AgentDeployments> slicedResult = new PageImpl<>(agentDeploymentsRepo.findByFieldAgentsAndParkingAreaId(fieldAgentExist,parkingAreaExist,pageable));
            return new PageImpl<>(slicedResult.getContent());
        }else {
            return agentDeploymentsRepo.findAll(PageRequest.of(page,sizePage , Sort.Direction.ASC ,sortBy));
        }
    }

    @Override
    public AgentDeployments getSingleAgentDeployments(int id) {
        return agentDeploymentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This agent deployment id don't exist in our database"));
    }

    @Override
    public AgentDeployments updateAgentDeployments(AgentDeploymentInputHandle agentDeploymentInputHandle, int id) {

        //check if agent deployment exist into database
        AgentDeployments agentDeployments = agentDeploymentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This agent deployment id don't exist in our database"));

        if(agentDeploymentInputHandle.getFieldAgentId() == 0){
            throw new ApiRequestException("please provide the field agent id");
        } else if (agentDeploymentInputHandle.getParkingId() == 0) {
            throw new ApiRequestException("please provide the parking id");
        }else if (agentDeploymentInputHandle.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (agentDeploymentInputHandle.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {

            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(agentDeploymentInputHandle.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

            //check if parking id exist into database
            ParkingArea parkingAreaExist = parkingAreaRepo.findById(agentDeploymentInputHandle.getParkingId()).orElseThrow(()->new ApiRequestException("This Parking Area id don't exist in our database"));
            //check if status id exist
            Status status = statusesRepo.findById(agentDeploymentInputHandle.getStatusId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));

            agentDeployments.setFieldAgents(fieldAgent);
            agentDeployments.setParkingAreaId(parkingAreaExist);
            agentDeployments.setDeploymentStartTime(agentDeployments.getDeploymentStartTime());
            agentDeployments.setDeploymentEndTime(agentDeployments.getDeploymentEndTime());
            agentDeployments.setStatus(status);
            agentDeployments.setCreatedBy(agentDeployments.getCreatedBy());
            agentDeployments.setUpdatedBy(agentDeploymentInputHandle.getUpdatedBy());
            agentDeployments.setCreatedOnDt(agentDeployments.getCreatedOnDt());
            agentDeployments.setUpdatedOnDt(LocalDateTime.now());
            return agentDeploymentsRepo.save(agentDeployments);
        }
    }

    @Override
    public void deleteAgentDeployments(int id) {
        agentDeploymentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This agent deployment id don't exist in our database"));
        agentDeploymentsRepo.deleteById(id);
    }
}
