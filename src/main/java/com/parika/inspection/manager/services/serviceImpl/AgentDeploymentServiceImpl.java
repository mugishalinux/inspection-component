package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingArea;
import com.parika.inspection.manager.repositories.AgentDeploymentsRepo;
import com.parika.inspection.manager.repositories.FieldAgentsRepo;
import com.parika.inspection.manager.repositories.ParkingAreaRepo;
import com.parika.inspection.manager.repositories.StatusesRepo;
import com.parika.inspection.manager.services.AgentDeploymentService;
import com.parika.inspection.manager.dto.AgentDeploymentDto;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
    public AgentDeployments createAgentDeployments(AgentDeploymentDto agentDeploymentDto) {
            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(agentDeploymentDto.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
            //check if parking id exist into database
            ParkingArea parkingAreaExist = parkingAreaRepo.findById(agentDeploymentDto.getParkingId()).orElseThrow(()->new ApiRequestException("This Parking Area id don't exist in our database"));
            try{
                AgentDeployments agentDeployments = new AgentDeployments();
                agentDeployments.setFieldAgents(fieldAgent);
                agentDeployments.setParkingAreaId(parkingAreaExist);
                agentDeployments.setDeploymentStartTime(LocalDateTime.now());
                agentDeployments.setDeploymentEndTime(LocalDateTime.now());
                agentDeployments.setStatus(null);
                agentDeployments.setCreatedOnDt(new Date());
                agentDeployments.setCreatedBy(null);
                agentDeployments.setUpdatedBy(null);
                agentDeployments.setUpdatedOnDt(new Date());
                return agentDeploymentsRepo.save(agentDeployments);
            }catch (Exception e){
                throw new ApiRequestException(e.getMessage());
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
    public AgentDeployments updateAgentDeployments(AgentDeploymentDto agentDeploymentDto, int id) {

        //check if agent deployment exist into database
        AgentDeployments agentDeployments = agentDeploymentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This agent deployment id don't exist in our database"));
            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(agentDeploymentDto.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
            //check if parking id exist into database
            ParkingArea parkingAreaExist = parkingAreaRepo.findById(agentDeploymentDto.getParkingId()).orElseThrow(()->new ApiRequestException("This Parking Area id don't exist in our database"));
            try{
                agentDeployments.setFieldAgents(fieldAgent);
                agentDeployments.setParkingAreaId(parkingAreaExist);
                agentDeployments.setDeploymentStartTime(agentDeployments.getDeploymentStartTime());
                agentDeployments.setDeploymentEndTime(agentDeployments.getDeploymentEndTime());
                agentDeployments.setStatus(null);
                agentDeployments.setCreatedBy(agentDeployments.getCreatedBy());
                agentDeployments.setUpdatedBy(null);
                agentDeployments.setCreatedOnDt(agentDeployments.getCreatedOnDt());
                agentDeployments.setUpdatedOnDt(new Date());
                return agentDeploymentsRepo.save(agentDeployments);
            }catch (Exception e){
                throw new ApiRequestException(e.getMessage());
            }
    }

    @Override
    public void deleteAgentDeployments(int id) {
        agentDeploymentsRepo.findById(id).orElseThrow(()->new ApiRequestException("This agent deployment id don't exist in our database"));
        try{
            agentDeploymentsRepo.deleteById(id);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
