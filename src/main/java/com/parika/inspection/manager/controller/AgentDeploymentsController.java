package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.AgentDeployments;
import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.services.AgentDeploymentService;
import com.parika.inspection.manager.util.AgentDeploymentInputHandle;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;
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

    @ApiOperation(value="Create a Agent Deployment")
    @PostMapping("")
    public ResponseEntity<AgentDeployments> createAgentDeployment(@RequestBody AgentDeploymentInputHandle agentDeploymentInputHandle){
        return new ResponseEntity<AgentDeployments>(agentDeploymentService.createAgentDeployments(agentDeploymentInputHandle), HttpStatus.CREATED);
    }
    @ApiOperation(value="Retrieve a list of Agent Deployment Role")
    @GetMapping()
    Page<AgentDeployments> getAllAgentDeployments(@RequestParam Optional<Integer> fieldAgents,
                                                  @RequestParam Optional<Integer> parkingAreaId,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int sizePage,
                                                  @RequestParam(defaultValue = "id") String sortBy){
        return agentDeploymentService.getAllAgentDeployments(fieldAgents,parkingAreaId,page,sizePage,sortBy);
    }

    @ApiOperation(value="Retrieve single Agent Deployment by using ID")
    @GetMapping("/{id}")
    public AgentDeployments getAgentDeploymentsById(@PathVariable("id") int id){
        return agentDeploymentService.getSingleAgentDeployments(id);
    }
    @ApiOperation(value="Update a Agent Deployment by using ID")
    @PutMapping("/{id}")
    public ResponseEntity<AgentDeployments> updateAgentDeployments(@RequestBody AgentDeploymentInputHandle agentDeploymentInputHandle, @PathVariable("id") int id){
        return new ResponseEntity<AgentDeployments>(agentDeploymentService.updateAgentDeployments(agentDeploymentInputHandle,id),HttpStatus.OK);
    }
    @ApiOperation(value="Delete a Agent Deployment by using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgentDeployments(@PathVariable("id") int id){
        agentDeploymentService.deleteAgentDeployments(id);
        return new ResponseEntity<String>("This Agent Deployment deletion successfully!!!",HttpStatus.OK);
    }
}
