package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.services.FieldAgentRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/fieldAgentRole")
public class FieldAgentRoleController {
    private FieldAgentRoleService fieldAgentRoleService;

    public FieldAgentRoleController(FieldAgentRoleService fieldAgentRoleService) {
        super();
        this.fieldAgentRoleService = fieldAgentRoleService;
    }
    @ApiOperation(value="Create a Field Agent Role")
    @PostMapping("")
    public ResponseEntity<FieldAgentRole> createFieldAgentRole(@RequestBody FieldAgentRole fieldAgentRole){
        return new ResponseEntity< FieldAgentRole>(fieldAgentRoleService.createFieldAgentRole(fieldAgentRole), HttpStatus.CREATED);
    }
    @ApiOperation(value="Retrieve a list of Field Agent Role")
    @GetMapping()
    List<FieldAgentRole> getAllFieldAgentRole(){
        return fieldAgentRoleService.getAllFieldAgentRole();
    }

    @ApiOperation(value="Retrieve single Field Agent Role by using ID")
    @GetMapping("/{id}")
    public FieldAgentRole getFieldAgentRoleById(@PathVariable("id") int id){
        return fieldAgentRoleService.getSingleFieldAgentRole(id);
    }
    @ApiOperation(value="Update a Field Agent Role by using ID")
    @PutMapping("/{id}")
    public ResponseEntity<FieldAgentRole> updateFieldAgentRole(@RequestBody FieldAgentRole fieldAgentRole , @PathVariable("id") int id){
        return new ResponseEntity<FieldAgentRole>(fieldAgentRoleService.updateTariff(fieldAgentRole,id),HttpStatus.OK);
    }
    @ApiOperation(value="Delete a Field Agent Role by using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFieldAgentRole(@PathVariable("id") int id){
        fieldAgentRoleService.deleteFieldAgentRole(id);
        return new ResponseEntity<String>("Field Agent Role deletion successfully!!!",HttpStatus.OK);
    }
}
