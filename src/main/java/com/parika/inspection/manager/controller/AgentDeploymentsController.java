package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.services.AgentDeploymentService;
import com.parika.inspection.manager.dto.AgentDeploymentDto;
import com.parika.inspection.manager.util.DeleteApiResponse;
import com.parika.inspection.manager.util.PostApiResponse;
import com.parika.inspection.manager.util.PutApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/agentDeployment")
public class AgentDeploymentsController {
    private AgentDeploymentService agentDeploymentService;

    public AgentDeploymentsController(AgentDeploymentService agentDeploymentService) {
        super();
        this.agentDeploymentService = agentDeploymentService;
    }


    @PostMapping("")

    public ResponseEntity<PostApiResponse> createAgentDeployment(@RequestBody AgentDeploymentDto agentDeploymentDto){
        PostApiResponse response = new PostApiResponse();
        try{
            agentDeploymentService.createAgentDeployments(agentDeploymentDto);
            response.setMessage("Successfully");
            response.setResponseCode(HttpStatus.CREATED);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @GetMapping()
    Page<AgentDeployments> getAllAgentDeployments(@RequestParam Optional<Integer> fieldAgents,
                                                  @RequestParam Optional<Integer> parkingAreaId,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int sizePage,
                                                  @RequestParam(defaultValue = "id") String sortBy){
        return agentDeploymentService.getAllAgentDeployments(fieldAgents,parkingAreaId,page,sizePage,sortBy);
    }


    @GetMapping("/{id}")
    public AgentDeployments getAgentDeploymentsById(@PathVariable("id") int id){
        return agentDeploymentService.getSingleAgentDeployments(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutApiResponse> updateAgentDeployments(@RequestBody AgentDeploymentDto agentDeploymentDto, @PathVariable("id") int id){
        PutApiResponse response = new PutApiResponse();
        try{
            agentDeploymentService.updateAgentDeployments(agentDeploymentDto,id);
            response.setMessage("Successfully Updated");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteApiResponse> deleteAgentDeployments(@PathVariable("id") int id){
        DeleteApiResponse response = new DeleteApiResponse();
        try{
            agentDeploymentService.deleteAgentDeployments(id);
            response.setMessage("Agent Deployment Deleted");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }
}
