package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.services.FieldAgentService;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/fieldAgents")
public class FieldAgentsController {
    private FieldAgentService fieldAgentService;

    public FieldAgentsController(FieldAgentService fieldAgentService) {
        super();
        this.fieldAgentService = fieldAgentService;
    }
    @ApiOperation(value="Create a Field Agent")
    @PostMapping("")
    public ResponseEntity<FieldAgents> createFieldAgents(@RequestBody FieldAgentInputHandel fieldAgentInputHandel){
        return new ResponseEntity< FieldAgents>(fieldAgentService.createFieldAgents(fieldAgentInputHandel), HttpStatus.CREATED);
    }
    @ApiOperation(value="Retrieve a list of Field Agent")
    @GetMapping()
    List<FieldAgents> getAllFieldAgents(){
        return fieldAgentService.getAllFieldAgents();
    }

    @ApiOperation(value="Retrieve single Field Agent by using ID")
    @GetMapping("/{id}")
    public FieldAgents getFieldAgentsById(@PathVariable("id") int id){
        return fieldAgentService.getSingleFieldAgentsById(id);
    }
    @ApiOperation(value="Update a Field Agent by using ID")
    @PutMapping("/{id}")
    public ResponseEntity<FieldAgents> updateFieldAgents(@RequestBody FieldAgentInputHandel fieldAgentInputHandel, @PathVariable("id") int id){
        return new ResponseEntity<FieldAgents>(fieldAgentService.updateFieldAgents(fieldAgentInputHandel,id),HttpStatus.OK);
    }
    @ApiOperation(value="Delete a Field Agent Role by using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFieldAgents(@PathVariable("id") int id){
        fieldAgentService.deleteFieldAgents(id);
        return new ResponseEntity<String>("Field Agents deletion successfully!!!",HttpStatus.OK);
    }
}
